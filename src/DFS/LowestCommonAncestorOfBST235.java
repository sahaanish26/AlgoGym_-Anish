package DFS;

import java.util.ArrayList;
import java.util.List;



public class LowestCommonAncestorOfBST235 {

     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        List<TreeNode> pathTop = new ArrayList<>();
        List<TreeNode> pathToq = new ArrayList<>();

        List<List<TreeNode>> resultPathTop = new ArrayList<>();
        List<List<TreeNode>> resultPathToq = new ArrayList<>();


        dfs(root,p,pathTop,resultPathTop);
        dfs(root,q,pathToq,resultPathToq);
        //if path not found. i.e if one of them is not found
        if(resultPathTop.isEmpty()||resultPathToq.isEmpty() ){
            return null;
        }

        List<TreeNode> finalPathTop = resultPathTop.get(0);
        List<TreeNode> finalPathToq = resultPathToq.get(0);
        
        int i = 0;
        int j=  0;
        System.out.println(finalPathTop);
        System.out.println(finalPathToq);

        for (int k=0;k<finalPathTop.size();k++){
            System.out.println(finalPathTop.get(k).val+"-");
        }
        for (int m=0;m<finalPathToq.size();m++){
            System.out.println(finalPathToq.get(m).val+"-");
        }


        // find the last common element/node  from both the Lists as we traverse through the list
        TreeNode temp = null;
        while(i<finalPathTop.size()&& j<finalPathToq.size()){
            System.out.println(finalPathTop.get(i).val+"-"+finalPathToq.get(j).val);
            if(finalPathTop.get(i).val==finalPathToq.get(j).val){
                temp = finalPathTop.get(i);
            }


            if(finalPathTop.get(i).val!=finalPathToq.get(j).val){
                break;
            }
            i++;
            j++;
        }
        
        
        return temp;
                
            }
        
             private void dfs(TreeNode source, TreeNode target, List<TreeNode> path, List<List<TreeNode>> resultPath) {
                path.add(source);
                //since it is a tree no visited logic is required
                if(source.val==target.val){
                    resultPath.add(new ArrayList<>(path));
                }
                //find out eligible neighbours
                List<TreeNode> neighbours = new ArrayList<>();
                //since we know it is  bst , so on left side the values are always less than current
                 //so we can optimize with second && condition. this will not work in simple tree
                if(source.left!=null && target.val<source.val){

                    neighbours.add(source.left);
                }
                //since we know it is  bst , so on right side the values are always more than current
                //so we can optimize with second && condition. this will not work in simple tree
              
                if(source.right!=null && target.val>source.val){
                    neighbours.add(source.right);
                }

                for (TreeNode node : neighbours){
                     //since it is a tree no visited logic is required
                    dfs(node,target,path,resultPath);
                }
                //unchoose
                path.remove(path.size()-1);

                          }

    

}

 class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode(int x) { val = x; }
    }
