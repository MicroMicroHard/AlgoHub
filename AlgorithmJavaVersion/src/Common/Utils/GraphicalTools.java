package Common.Utils;

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/27 01:55
 * @author-Email micromicrohard@outlook.com
 * @description 图形工具
 * 计算两点之间的距离 {@link GraphicalTools#cal_distance_point2point}
 * 计算点到直线的距离 {@link GraphicalTools#cal_distance_point2line}
 * 检查四个点是否构成矩阵 {@link GraphicalTools#check_matrix_exist}
 * 检查点是否在矩阵内 {@link GraphicalTools#check_point_exist_in_matrix}
 * @blogURL
 */
public class GraphicalTools {

    /**
     * @param pp1 pointPosition
     * @param pp2 pointPosition
     * @return 计算两点之间的距离 坐标x:pp1[0], 坐标y:pp1[1]
     */
    public double cal_distance_point2point(int[] pp1, int[] pp2) {
        if (pp1 == null || pp1.length != 2 || pp2 == null || pp2.length != 2) {
            return 0;
        }
        /**
         * math grammar Math.pow(a,b): a的b次方
         * math grammar Math.sqrt(c): c的平方根
         * math grammar Math.abs(e): e的绝对值
         */
        return Math.sqrt(Math.pow((pp1[0] - pp2[0]), 2)
                + Math.pow((pp1[1] - pp2[1]), 2));
    }
/*
    public static void main(String[] args) {
        GraphicalTools y = new GraphicalTools();
        System.out.println(y.cal_distance_point2point(new int[]{1, 1}, new int[]{2, 2}));
    }*/

    /**
     * @param pp pointPosition
     * @param lp linePosition
     * @return 计算点到直线的距离
     * 点 P1(x1,y1), 点 P2(x2,y2) 可知直线方程为： x(y2−y1)−y(x2−x1)+y1(x2−x1)−x1(y2−y1)=0
     */
    public double cal_distance_point2line(int[] pp, int[][] lp) {
        if (pp == null || pp.length != 2) {
            return 0.0;
        }
        // lp: 相同的点无法构成直线
        if (lp[0][0] == lp[1][0] && lp[0][1] == lp[1][1]) {
            return 0.0;
        }
        return 0;
    }

    /**
     * @param mp matrixPoint
     * @return 检查四个点是否构成矩阵
     */
    public boolean check_matrix_exist(int[][] mp) {
        return false;
    }

    /**
     * @param pp pointPosition
     * @param mp matrixPosition
     * @return 检查点是否在矩阵内
     */
    public boolean check_point_exist_in_matrix(int[] pp, int[][] mp) {
        return false;
    }
}