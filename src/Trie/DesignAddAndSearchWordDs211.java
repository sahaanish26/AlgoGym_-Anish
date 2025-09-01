package Trie;

import java.util.HashMap;

public class DesignAddAndSearchWordDs211 {
    TrieNode root;

    public DesignAddAndSearchWordDs211() {
        root =  new TrieNode();
     //   cur=root;
    }
    
    public void insert(String word) {
       
        insertHelper(root,word,0);

       // System.out.println("TrieNode after insertion"+root);
               
        
                
            }
            
    private void insertHelper(TrieNode root, String word, int index) {

                // base Condition when we have reached after end of word mark endsHere as True
                if(index==word.length()){
                    root.endsHere = true;
                    return;
                }
                char c = word.charAt(index);

                
                if(!root.neighbour.containsKey(c)){
                    TrieNode newNode = new TrieNode();
                    root.neighbour.put(c, newNode);
                }

                insertHelper(root.neighbour.get(c),word,index+1);

      


                    }
        
            public boolean search(String word) {
        //if current node contains the first char of the word

       return searchHelper(root,word,0);


        
    }
    
    public boolean startsWith(String prefix) {

        return startsWithHelper(root,prefix,0);
    }

    public boolean searchHelper(TrieNode root,String word,int index) {
    
            // word has finished and end of word  found so true;
            if( index==word.length() && root.endsHere ){
                return true;
            }
            
             // word has finished but not end of word so false;
             if( index==word.length() ){
                return false;
            }
    
    
           char c = word.charAt(index);
           boolean result =false;
           if(c=='.'){
            // choose each of the possibility a-z and look for them
            for (char nchar = 'a'; nchar <= 'z'; nchar++){ 
             //  char nchar = 'a';
               if(root.neighbour.containsKey(nchar)){
               result = searchHelper( root.neighbour.get(nchar), word,index+1);
               if(result){
                return true;
               }
               }
            }

           }
           else if(root.neighbour.containsKey(c)){
          
            // recursive relation
             result = searchHelper( root.neighbour.get(c), word,index+1);
            

           }
           // if the current char in word and the node does not match result will go as false
           //which was the default value.

           return result;

            



        
        
    }


    public boolean startsWithHelper(TrieNode root,String prefix,int index) {
       // System.out.println("*startsWithHelper*"+index);
      //  System.out.println("*root*"+root);
        // index has finished and at the end of prefix  found so true;
        if( index==prefix.length() ){
            return true;
        }
        // we do not need to check end of word condition since we are checking here the prefix

         


       char c = prefix.charAt(index);
       boolean result =false;
       if(root.neighbour.containsKey(c)){
      
        // recursive relation
         result = startsWithHelper( root.neighbour.get(c), prefix,index+1);
        

       }
       // if the current char in word and the node does not match result will go as false
       //which was the default value.
      // System.out.println("*result*"+result);
       return result;

        



    
    
}
     

public static void main(String[] args){

    DesignAddAndSearchWordDs211 trie = new DesignAddAndSearchWordDs211();
trie.insert("bad");
trie.insert("dad");
trie.insert("mad");

System.out.println(trie.search("pad"));   // return False
System.out.println(trie.search("bad"));  // return True
System.out.println(trie.search(".ad")); // return True
System.out.println(trie.search("b.."));// return True
System.out.println(trie.search("..d"));    // return True
System.out.println(trie.search(".a."));    // return True
System.out.println(trie.search(".an"));    // return false

}


}

class TrieNode {
    
    HashMap<Character,TrieNode> neighbour;
    boolean endsHere;
    TrieNode() {
        neighbour = new HashMap<>();
        endsHere = false;

    }
    @Override
    public String toString() {
        return "TrieNode{" +
                "neighbour='" + neighbour + '\'' +
                ", endsHere=" + endsHere +
                '}';
    }
   
 }

