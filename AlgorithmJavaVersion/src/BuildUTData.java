import Algorithm.backtrack.CombinationNum_BackTrack;
import Algorithm.comprehensive.lss.LSS;
import Algorithm.dynamic.EditDistance;
import Algorithm.dynamic.palindrome.*;
import Algorithm.math.*;
import Common.MidwareConn.DBConn.MYSQLConn.UTDataEntity;
import Common.Utils.DBTools;
import Common.Utils.UTFactory;
import Common.Conf.Config;
import DataStructure.arrayRelevant.arrayApply.*;
import DataStructure.arrayRelevant.arrayOps.*;
import DataStructure.arrayRelevant.doublePoint.*;
import DataStructure.arrayRelevant.xor.*;
import DataStructure.graph.TheLeastNeighbors;
import DataStructure.graph.shortestPath.multiSourceShortestPath.Floyd;
import DataStructure.heapStackQueue.heap.WordFrequency;
import DataStructure.list.listRealize.MergeMultiList;
import DataStructure.list.listReverse.*;
import DataStructure.list.listReverse.singleListReverse.ReverseList;
import DataStructure.sort.innerSort.ArraySortINTF;
import DataStructure.sort.innerSort.ListSortINTF;
import DataStructure.stringOps.LNS.LNRSubstringINTF;
import DataStructure.stringOps.stringAndSequence.DigitalTrans;
import DataStructure.tree.binaryTree.array2BinaryTree.*;
import DataStructure.tree.binaryTree.binaryTreeApply.*;
import org.junit.Test;

import java.sql.SQLException;

import static Common.Utils.UTFactory.strTools;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2022/7/10 23:48
 * @author—Email micromicrohard@outlook.com
 * @description 1、打印测试数据
 * 2、插入测试数据
 * @blogURL
 */

public class BuildUTData {

    static Config config = new Config();
    public static DBTools dbTools = new DBTools();

    // 获取测试用例
    @Test
    public void PrintUTData() throws Exception {
        UTFactory.PrintUTData("TwoSum");
    }

    public static Class<?>[] GetAlgorithmClass() {
        return new Class<?>[]{
                // backtrack
                CombinationNum_BackTrack.class,
                // comprehensive
                // dynamic
                Palindrome_Judge.class, Palindrome_Find.class,
                ClimbStairs.class, EditDistance.class,
                LSS.class,

                // greedy

                // math
                Factorial.class, Combination.class, Permutation.class, NthPowerOfTwo.class,

                BigNumSum.class, BigNumSub.class, BigNumMulti.class
                //BigNumDiv.class,
        };
    }

    public static Class<?>[] GetDataStructureClass() throws Exception {
        return new Class<?>[]{
                // arrayRelevant -- arrayApply
                ArrayMulti.class, FindLongestSequence.class,
                // arrayRelevant -- arrayOps
                BuildTeamByTall.class, FindArraySection.class,
                // arrayRelevant -- xor
                FindNum_Treble_One.class, FindNum_Twice_Two.class, FindNum_Once_Double.class, FindNum_Twice_One.class,
                // arrayRelevant -- doublePoint
                TwoSum.class, TwoSumLikely.class, TwoSum_Position.class, TwoSum_Position_Repeat.class, ThreeSum.class, ThreeSumLikely.class,

                // graph
                TheLeastNeighbors.class, Floyd.class,

                // heapStackQueue
                WordFrequency.class,

                // list -- listRealize
                MergeMultiList.class,
                // list -- listReverse
                ReverseList.class,                 // INTF
                ListReverse_LastK_2Top.class, ListReverse_Part2_SwapPairs.class, ListReverse_PartN_impl.class, ListReverse_TwoPosition.class,

                // sort
                ArraySortINTF.class,               // INTF
                ListSortINTF.class,                // INTF

                // stringOps -- LNS
                LNRSubstringINTF.class,            // INTF
                // stringOps -- slidingWindow
                // stringOps -- stringAndSequence
                DigitalTrans.class,

                // tree -- binaryTree
                Array2BTByPreOrder.class, Array2BTByInOrder.class, Array2BTByPostOrder.class, Array2BTByPost_InOrder.class, Array2BTByPre_InOrder.class, Array2BTByLevel.class,
                BT_MirrorJudge.class, BT_MirrorOperation.class, BT_MaxBroad.class, BT_MaxDepth.class, BT_BalanceJudge.class,
        };
    }

    public UTDataEntity[] buildInsertUTData(UTDataEntity[] params, String className, String inputDesc, String outputDesc, String class_describe) {
        for (UTDataEntity param : params) {
            if (param.className == null || "".equals(param.className)) {
                param.className = className;
            }
            if (param.inputDesc == null || "".equals(param.inputDesc)) {
                param.inputDesc = inputDesc;
            }
            if (param.outputDesc == null || "".equals(param.outputDesc)) {
                param.outputDesc = outputDesc;
            }
            if (param.class_describe == null || "".equals(param.class_describe)) {
                param.class_describe = class_describe;
            }
        }
        return params;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(74));
    }

    @Test
    public void insert() throws SQLException {
        String defaultClassName = "CalDistanceOfTwoPoint";
        String defaultInputDesc = null;
        String defaultOutputDesc = null;
        String defaultClassDesc = "计算两点之间的距离";

        UTDataEntity[] entityList = new UTDataEntity[]{
                // MockData4Mysql:正案例
                new UTDataEntity(strTools.ConcatMultiParams("{1,1}", "{1,1}"), "0.0"),
                /*new UTDataEntity(strTools.ConcatMultiParams("{1,2}", "{2,4}"), "2.23606797749979"),
                new UTDataEntity(strTools.ConcatMultiParams("{-1,-1}", "{2,2}"), "4.242640687119285"),
                new UTDataEntity(strTools.ConcatMultiParams("{1,1}", "{-1,1}"), "2.0"),
                new UTDataEntity(strTools.ConcatMultiParams("{0,0}", "{3,4}"), "5.0"),
                new UTDataEntity(strTools.ConcatMultiParams("{3,7}", "{10,2}"), "8.602325267042627"),

                // MockData4Mysql:反案例
                new UTDataEntity(strTools.ConcatMultiParams("{1}", "{2,2}"),
                        "0.0"),
                new UTDataEntity(strTools.ConcatMultiParams(config.commonConfig.EmptyExpr, config.commonConfig.EmptyExpr),
                        "0.0"),
                new UTDataEntity(strTools.ConcatMultiParams(config.commonConfig.NullExpr, config.commonConfig.NullExpr),
                        "0.0"),*/
        };
        dbTools.UTData_InsertBatch(buildInsertUTData(entityList, defaultClassName, defaultInputDesc, defaultOutputDesc, defaultClassDesc));
    }
}
