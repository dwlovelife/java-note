package datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 图
 */
public class Graph {

    private ArrayList<String> vertexList;//存储顶点的集合
    private int[][] edges; //存储图对应的领结矩阵
    private int numOfEdges;
    private boolean[] isVisited = new boolean[5];

    public static void main(String[] args) {
        //测试一把图是否OK
        int n = 5; //结点的个数
        String[] vertexs = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加结点
        for(String vertex: vertexs){
            graph.insertVertex(vertex);
        }
        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        //显示一把临街矩阵
        graph.showGraph();

    }

    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }

    /**
     * 得到第一个邻结点的下标
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index){
        for(int j = 0; j < vertexList.size(); j++){
            if(edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //根据前一个临结点的下标来获取下一个临结点
    public int getNextNeighbor(int v1,int v2){
        for(int j = v2 + 1; j < vertexList.size(); j++){
            if(edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    public void dfs(boolean[] isVisited, int i) {
        System.out.println(getValueByIndex(i) + "->");
        //将结点设置为已访问
    }


    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 显示图对应的矩阵
     */
    public void showGraph(){
        for(int[] link: edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }


    /**
     * @param v1     “A” - "B"  "A" -> 0 "B" -> 1
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }


}
