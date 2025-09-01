

package Tree;
public class SameTree100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        //base case 
        // if both are null then identical
        if(p==null && q==null){
            return true;
        }
         //if one of them  null then it is unequal
        if(p==null || q==null){
            return false;
        }
       

          //node value is equal
        // left tree is equal to right tree
         boolean valueCheck = false;
         if(p.val==q.val){
            valueCheck=true;
         }
        
    
         boolean  leftCheck =  isSameTree(p.left,q.left);
         boolean  rightCheck =  isSameTree(p.right,q.right);
         if(valueCheck && leftCheck && rightCheck ){
            return true;
         }

      return false;
        
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
