package Demo.DFSBFS;


import java.util.LinkedList;

public class Graph {
    /**
     * 图的顶点
     */
    public static class Vertex{
        int data;
        Vertex(int data){
            this.data=data;
        }
    }
    /**
     * 图（邻接表表示）
     */
    public int size;
    public Vertex[] vertices;
    public LinkedList<Integer> adj[];

      Graph(int size){
          this.size=size;
          vertices=new Vertex[size];
          adj=new LinkedList[size];
          for (int i=0;i<size;i++){
              vertices[i]=new Vertex(i);
              adj[i] =new LinkedList();
          }
      }
}
