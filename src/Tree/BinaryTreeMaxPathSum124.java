package Tree;

public class BinaryTreeMaxPathSum124 {
    int maxG = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        if(root==null){
            return 0;
        }

        if(root.left==null && root.right==null){
            return root.val;
        }
          if(root.left==null && root.right!=null){
            return Math.max(Math.max(root.val,root.val+root.right.val),root.right.val);


          }

          if(root.left!=null && root.right==null){
            return Math.max(Math.max(root.val,root.val+root.left.val),root.left.val);


          }


        // the max path sum is the max of six combinations

        // MAX of ( 1. the node value itself ,
        // 2.the sum obtained from passing left node , 
        //3.the sum obtained from passing right node,
        // 4. the sum obtained from passing left node+node value ,
        //5. the sum obtained from passing right node+node value , 
        // 6. the sum obtained from passing left node + the sum obtained from passing right node + node value)

        // the sum obtained from passing left node + the sum obtained from passing right node is not an option since in a tree
        // path can not be from left to right [ it can happen in graph only]

        int option1 = root.val;
        
        int option2 = maxPathSum(root.left);
        int option3 = maxPathSum(root.right);
        int option4 = root.val + option2;
        int option5 = root.val + option3;
        int option6 = root.val+option2+option3;

        int result1 = Math.max(Math.max(option1,option2), Math.max(option3,option4));
        int result2 = Math.max(option6, option5);
        int finalResult = Math.max(result1, result2);

        return finalResult;


        
    }



}
