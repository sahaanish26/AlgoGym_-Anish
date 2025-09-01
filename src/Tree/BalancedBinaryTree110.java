package Tree;

import java.util.HashMap;

public class BalancedBinaryTree110 {
    static HashMap<TreeNode,Integer> heightCahce = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

       int  leftH = height(root.left,heightCahce);
       
              int  rightH = height(root.right,heightCahce);
       
              if (Math.abs( (double) (rightH-leftH))<=1 && isBalanced(root.left) && isBalanced(root.right) ){
               return true;
              }
       
           return false;
               
           }

          

       
           // we can cache the height calculation , since it is getting multiple times from top node , so the bottom nodes will be 
           //calculated and can be cached.
           private int height(TreeNode root,HashMap<TreeNode,Integer> cache) {



            if (root==null){
                return 0;
            }
            if(cache.containsKey(root)){
                return cache.get(root) ;
            }

            // height of a tree = node(1) + Math.max(Hleft,hRight);
            int res = 1 + Math.max(height(root.left,cache),height(root.right,cache));
            cache.put(root, res) ;

            return res;
              
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
