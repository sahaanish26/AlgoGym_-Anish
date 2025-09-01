import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ConnectingCitiesWithMinimumCost1135 {

public static void main (String[] args){

    int [][] connections =  {{1,2,5},{1,3,6},{2,3,1}};
    int numberOfnodes=3;

   // Map<Integer, Map<Integer, Integer>> adjacencyList = convertEdgeListToAdjacencyList(connections);

   Map<Integer,List<List<Integer>>> graph  = new HashMap<>();
   List<Integer> node1= new ArrayList<>();
   node1.add(2);
   node1.add(5);
   List<Integer> node2= new ArrayList<>();
   node2.add(3);
   node2.add(6);

  List< List<Integer>> adjList1 = new ArrayList<>();
  adjList1.add(node1);
  adjList1.add(node2);
  graph.put(1,adjList1);

  List<Integer> node3= new ArrayList<>();
  node3.add(3);
  node3.add(1);
  List<Integer> node4= new ArrayList<>();
  node4.add(1);
  node4.add(5);
   List< List<Integer>> adjList2 = new ArrayList<>();
   adjList2.add(node3);
   adjList2.add(node4);
 
   graph.put(2,adjList2);


   List<Integer> node5= new ArrayList<>();
   node5.add(1);
   node5.add(6);
  List<Integer> node6= new ArrayList<>();
  node6.add(2);
  node6.add(1);
  List< List<Integer>> adjList3 = new ArrayList<>();
  adjList3.add(node5);
  adjList3.add(node6);

  graph.put(3,adjList3);
 
   System.out.println(graph);


    System.out.println(minimumCost(numberOfnodes,graph,connections));

   

}



 public static int minimumCost(int n, Map<Integer,List<List<Integer>>>  graph,int[][] connections) {
    System.out.println(connections);

    


     // create adjacency list with nodes from edgeList
    for (int i=1;i<=n;i++){

        if(!graph.containsKey(i)){
            graph.put(i,new ArrayList<>());
        }
       
    }

    System.out.println(graph);

    //choose an arbitrary edge , for this case the first one
      int[] startingEdge = connections[0];
      HashSet<Integer> visited = new HashSet<>();
     List<Integer> starNode =  new ArrayList<>();
     starNode.add(startingEdge[0]);
      //self node is 0 edge distance
     starNode.add(0);

      
      PriorityQueue<List<Integer>> nodePriorityQueue = new PriorityQueue<>(new ListComparator());
      //put the  first edge in Pqueue
      nodePriorityQueue.add(starNode);
      // put the first node in visited flag
      visited.add(startingEdge[0]);
      int minSpan =0;

    while(!nodePriorityQueue.isEmpty()){
        
       System.out.println(nodePriorityQueue);
        // pop the edge with shortest weight
        List<Integer> edge = nodePriorityQueue.poll();
        if(!visited.contains(edge.get(0))){
            minSpan = minSpan+edge.get(1);
            visited.add(edge.get(0));
        }
         
        int startNode = edge.get(0);
        List<List<Integer>> nBors=  graph.get(startNode);
        System.out.println(nBors);
        for (int i=0;i<nBors.size();i++){
            if(!visited.contains(nBors.get(i).get(0))){
                nodePriorityQueue.add(nBors.get(i));
                
            }
        }
System.out.println(nodePriorityQueue);
      
        
     

    }
      
   return minSpan;
     
      
   // PriorityQueue q = new PriorityQueue<int[]>();

       
      //  return -1;
    }

    public static Map<Integer, Map<Integer, Integer>> convertEdgeListToAdjacencyList(int[][] edgeList) {
        Map<Integer, Map<Integer, Integer>> adjacencyList = new HashMap<>();

        for (int[] edge : edgeList) {
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];

            adjacencyList.computeIfAbsent(source, k -> new HashMap<>()).put(destination, weight);
        }

        return adjacencyList;
    }

    
}


class EdgeComparator implements Comparator<int[]>  {

    // Overriding compare()method of Comparator
    // for descending order of cgpa
    public int compare(int[] l1, int[] l2) {
        if (l1[1] > l2[1])
            return 1;
        else if (l1[1] < l2[1])
            return -1;
        return 0;
    }

   



}


class ListComparator implements Comparator<List<Integer>>  {

    // Overriding compare()method of Comparator
    // for descending order of cgpa
    public int compare(List<Integer> l1, List<Integer> l2) {
        if (l1.get(1) > l2.get(1))
            return 1;
        else if (l1.get(1) < l2.get(1))
            return -1;
        return 0;
    }



}
