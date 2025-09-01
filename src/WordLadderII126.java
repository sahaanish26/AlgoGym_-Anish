import java.util.*;

public class WordLadderII126 {


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

      /*  int[] intArray1 = new int[]{ 1,2};
        int[] intArray2 = new int[]{ 3};
        int[] intArray3 = new int[]{ 3};
        int[] intArray4 = new int[]{ };
      //  int[] intArray5 = new int[]{ };
        int[][] graphArrays = { intArray1, intArray2, intArray3, intArray4 };
*/



        // subListHelper (choices,chosen,resultSets);
        // System.out.println(resultSets);
        String beginWord = "hit";
        String endWord = "cog";
       // List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println("Final result"+ findLadders(beginWord,endWord,wordList) );

    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //IF endWord not in wordList then return empty response
        Map<String,Set<String>> blockGraph = new HashMap<>();  
        List<List<String>> response= findLaddersBfsHelper(beginWord, endWord,wordList,blockGraph);
        System.out.println("blockGraph***"+blockGraph);
        int pathLength= response.get(0).size();
        System.out.println("pathLength***"+pathLength);
        List<List<String>> allPaths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Set<String> visistedDfs = new HashSet<>();
        dfsHelper(beginWord,endWord,blockGraph,path,allPaths,pathLength,visistedDfs);
        return allPaths;
    }

    private static void dfsHelper(String beginWord, String endWord, Map<String, Set<String>> blockGraph,
            List<String> path, List<List<String>> allPaths, int pathLength, Set<String> visistedDfs) {

                path.add(beginWord);
                visistedDfs.add(beginWord);
                if(path.size()==pathLength && beginWord.equals(endWord)){
                    allPaths.add(new ArrayList<>(path));
                }
                if (path.size()<pathLength){
                    Set<String> neighbours = blockGraph.get(beginWord);
                    for (String neighbour : neighbours) {
                        if(!visistedDfs.contains(neighbour)){
                        dfsHelper(neighbour,endWord,blockGraph,path,allPaths,pathLength,visistedDfs);
                    }}
                }
                path.remove(path.size()-1);
                visistedDfs.remove(beginWord);
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'dfsHelper'");
    }

    private static List<List<String>> findLaddersBfsHelper(String beginWord, String endWord, List<String> wordList, Map<String, Set<String>> blockGraph) {
        Queue<Block> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        List<String> listPathIncludingSelf = new ArrayList<>();
        listPathIncludingSelf.add(beginWord);
        Block startBlock = new Block(beginWord,0,listPathIncludingSelf);
        queue.add(startBlock);
        List<List<String>> result = new ArrayList<>();
        int minSoFar=Integer.MAX_VALUE;

        
        while(!queue.isEmpty()){
          //  System.out.println("queue"+queue);
            Block currentBlock = queue.poll();
            if(currentBlock.getOwnValue().equals(endWord)){
             
                //for (Map.Entry<String,Set<String>> entry : blockGraph.entrySet()) {
                 //   System.out.println("     block key  "+entry.getKey()+ " block value "+entry.getValue() + "   ");
               // }
               /* minSoFar= Math.min(currentBlock.getOwnLevel(),minSoFar);
                if(currentBlock.getOwnLevel()<=minSoFar){
                    result.add(new ArrayList<>(currentBlock.getPathIncludingSelf())) ;
                }else{
                    return result;
                }*/
                result.add(new ArrayList<>(currentBlock.getPathIncludingSelf())) ;
                return result;
            }
            visited.add(currentBlock.getOwnValue());
            int currentNodeLevel = currentBlock.getOwnLevel();
            List<String> PathIncludingSelfForCurrentNode = currentBlock.getPathIncludingSelf();
            List<String>  eligibleNeighbourBlocks  = getEligibileNeighbourBlocks(currentBlock,wordList,visited);

            for(int i = 0 ; i < eligibleNeighbourBlocks.size() ; i++){
                String neighbourString = eligibleNeighbourBlocks.get(i);
                List<String> newneighbourPathIncludingSelf = new ArrayList<>(PathIncludingSelfForCurrentNode);
                newneighbourPathIncludingSelf.add(neighbourString);
                Block neighbourBlock = new Block(neighbourString,currentNodeLevel+1,newneighbourPathIncludingSelf);
                queue.add(neighbourBlock);
                 if (blockGraph.containsKey(currentBlock.getOwnValue())){
                    blockGraph.get(currentBlock.getOwnValue()).add(neighbourBlock.getOwnValue());
                }
                else{
                    Set<String> adjacencyList = new HashSet<>();
                    adjacencyList.add(neighbourBlock.getOwnValue());
                    blockGraph.put(currentBlock.getOwnValue(),adjacencyList);
                }
            }
        }
     
        

        return result;

    }

    private static List<String> getEligibileNeighbourBlocks(Block currentBlock, List<String> wordList, HashSet<String> visited) {
        List<String> eligibleNeighbourStrings = new ArrayList<>();
    for (int i = 0; i < wordList.size(); i++) {

        if(!visited.contains(wordList.get(i))){
            String word = wordList.get(i);
            if(isOneDiffApart(currentBlock,word)){
                eligibleNeighbourStrings.add(word);
            };

        }
    }

    return  eligibleNeighbourStrings;
    }

    private static  boolean isOneDiffApart(Block currentBlock, String word) {
        String currentWord = currentBlock.getOwnValue();
        int count =0;
        char[] charA = word.toCharArray();
        for(int i=0;i<charA.length;i++){
            if(charA[i]!=currentWord.charAt(i)){
                count++;
            }
        }
        if(count==1){
           return true;
        }

        return false;
    }
}
class Block {

    public String ownValue;
    public int ownLevel;
    List<String>  pathIncludingSelf;

    public Block(String ownValue, int ownLevel, List<String> pathIncludingSelf) {
        this.ownValue = ownValue;
        this.ownLevel = ownLevel;
        this.pathIncludingSelf = pathIncludingSelf;
    }

    public String getOwnValue() {
        return ownValue;
    }

    public int getOwnLevel() {
        return ownLevel;
    }

    public List<String> getPathIncludingSelf() {
        return pathIncludingSelf;
    }

    public void setOwnValue(String ownValue) {
        this.ownValue = ownValue;
    }

    public void setOwnLevel(int ownLevel) {
        this.ownLevel = ownLevel;
    }

    public void setPathIncludingSelf(List<String> pathIncludingSelf) {
        this.pathIncludingSelf = pathIncludingSelf;
    }

    @Override
    public String toString() {
        return "Block{" +
                "ownValue='" + ownValue + '\'' +
                ", ownLevel=" + ownLevel +
                ", pathIncludingSelf=" + pathIncludingSelf +
                '}';
    }
}
