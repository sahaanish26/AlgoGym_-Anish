package DFS;

import java.util.HashMap;
import java.util.Map;

public class cbtfromInPreOrder105 {
    // very good explanation
   // https://www.youtube.com/watch?v=PoBGyrIWisE
   // generic tree problem solver https://www.youtube.com/watch?v=s2Yyk3qdy3o

   public TreeNode buildTree(int[] preorder, int[] inorder) {

    Map<Integer,Integer> preOrderMap = new HashMap<>();
    Map<Integer,Integer> inOrderMap = new HashMap<>();

    for (int i=0;i<preorder.length;i++){
        preOrderMap.put(preorder[i],i);

    }

    for (int i=0;i<inorder.length;i++){
        inOrderMap.put(inorder[i],i);

    }
   
    
  TreeNode res =  buildTreeHelper(preOrderMap, inOrderMap,preorder, inorder,0,inorder.length-1);

 return  res;

}


public TreeNode buildTreeHelper( Map<Integer,Integer> preOrderMap,Map<Integer,Integer> inOrderMap, int[] preorder, int[] inorder, int inorderStart, int inorderEnd) {
    System.out.println("inorderStart"+inorderStart+"inorderEnd"+inorderEnd);

    //base case if inorderlist is exhausted
    if(inorderStart>inorderEnd){
        return null;
    }

    //psuedo code
   // identify the root node = out of all the numbers inorder , which number comes first in preorder
   int earliest= Integer.MAX_VALUE;
   for (int i=inorderStart;i<=inorderEnd;i++){
    earliest = Math.min(preOrderMap.get(inorder[i]), earliest);

   }

   //for post order only tweak is here
   
   // identify the root node = out of all the numbers inorder , which number comes last in postorder
   //int furthest= Integer.MIN_VALUE;
  // for (int i=inorderStart;i<=inorderEnd;i++){
  //  furthest = Math.max(postOrderMap.get(inorder[i]), furthest);

  // }
  // System.out.println("furthest"+furthest);

  // int rootValue = postorder[furthest];
  // System.out.println("earliest"+earliest);

   int rootValue = preorder[earliest];
  // System.out.println("rootValue"+rootValue);
   //create the root node
   TreeNode root = new TreeNode(rootValue);
    // find the index i in inorder  where root is present
  
   int index = inOrderMap.get(rootValue);
  // System.out.println("index"+index);
     //pass the left portion of inorder with root as center
    root.left = buildTreeHelper(preOrderMap,inOrderMap,preorder,inorder, inorderStart , index-1);

     //pass the right portion of inorder with root as center
    root.right = buildTreeHelper(preOrderMap,inOrderMap,preorder,inorder, index+1 , inorderEnd);

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
