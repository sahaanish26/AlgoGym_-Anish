package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree637 {


    public List<Double> averageOfLevels(TreeNode root) {

     Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        //initialize level value;
        int level =0;
        List<Double> averageAtEachLevel = new ArrayList<>();

        while(!queue.isEmpty()){

          double sumAtEachLevel = 0;  
         int sizeAteachlevel = queue.size();
         //processing at each level
         for (int i=0;i<sizeAteachlevel;i++){

        TreeNode current = queue.poll();
        sumAtEachLevel = sumAtEachLevel + (double) current.val;

        if (current.left!=null){
            queue.add(current.left);
           
        }
        if (current.right!=null){
            queue.add(current.right);
           
        }

         }
         // find out average of sumateachlevel
         double average = sumAtEachLevel/(double)sizeAteachlevel;
         averageAtEachLevel.add(average);
         //increase the level here and before that do any postlevel processing
      
         level++;

        }
        return averageAtEachLevel;
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
