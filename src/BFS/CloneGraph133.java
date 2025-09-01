package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class CloneGraph133 {

    public Node cloneGraph(Node node) {

        //the key to the solution is using a visited MAP instead of a set that we use in BFS
        if (node == null) {
            return null;
        }

        Queue<Node> orignalNodeQueue = new LinkedList<>();
        Map<Node,Node> visited = new HashMap<>();
        Node clonedSource =  new Node(node.val);
        // put original node in queue
        orignalNodeQueue.add(node);
        //mark the first one as visited.
        visited.put(node,clonedSource);
        int level = 0;

        // now start the BFS
        while(!orignalNodeQueue.isEmpty()){

            int sizeAteachlevel = orignalNodeQueue.size();

            for (int i=0; i<sizeAteachlevel;i++){
           Node currentOriginal =  orignalNodeQueue.poll();
           Node clonedCurrentFromOriginal = visited.get(currentOriginal);

           List<Node> originalNeighbours = currentOriginal.neighbors;

           for (Node originalNeighbour: originalNeighbours){
           // if it is not visited
            if(!visited.containsKey(originalNeighbour)){
                //add it in the q
                orignalNodeQueue.add(originalNeighbour);
                //add it in the visited map and also clone 
                visited.put(originalNeighbour, new Node(originalNeighbour.val));

            }
            ////this is a  key turning point  to the solution 
            // now add the neighbour to the clonedGraph.
            // this addition is outside is in visited since we are cloning. circular neighbours a-b.b-c need to be maintained
            // and also existing nodes which are already copied need to be maintained , we can not again create a copy.
            clonedCurrentFromOriginal.neighbors.add(visited.get(originalNeighbour));

           }



            }


         

        }

        return clonedSource;

    
        
        
        
    }
    

   
}



class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}