package Tree;
public class InvertBinaryTree226 {


    public TreeNode invertTree(TreeNode root) {



        if (root==null){
            return null;
         }
    
            // 
    
          // this will not work
        //  root.left = invertTree(root.right);
         // root.right = invertTree(root.left);
 
         // instead need to get the inverted tree and then swap pointers
 
         TreeNode leftInverted=   invertTree(root.left);
         TreeNode rightInverted=  invertTree(root.right);
 
         root.left=rightInverted;
         root.right=leftInverted;
 
 
          
    
          return root;


        
    }
    public void invertTreeHelper(TreeNode left,TreeNode right) {

     if (left==null || right==null){
        return;
     }

        // 

      int oldLeftVal = left.val;
      int oldRightVal = right.val;
      left.val = oldRightVal;
      right.val = oldLeftVal;
      invertTreeHelper(left.left,right.right);
      invertTreeHelper(left.right,right.left);

      



        
    }

    public TreeNode invertTreeHelper1(TreeNode root) {

        if (root==null){
           return null;
        }
   
           // 
   
         // this will not work
       //  root.left = invertTreeHelper1(root.right);
        // root.right = invertTreeHelper1(root.left);

        // instead need to get the inverted tree and then swap pointers

        TreeNode leftInverted=   invertTreeHelper1(root.left);
        TreeNode rightInverted=  invertTreeHelper1(root.right);

        root.left=rightInverted;
        root.right=leftInverted;


         
   
         return root;
   
   
   
           
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
