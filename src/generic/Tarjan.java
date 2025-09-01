package generic;

import java.util.*;

public class Tarjan {

    public static int nodeValue;

    public static void main(String[] args){

        int[][] arg = {{0,1,1,0},{0,1,1,0},{0,0,0,0}};

        countArticulationPoint(arg);

    }

    public static int  countArticulationPoint (int[][] args){

        Map<Node,Integer> nodeLevel = new HashMap<>();
        Map<Node,Integer> nodeLowLevel = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        int rightColLimit=args.length-1;
        int bottomRowLimit=args[0].length-1;

       
        for (int i=0 ; i<args.length;i++){

            for (int j=0;j<args[0].length;j++){

                int cellValue = args[i][j];

                if(cellValue==1){
                    Node startNode = new Node(i,j);
                    dfsTarjanHelper(startNode,null,nodeLevel,nodeLowLevel,visited,rightColLimit,bottomRowLimit,args,startNode);
                }

            }
        }
        return 0;

        
    }

    private static void dfsTarjanHelper(Node atNode, Node parent, Map<Node, Integer> nodeLevel, Map<Node, Integer> nodeLowLevel, Set<Node> visited, int rightColLimit, int bottomRowLimit,int[][]args,Node rootNode) {
        nodeLevel.put(atNode,nodeValue);
        nodeLowLevel.put(atNode, nodeValue);
        nodeValue++;
        visited.add(atNode);
       System.out.println("atNode"+atNode);
        List<Node> eligibleNeighbourNodes = new ArrayList<>();
        if(atNode.col>0 && args[atNode.row][atNode.col-1]==1 ){
            Node pLeftNode = new Node(atNode.row, atNode.col-1);
            eligibleNeighbourNodes.add(pLeftNode);
        }
        if(atNode.col<rightColLimit && args[atNode.row][atNode.col+1]==1){
            Node pRightNode = new Node(atNode.row, atNode.col+1);
            eligibleNeighbourNodes.add(pRightNode);
        }
        if(atNode.row>0 && args[atNode.row-1][atNode.col]==1){
            Node pUpperNode = new Node(atNode.row-1, atNode.col);
            eligibleNeighbourNodes.add(pUpperNode);
        }
        if(atNode.row<bottomRowLimit && args[atNode.row+1][atNode.col]==1){
            Node pLowerNode = new Node(atNode.row+1, atNode.col);
            eligibleNeighbourNodes.add(pLowerNode);
        }
        System.out.println("potential n"+eligibleNeighbourNodes);
        for(Node toNode :eligibleNeighbourNodes){
            if (parent!=null && toNode.equals(parent) ){
                System.out.println("tonode ia parent"+toNode);
                continue;
            }
            if(!visited.contains(toNode)){
                dfsTarjanHelper(toNode,atNode,nodeLevel,nodeLowLevel,visited,rightColLimit,bottomRowLimit,args,rootNode);
                int atNodeLowLevel = Math.min(nodeLowLevel.get(atNode),nodeLowLevel.get(toNode));
                nodeLowLevel.put(atNode,atNodeLowLevel);
                if(nodeLevel.get(atNode)<= nodeLowLevel.get(toNode)){
                    System.out.println("Potential Articulation Point found"+atNode+"+  "+toNode);
                }

            }
            else{
                int atNodeLowLevel = Math.min(nodeLevel.get(atNode),nodeLowLevel.get(toNode));
                nodeLowLevel.put(atNode,atNodeLowLevel);

                

            }

        }




        
    }
    
}

class Node {
    public int row;
    public int col;

    @Override
    public String toString() {
        return "Node [row=" + row + ", col=" + col + "]";
    }

    public Node (int row,int col){
        this.row = row;
        this.col =col;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + row;
        result = prime * result + col;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (row != other.row)
            return false;
        if (col != other.col)
            return false;
        return true;
    }

}
