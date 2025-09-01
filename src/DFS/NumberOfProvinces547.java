package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberOfProvinces547 {

    public static  int findCircleNum(int[][] isConnected) {

        //this is a n*N matrix so size for both loop same
        Map<Integer,List<Integer>> graph = new HashMap<>();

        //visited set
        Set<Integer> visited = new HashSet<>();

        for (int i=0;i<isConnected.length;i++){
            List<Integer> nei = new ArrayList<>()  ;
            graph.put(i+1,nei);

            for (int j=0;j<isConnected.length;j++){
                if(i==j){
                    continue;
                }
                int[] eachRow = isConnected[i];
                List<Integer> neighbours = graph.getOrDefault(i+1,new ArrayList<>());
                if(eachRow[j]==1){
                    neighbours.add(j+1);
                    
                }
                graph.put(i+1,neighbours);



            }
        }
        
        System.out.println(graph);

//now the problem is about connected components.

int count =0;
//loop over each noode
for (int i=1;i<=isConnected.length;i++){

    if (visited.contains(i)){
        continue;
    }

    dfs(i,graph,visited);
        count++;
    
    
    }
    
    return count;
            
        }
    
     private static void dfs(int i,  Map<Integer,List<Integer>> graph, Set<Integer> visited) {

            visited.add(i);
            
            //find all n of i
            List<Integer> neighbour = graph.get(i);

            for (int k=0;k<neighbour.size();k++){

              int ne = neighbour.get(k);
              if(!visited.contains(ne)){
                dfs(ne,graph,visited);
              }

            }

           
        }


        public static void main(String[] args){

            int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};

           // int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};

           // int[][] isConnected = {{1}};


            System.out.println(findCircleNum(isConnected));

        }
}
