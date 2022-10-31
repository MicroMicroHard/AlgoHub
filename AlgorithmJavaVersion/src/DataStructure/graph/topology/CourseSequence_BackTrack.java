package DataStructure.graph.topology;

import Common.Utils.ArrayTools;
import Common.Utils.UTFactory;
import org.junit.Test;

import java.util.*;

/**
 * @author liujun
 * @version V1.0
 * @date 2022/10/18 13:09
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @description 现在总共有 numCourses门课需要选，记为 0 到 numCourses-1。
 * 给定一个数组prerequisites ，它的每一个元素 prerequisites[i] 表示两门课程之间的先修顺序。
 * 例如 prerequisites[i] = [ai, bi]表示想要学习课程 ai，需要先完成课程 bi。
 * 请根据给出的总课程数 numCourses 和表示先修顺序的 prerequisites 得出一个可行的修课序列。
 * 可能会有多个正确的顺序，只要任意返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * @blogURL
 */
public class CourseSequence_BackTrack {

    @Test // 验证功能：从数据库获取测试数据，用于单元测试
    public void TestFunc() throws Exception {
        UTFactory.FullTest(this.getClass());
    }

    @Test // 调试功能 : 用于复现错误的测试案例
    public void DoubleTrack() throws Exception {
        String input = "";
        String output = "";
        UTFactory.DebugTest(this.getClass(), input, output);
    }

    public static void main(String[] args) {
        //int courseNum = 4;
        int[][] courseArray = {
                {0, 1}, {0, 2},
                {2, 3}, {1, 4}, {1, 5},
                {3, 6}, {4, 7}, {5, 7},
                {6, 8}, {7, 8},
        };
        /*int[][] courseArray = {
                {0, 1}, {0, 2},
                {2, 3}, {1, 4}, {1, 5},
                {3, 6}, {4, 7}, {5, 7},
                {6, 8}, {7, 8}, {7, 4},// {4, 7}和{7, 4}产生循环依赖
        };*/
        //int[][] courseArray = null;
        //int[][] courseArray = new int[0][0];
        /*int[][] courseArray = {
                {0, 1}, {0, 2},
        };*/
        /*int[][] courseArray = {
                {0, 1}, {0, 2},
                {1, 3}, {2, 3},
        };*/
        CourseSequence_BackTrack a = new CourseSequence_BackTrack();
        int[] ans = a.OrderCourseMethod(courseArray);
        ArrayTools.printIntArray(ans);
    }

    List<List<Integer>> CourseMap; // 课程关系图【邻接表】
    boolean ringNotExist;
    int[] visited; // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    Stack<Integer> resultStack = new Stack<>(); // stack的倒序满足最先遍历的输出
    //Queue<Integer> resultQue = new ArrayDeque<>(); // queue的输出满足最先遍历的输出

    // 深度遍历
    public int[] OrderCourseMethod(int[][] courseArray) {
        if (courseArray == null || courseArray.length == 0) {
            return null;
        }

        // get distinct course
        Map<Integer, Boolean> distinctCourse = new HashMap<>();
        for (int[] v : courseArray) {
            distinctCourse.put(v[0], true);
            distinctCourse.put(v[1], true);
        }
        int courseNum = distinctCourse.size();
        visited = new int[courseNum];
        CourseMap = new ArrayList<>();
        ringNotExist = true;

        for (int i = 0; i < courseNum; i++) {// init CourseMap
            CourseMap.add(new ArrayList<>());
        }
        for (int[] courseInfo : courseArray) {// 此处记录被指向的关系
            CourseMap.get(courseInfo[1]).add(courseInfo[0]);
        }
        // 开始遍历
        for (int i = 0; i < courseNum && ringNotExist; i++) {
            if (visited[i] == 0) {
                roll(i);
            }
        }
        /*int[] answer = new int[resultStack.size()];
        此处是bug写法，resultStack.pop()会导致resultStack.size()减小
        for (int i = 0; i < resultStack.size(); i++) {
            answer[i] = resultStack.pop();
        }*/
        if (!ringNotExist) {
            return new int[]{};
        }
        if (resultStack.size() != courseNum) {// 说明有循环依赖的情况【未执行完就退出】
            return new int[]{};
        }
        int[] ans = new int[courseNum];
        for (int i = 0; i < courseNum; i++) {
            ans[i] = resultStack.pop();
        }
        //resultStack.stream().mapToInt(x -> x).toArray(); 没有起到栈输出的作用
        return ans;
    }

    public void roll(int cur) {
        visited[cur] = 1;
        for (int curNeighbor : CourseMap.get(cur)) {
            if (visited[curNeighbor] == 0) {
                roll(curNeighbor);
                if (!ringNotExist) {
                    return;
                }
            } else if (visited[curNeighbor] == 1) {// 正在访问中，又被访问到，因此形成循环
                ringNotExist = false;
                return;
            }
        }
        visited[cur] = 2;// 访问结束
        resultStack.add(cur);
    }
}
