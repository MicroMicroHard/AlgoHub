package DataStructure.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-8-2 04:43:06
 * @author-Email ljfirst@mail.ustc.edu.cn
 * @blogURL https://www.cnblogs.com/hapjin/p/4760934.html
 * @description 图的邻接表 顶点
 */

public class VertexNode {

    public int nodeValue;// 节点值
    public boolean visit;// 是否访问过
    public List<EdgeNode> edgeNodeList; // 对应的结束节点列表

    public VertexNode(int value) {
        nodeValue = value;
        edgeNodeList = new LinkedList<>();
    }
}
