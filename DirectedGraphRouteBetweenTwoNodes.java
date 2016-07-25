
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * given a directed graph, design an algorithm to find out whether there is a route 
 * between two nodes
 * 
 * breadth first search
 */

public class DirectedGraphRouteBetweenTwoNodes {
  
  static int Unvisited=0, Visiting=1, Visited=2;

  public static boolean search(ArrayList<Integer>[] adj, int start, int end){
    int[] state = new int[adj.length];
    LinkedList<Integer> q = new LinkedList<Integer>();

    state[start]= Visiting;
    q.add(start);
    int u;
    while(!q.isEmpty()){
      u=q.removeFirst();
      for(int i=0;i<adj[u].size();i++){
        int w=adj[u].get(i);
        if(state[w]==Unvisited){
          if(w==end){
            return true;
          }else{
            state[w]=Visiting;
            q.add(w);
          }
        }
      }
      state[u]= Visited;
    }
    return false;
  }
  
  public static void main(String[] args) throws Exception{
    ArrayList<Integer> adj[] = new ArrayList[8] ;
    for(int i=0;i<adj.length;i++){
      adj[i] = new ArrayList<Integer>();
    }
    adj[0].add(1);
    adj[1].add(2);
    adj[1].add(3);
    adj[3].add(4);
    adj[5].add(6);
    adj[5].add(7);
    System.out.println(search(adj,1,4));    //expecting true
    System.out.println(search(adj,0,4));    //expecting true
    System.out.println(search(adj,0,2));    //expecting true
    System.out.println(search(adj,5,6));    //expecting true
    System.out.println(search(adj,2,3));    //expecting false
    System.out.println(search(adj,2,6));    //expecting false
    System.out.println(search(adj,2,7));    //expecting false
    System.out.println(search(adj,6,7));    //expecting false
  }

}


