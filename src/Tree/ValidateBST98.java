package Tree;

public class ValidateBST98 {
     


    public boolean isValidBST(TreeNode root) {
        double  infininity =  Double.NEGATIVE_INFINITY;
        TreeNode ref = root;
        boolean  isLeft =  isValidBSTHelperLeft(ref.left,ref);
        boolean  isRight =  isValidBSTHelperRight(ref.right,root);

        System.out.println("lef"+isLeft);
        System.out.println("right"+isRight);

        if (   (root.left==null  || (root.left!=null && root.val>root.left.val))  && ( root.right==null || (root.right!=null && root.val<root.right.val))  && isLeft && isRight ){
            return true;
        }
       
       return false;
        
    }

    public boolean isValidBSTHelperLeft(TreeNode root,TreeNode prev ) {

        // base case
        if(root==null){
            return true;

        }

        if ( isValidBSTHelperLeft(root.left,root)  &&  root.val<prev.val &&  isValidBSTHelperLeft(root.right,root) ){
            return true;
        }

        return false;
        
    }
    

    public boolean isValidBSTHelperRight(TreeNode root,TreeNode prev ) {

        // base case
        if(root==null){
            return true;

        }

        if ( isValidBSTHelperLeft(root.left,root)  &&  root.val>prev.val &&  isValidBSTHelperLeft(root.right,root) ){
            return true;
        }

        return false;
        
    }

}
