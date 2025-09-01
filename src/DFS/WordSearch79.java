package DFS;
import java.util.*;
import java.util.List;
public class WordSearch79 {

    public static void main(String[] args){

        //char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = {{'a'},{'a'}};
       // char[][] board = {{'a','b'},{'c','d'}};



       // System.out.println(exist(board,"ABCCED"));
     //  System.out.println(exist(board,"aa"));
      //  System.out.println(exist(board,"SEE"));
     // System.out.println(exist(board,"ABCB"));
     // System.out.println(exist(board,"acdb"));
     char [][] board1 = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
     String[] words = {"oath","pea","eat","rain"};

     System.out.println(findWords(board1,words));

    }

    public static List<String> findWords(char[][] board, String[] words) {
       List<String> result = new ArrayList<>();
       for (String word:words){
        boolean resultFlag = exist(board,word);
        if(resultFlag){
            result.add(word);
        }

       }

        return result;
        
    }

    public static boolean exist(char[][] board, String word) {
        Set<Nodee> visited = new HashSet();
        boolean ans=false;

        for (int i=0;i<board.length;i++ ){
            for (int j=0;j<board[0].length;j++){
                Nodee startNode = new Nodee(i,j);
                List<Character> path = new ArrayList<>();
                List<List<Character>> allPaths = new ArrayList<>();
                if(board[i][j]== word.charAt(0) && !visited.contains(startNode)){

               ans = dfsHelper(visited,board,board.length-1,board[0].length-1,startNode,word,0,path,allPaths);
                System.out.println("allPaths"+allPaths);
                System.out.println("visited after one pass"+visited);
                   if(ans){
                    visited.clear();
                    System.out.println("visited after one pass before returning true"+visited);
                
                    return true;}


                }
            }
        }


        




        return ans;

        
        
    }


    private static boolean bfsHelper(Set<Nodee> visited, char[][] board, int i, int j, Nodee startNode, String word) {
     Queue<Nodee> queue = new LinkedList<>();
     queue.add(startNode);
     int level=0;
     boolean flag=false;
     int count=0;
     visited = new HashSet<>();

     while(!queue.isEmpty() && level<word.length()){
        //reset to false before each inner loop.
        flag=false;
        int queueSize= queue.size();
        System.out.println("queue"+queue);
        for (int m=0;m<queueSize;m++){
        Nodee currentNode = queue.poll();
        visited.add(currentNode);
        if(board[currentNode.row][currentNode.col]==word.charAt(level)){
            System.out.println("level"+level+"board node"+board[currentNode.row][currentNode.col]+"word char"+ word.charAt(level));
            //
            flag=true;
        }
        else{
            continue;
        }
        
        List<Nodee> potentialNeighbours = new ArrayList<>();
        //check for left node
        if(currentNode.col>0){
            Nodee leftNode = new Nodee(currentNode.row,currentNode.col-1);
            potentialNeighbours.add(leftNode);
        }
        // check for right node
        if(currentNode.col<board[0].length-1){
            Nodee rightNode = new Nodee(currentNode.row,currentNode.col+1);
            potentialNeighbours.add(rightNode);
        }

        // check for upper node
        if(currentNode.row>0){
            Nodee upperNode = new Nodee(currentNode.row-1,currentNode.col);
            potentialNeighbours.add(upperNode);
        }
         // check for lower node
         if(currentNode.row<board.length-1){
            Nodee lowerNode = new Nodee(currentNode.row+1,currentNode.col);
            potentialNeighbours.add(lowerNode);
        }

        for (Nodee neighbour:potentialNeighbours){
            if(!visited.contains(neighbour)){
                queue.add(neighbour);
            }
        }

        }
        //if flag is not reset to true after completing an inner loop then break the loop.
        if(!flag){
            break;
        }
        level++;
     }

     System.out.println("level"+level);
     if(level==word.length()&& flag){
        return true;
     }
     return false;
        }


        private static boolean dfsHelper(Set<Nodee> visited, char[][] board, int i, int j, Nodee startNode, String word,int level,List<Character> path,List<List<Character>> allPaths) {

            Character currentChar =board[startNode.row][startNode.col];
            path.add(currentChar);
            System.out.println("char from word  >> "+ word.charAt(level)+ "  at level>>"+level);
            System.out.println("char from grid >>  " +currentChar);
            System.out.println("path so far >>  " +path);
            System.out.println("word sustr so far >>  " +word.substring(0,level+1));
           
           visited.add(startNode);

            if (path.size()==word.length()){
                //checkifString is same as word
                if(currentChar==word.charAt(level)){
                allPaths.add(new ArrayList<>(path));
                return true;
                }

                //return true;
            }else if(level<word.length() && currentChar==word.charAt(level)  ){
                //find out the neigbours.

                List<Nodee> potentialNeighbours = new ArrayList<>();
                //check for left node
                if(startNode.col>0){
                    Nodee leftNode = new Nodee(startNode.row,startNode.col-1);
                    potentialNeighbours.add(leftNode);
                }
                // check for right node
                if(startNode.col<board[0].length-1){
                    Nodee rightNode = new Nodee(startNode.row,startNode.col+1);
                    potentialNeighbours.add(rightNode);
                }
        
                // check for upper node
                if(startNode.row>0){
                    Nodee upperNode = new Nodee(startNode.row-1,startNode.col);
                    potentialNeighbours.add(upperNode);
                }
                 // check for lower node
                 if(startNode.row<board.length-1){
                    Nodee lowerNode = new Nodee(startNode.row+1,startNode.col);
                    potentialNeighbours.add(lowerNode);
                }
        
                for (Nodee neighbour:potentialNeighbours){
                    if(!visited.contains(neighbour)){
                        if (dfsHelper(visited,board,i,j,neighbour,word,level+1,path,allPaths)){
                            return true;
                        };
                    }
                }
        


            }
            
            
       path.remove(path.size()-1);
       visited.remove(startNode);
          
            return false;
               }
           
    
        
}

 class Nodee {
    public int row;
    public int col;
    
    @Override
    public String toString() {
        return "Node [row=" + row + ", col=" + col + "]";
    }
    public Nodee(int row, int col) {
        this.row = row;
        this.col = col;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + row;
        result = prime * result + col;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Nodee other = (Nodee) obj;
        if (row != other.row)
            return false;
        if (col != other.col)
            return false;
        return true;
    }
    
}
