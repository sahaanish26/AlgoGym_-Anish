package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphValidTree261 {

    public static boolean validTree(int n, int[][] edges) {
        // write your code here

        if (n==0) return true;
        // a tree for n nodes can have n-1 edges
        // this property also  makes sure that there 
        // is no cycle. the moment edge number becomes
        // equal to nuber of node then there is cycle.
        if (edges.length>=n){
            return false;
        }

        // create adj list with each node as key and empty arraylist
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i=0;i<n;i++){
            
            graph.put(i,new ArrayList<>());

        }


        // now loop over edges to populate proper neighbour List
        for (int[] edge : edges){

            int source = edge[0];
            int neighbour = edge[1];
            // a->b
            List<Integer> neighbours = graph.get(source);
            neighbours.add(neighbour);
            //b->a
            List<Integer> neighbours1 = graph.get(neighbour);
            neighbours1.add(source);

        }
        System.out.println("graph"+graph);

        // now do the dfs to see if they are connected
        Set<Integer> visited = new HashSet<>();
        int count =0;
        for (int m =0;m<n;m++){

            if(!visited.contains(m)){

               // do traversal
                dfs(m,graph,visited);
                count++;

            }

           
        }

        System.out.println("count"+count);
        System.out.println("visited"+visited);
   
        if(count>1){
        return false;
    }

    return true;
    
    }


    private static void dfs(int source , Map<Integer,List<Integer>> graph, Set<Integer> visited  ){

        visited.add(source);

        List<Integer> neighbours = graph.get(source);

        for (int neighbour:neighbours ){

            if(!visited.contains(neighbour)){
                dfs(neighbour,graph,visited);
            }

        }



    }

    public static void main (String[] args) {


       int n = 5;
     //  int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};

      int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};


       System.out.println(validTree(n,edges));

    }
}
