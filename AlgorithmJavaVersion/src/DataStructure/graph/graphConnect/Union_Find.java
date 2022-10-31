package DataStructure.graph.graphConnect;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-12-18 21:16
 * @author—Email micromicrohard@outlook.com
 * @description Union-Find 并查集算法
 * @blogURL
 */

public interface Union_Find {

    //关联 x 和 y 为一个联通分量
    void union(int x, int y);

    //判断 p 和 q 是否连通
    boolean connected(int x, int y);

    //返回图中有多少个连通分量
    int count();

    //查找 x 的父节点
    int find(int x);
}
