package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//need to validate after running in leetcode
public class AlienDictionary {


    public static String foreignDictionary(String[] words) {
            //NeighbourList graph
            Map<Character,List<Character>> graph = new HashMap<>();
            // Indegree Map. Character to indegree Count
            Map<Character,Integer> indegreeMap = new HashMap<>();
    
            //Initialize all possible nodes as 0 indegree
            //this is required since from dependency graph this
            //may not come out directly
            for(int i=1;i<words.length;i++){
    
                String s = words[i];
                for (int k=0;k<s.length();k++){
                 Character c = s.charAt(k);
                 //initially indegree 0 for all unique chars
                 indegreeMap.put(c,0);
                }
               
            }
    
    
          for(int i=1;i<words.length;i++){
            String a =words[i-1];
            String b = words[i];
            //iterate over the min of the lengths of the word
            int length = Math.min(a.length(), b.length());
    
            
            for (int k=0;k<length;k++){
                //get the first non matching chatacter in the words
                if(a.charAt(k)!=b.charAt(k)){
                    //populate dependency graph
                    List<Character> adjList = graph.getOrDefault(a.charAt(k), new ArrayList<>());
                    adjList.add(b.charAt(k));
                    graph.put(a.charAt(k), adjList);
                    //populate inDegree Graph
                    indegreeMap.put(b.charAt(k),indegreeMap.getOrDefault(b.charAt(k),0)+1);
                    break;
                }
                //To add edge case where return "" // need to understand this part.
                if (k == length - 1 && a.length() > b.length()) {
                    return "";
                }
            }
            
          }
          Queue<Character> zeroIndegreeQueue = new LinkedList<>();
          for (char c : indegreeMap.keySet()) {
            if (indegreeMap.get(c) == 0) {
                zeroIndegreeQueue.offer(c);
            }
          
        }
    
      StringBuilder s = new StringBuilder();
      while(!zeroIndegreeQueue.isEmpty()){
        int size = zeroIndegreeQueue.size();
    
        for (int i=0;i<size;i++){
    
           Character c = zeroIndegreeQueue.poll();
           s.append(c);
    
           List<Character> neighbour = graph.getOrDefault(c, new ArrayList<>());
    
           for(Character n:neighbour ){
            int Indegree= indegreeMap.get(n);
            if(Indegree-1==0){
                zeroIndegreeQueue.add(n);
            }
            indegreeMap.put(n,Indegree-1);
    
           }
    
        }
    
      }
      String res = s.toString();
      // this condition checks for a cycle
    if(indegreeMap.size()==s.length())
      return res ;

      return "";
    
    }

   
    
    public static void main(String[] args){
    
    
        String[] words = {"wrt","wrf","er","ett","rftt"};
    
        System.out.println(foreignDictionary(words));
}

}
