package Tree;
public class subtreeofanothertree572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

      //base case 
        // if both are null then identical
        if(root==null && subRoot==null){
            return true;
        }
         //if one of them  null then it is unequal
        if(root==null || subRoot==null){
            return false;
        }
         //check if the root and subroot is eqaul 
         //Or  recursively if the left part of the tree is equal to given subRoot
         // Or recursively if the right part of the tree is equal to given subroot
        if ( isSameTree(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot) ){
            return true;
        }

        return  false;
        
        
    }

    
    //utilizes leetcode problem 100 which checks if two trees are identical
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
