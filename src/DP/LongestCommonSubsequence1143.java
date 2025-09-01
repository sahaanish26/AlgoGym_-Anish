package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence1143 {

    public static  int counter = 0;

   // https://web.stanford.edu/class/archive/cs/cs106b/cs106b.1242/exams/2-endquarter/sectionextra
    public static int longestCommonSubsequence1(String text1, String text2) {
        Map<String,Integer> cacheMap = new HashMap<>((text1.length()*text2.length()*4)/3 +1);
       
       // if(text1.length()<text2.length()){
         //   return longestCommonSubsequenceHelper2(text1,text2,cacheMap);
      //  }

     //   return longestCommonSubsequenceHelper2(text2,text1,cacheMap);


      return   longestCommonSubsequenceHelperWithIndex(text1,text2,cacheMap,0,0);
      

     //  return  longestCommonSubsequenceHelper1(text1,text2,cacheMap);
       
       
       
                   
               }
           
       
               public static int longestCommonSubsequenceHelper(String text1, String text2, Map<String,Integer> cacheMap ) {
                   
                String key1 = text1 + "+" + text2;
                //  String key2 = text2+"+"+ text1;
                  if (cacheMap.containsKey(key1)){
                    //  System.out.println("key1"+key1);
                      return cacheMap.get(key1);
                  }
               
                if(text1.length()==0 ||text2.length()==0 ){
                    cacheMap.put(key1, 0); 
               
                   return 0;
                }
              //  System.out.println("text1"+text1);
              //     System.out.println("text2"+text2);
                 
                  
       
                  // counter++;
                  // System.out.println("counter"+counter);
                  
               
               
                if(text1.charAt(0)==text2.charAt(0)){
               
                  int val =  1 + longestCommonSubsequenceHelper(text1.substring(1),text2.substring(1),cacheMap);
                  cacheMap.put(key1,val);
                 // cacheMap.put(key2,val);
                // return val;
       
                }
                else{
                   int length1 = longestCommonSubsequenceHelper(text1,text2.substring(1),cacheMap);
                   int length2 =  longestCommonSubsequenceHelper(text1.substring(1),text2,cacheMap);
                   int max = Math.max(length1,length2);
                   cacheMap.put(key1,max);
                 //  return max;
                  
                }
       
                return cacheMap.get(key1);
                 
       
                // return cacheMap.get(key1);
                 
                   //  System.out.println("key2"+key2);
                    // return cacheMap.get(key2);
                 
                       
                   }
              
               public static int longestCommonSubsequence(String s1, String s2) {
               int dp[][] = new int[s1.length()][s2.length()];
               for(int a[]:dp)Arrays.fill(a,-1);
               return lcslength(s1,s2,dp,0,0);
           }
           public static int lcslength(String s1,String s2,int dp[][],int i,int j){
              
               if(i==s1.length() || j == s2.length()){
                   return 0;
               }
               if(dp[i][j] != -1) return dp[i][j];
               
               if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = 1+ lcslength(s1,s2,dp,i+1,j+1);
               }else{
                   int a = lcslength(s1,s2,dp,i+1,j);
                   int b = lcslength(s1,s2,dp,i,j+1);
                   dp[i][j] = Math.max(a,b);
               }
               return dp[i][j];
           }
       
           public static int longestCommonSubsequenceHelper1(String text1, String text2,Map<String,Integer> cache) {
        String key = text1 + "#" + text2;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
        if (text1.charAt(text1.length() - 1) == text2.charAt(text2.length() - 1)) {
            int result = 1 + longestCommonSubsequenceHelper1(text1.substring(0, text1.length() - 1), text2.substring(0, text2.length() - 1),cache);
            cache.put(key, result);
            return result;
        } else {
            int result = Math.max(longestCommonSubsequenceHelper1(text1.substring(0, text1.length() - 1), text2,cache),
            longestCommonSubsequenceHelper1(text1, text2.substring(0, text2.length() - 1),cache));
            cache.put(key, result);
            return result;
        }
    }
            public static void main (String[] args){
    
            String text1="fcvafurqjylclorwfoladwfqzkbebslwnmpmlkbezkxoncvwhstwzwpqxqtyxozkpgtgtsjobujezgrkvevklmludgtyrmjaxyputqbyxqvupojutsjwlwluzsbmvyxifqtglwvcnkfsfglwjwrmtyxmdgjifyjwrsnenuvsdedsbqdovwzsdghclcdexmtsbexwrszihcpibwpidixmpmxshwzmjgtadmtkxqfkrsdqjcrmxkbkfoncrcvoxuvcdytajgfwrcxivixanuzerebuzklyhezevonqdsrkzetsrgfgxibqpmfuxcrinetyzkvudghgrytsvwzkjulmhanankxqfihenuhmfsfkfepibkjmzybmlkzozmluvybyzsleludsxkpinizoraxonmhwtkfkhudizepyzijafqlepcbihofepmjqtgrsxorunshgpazovuhktatmlcfklafivivefyfubunszyvarcrkpsnglkduzaxqrerkvcnmrurkhkpargvcxefovwtapedaluhclmzynebczodwropwdenqxmrutuhehadyfspcpuxyzodifqdqzgbwhodcjonypyjwbwxepcpujerkrelunstebopkncdazexsbezmhynizsvarafwfmnclerafejgnizcbsrcvcnwrolofyzulcxaxqjqzunedidulspslebifinqrchyvapkzmzwbwjgbyrqhqpolwjijmzyduzerqnadapudmrazmzadstozytonuzarizszubkzkhenaxivytmjqjgvgzwpgxefatetoncjgjsdilmvgtgpgbibexwnexstipkjylalqnupexytkradwxmlmhsnmzuxcdkfkxyfgrmfqtajatgjctenqhkvyrgvapctqtyrufcdobibizihuhsrsterozotytubefutaxcjarknynetipehoduxyjstufwvkvwvwnuletybmrczgtmxctuny";
            String text2="nohgdazargvalupetizezqpklktojqtqdivcpsfgjopaxwbkvujilqbclehulatshehmjqhyfkpcfwxovajkvankjkvevgdovazmbgtqfwvejczsnmbchkdibstklkxarwjqbqxwvixavkhylqvghqpifijohudenozotejoxavkfkzcdqnoxydynavwdylwhatslyrwlejwdwrmpevmtwpahatwlaxmjmdgrebmfyngdcbmbgjcvqpcbadujkxaxujudmbejcrevuvcdobolcbstifedcvmngnqhudixgzktcdqngxmruhcxqxypwhahobudelivgvynefkjqdyvalmvudcdivmhghqrelurodwdsvuzmjixgdexonwjczghalsjopixsrwjixuzmjgxydqnipelgrivkzkxgjchibgnqbknstspujwdydszohqjsfuzstyjgnwhsrebmlwzkzijgnmnczmrehspihspyfedabotwvwxwpspypctizyhcxypqzctwlspszonsrmnyvmhsvqtkbyhmhwjmvazaviruzqxmbczaxmtqjexmdudypovkjklynktahupanujylylgrajozobsbwpwtohkfsxeverqxylwdwtojoxydepybavwhgdehafurqtcxqhuhkdwxkdojipolctcvcrsvczcxedglgrejerqdgrsvsxgjodajatsnixutihwpivihadqdotsvyrkxehodybapwlsjexixgponcxifijchejoxgxebmbclczqvkfuzgxsbshqvgfcraxytaxeviryhexmvqjybizivyjanwxmpojgxgbyhcruvqpafwjslkbohqlknkdqjixsfsdurgbsvclmrcrcnulinqvcdqhcvwdaxgvafwravunurqvizqtozuxinytafopmhchmxsxgfanetmdcjalmrolejidylkjktunqhkxchyjmpkvsfgnybsjedmzkrkhwryzan";
    
           System.out.println(longestCommonSubsequence1(text1,text2)) ;


    }

    public static int longestCommonSubsequenceHelper2(String text1, String text2, Map<String, Integer> cacheMap) {
         
        if(text2.length()>text1.length()){

            return longestCommonSubsequenceHelper2(text2,text1,cacheMap);

        }
        if (text1.length() == 0 || text2.length() == 0) {
          //  cacheMap.put(key, 0); // Store 0 in cache for empty strings
            return 0;
        }
        StringBuilder sb = new StringBuilder(text1.length()+text2.length()+1).append(text1.length()).append("#").append(text2);
        String key = sb.toString();
       // String key = text1 + "#" + text2; // Use a unique key based on both strings
     

        if (cacheMap.containsKey(key)) {
            return cacheMap.get(key);
        }
    
        
    
        if (text1.charAt(0) == text2.charAt(0)) {
            int val = 1 + longestCommonSubsequenceHelper2(text1.substring(1), text2.substring(1), cacheMap);
            cacheMap.put(key, val);
            return val;
        } else {
            int length1 = longestCommonSubsequenceHelper2(text1, text2.substring(1), cacheMap);
            int length2 = longestCommonSubsequenceHelper2(text1.substring(1), text2, cacheMap);
            int maxLength = Math.max(length1, length2);
            cacheMap.put(key, maxLength);
            return maxLength; // Return the result
        }
    }

    //the text1end is always to end of it , text2Start is always to end of it
    public static int longestCommonSubsequenceHelperWithIndex(String text1, String text2, Map<String, Integer> cacheMap, int text1Start, int text2Start) {
         
       
       // if (text1.length() == 0 || text2.length() == 0) {
          //  cacheMap.put(key, 0); // Store 0 in cache for empty strings
       //     return 0;
       // }
       // if we have reached the end of either screen
        if (text1.length() == text1Start || text2.length() == text2Start) {
            //  cacheMap.put(key, 0); // Store 0 in cache for empty strings
              return 0;
          }
       // StringBuilder sb = new StringBuilder(text1.length()+text2.length()+1).append(text1.length()).append("#").append(text2);
      //  String key = sb.toString();
       //the text1end is always to end of it , text2Start is always to end of it
      String key=   String.valueOf(text1Start)+"#"+String.valueOf(text2Start);
       // String key = text1 + "#" + text2; // Use a unique key based on both strings
     

        if (cacheMap.containsKey(key)) {
            return cacheMap.get(key);
        }
    
        
    
        if (text1.charAt(0) == text2.charAt(0)) {
           // int val = 1 + longestCommonSubsequenceHelper2(text1.substring(1), text2.substring(1), cacheMap);
           // this is equivalent to passing the string after first char
            int val = 1 + longestCommonSubsequenceHelperWithIndex(text1, text2, cacheMap,text1Start+1,text2Start+1);
         
            cacheMap.put(key, val);
            return val;
        } else {
           // int length1 = longestCommonSubsequenceHelper2(text1, text2.substring(1), cacheMap);

            int length1 = longestCommonSubsequenceHelperWithIndex(text1, text2, cacheMap,text1Start,text2Start+1);

         //   int length2 = longestCommonSubsequenceHelper2(text1.substring(1), text2, cacheMap);

            int length2 = longestCommonSubsequenceHelperWithIndex(text1, text2, cacheMap,text1Start+1,text2Start);


            int maxLength = Math.max(length1, length2);
            cacheMap.put(key, maxLength);
            return maxLength; // Return the result
        }
    }

}
