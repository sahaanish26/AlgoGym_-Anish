package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {

        Map<TreeNode,List<TreeNode>> reverseGraph = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
       
        TreeNode maxLevelNode = root ;
        
        q.add(root);

        int level=0;
        while(!q.isEmpty()){
          
        int length = q.size();
        level++;
        maxLevelNode = q.peek();
        for (int i=0;i<length;i++){

            TreeNode node = q.poll();
            List<TreeNode> neighbour1=  reverseGraph.getOrDefault(node, new ArrayList<>());
         
          //  List<TreeNode> neighbours = new ArrayList<>() ;
            if(node.left!=null){
            q.add(node.left);
            List<TreeNode> neighbour = reverseGraph.getOrDefault(node.left,new ArrayList<>());
            neighbour.add(node);
            reverseGraph.put(node.left,neighbour);
            neighbour1.add(node.left);
            }
            if (node.right!=null){
             q.add(node.right);
             List<TreeNode> neighbour = reverseGraph.getOrDefault(node.right,new ArrayList<>());
            neighbour.add(node);
            reverseGraph.put(node.right,neighbour);
            neighbour1.add(node.right);
            }
            reverseGraph.put(node, neighbour1);
          
            
        }
       


        }
        System.out.println(maxLevelNode.val);
        System.out.println(reverseGraph);

        Queue<TreeNode> q2 = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<TreeNode>() ;
        TreeNode maxLevelzNode=null; 
        
       q2.add(maxLevelNode);
       visited.add(maxLevelNode);

        int levelz=0;
        while(!q2.isEmpty()){
          
            int length = q2.size();
            levelz++;
            maxLevelzNode=q2.peek();
            for (int i=0;i<length;i++){
    
                TreeNode node = q2.poll();
                List<TreeNode> neighbours = reverseGraph.getOrDefault(node,new ArrayList<>());

             if (neighbours.size()>0){
                for (TreeNode node1:neighbours){
                    if(!visited.contains(node1)){
                        q2.add(node1);
                        visited.add(node1);
                    }

                }
               
             }   
                  
            }
           
           // maxLevelNode= q.peek();
    
    
            }
            return levelz-1;
            

}

}
 class TreeNode {
      int val;
        TreeNode left;
        TreeNode right;
         TreeNode() {}
        TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
             this.left = left;
           this.right = right;
        }
 }