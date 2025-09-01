package DP;

public class RegularExpressionMatching {
    public  static boolean isMatch(String s, String p) {

       return  isMatchHelper(s,p,0,0);
       
        
    }

    
  // the key to the solution is taking first or first two char of the matcher
    public static boolean isMatchHelper( String s, String p,int sl,int pl ){
       // System.out.println("sl"+sl+"pl"+pl);
        //s empty and p is empty then a match
        if(pl==p.length() && sl==s.length() ){
            return true;
        }
       
        //matcher p has finished but s is unfinished
        if(pl ==p.length() && sl<s.length()){

            return false;

        }

        // in leetcode did not give tle without cache
       
        
     //if s has finished but p has not then we have to take care of length of s in below sectio
           

        
      
      
       // char  charS= s.charAt(sl);
    
    
       // char charP = p.charAt(pl);


       boolean res1 = false;
       boolean res2 = false;
       boolean res3 = false;
       

       // If the next character in pattern p  is '*'
       if (pl + 1 < p.length() && p.charAt(pl + 1) == '*') {

        // result without taking the current char in consideration. i.e *=0 of preeding char
        //  notice it is pl+2 because we have to exclude the current char and *
        res1= isMatchHelper(s,p,sl,pl+2);

        // now we take 1 or more of * if the first char matches
        if(sl<s.length() && (s.charAt(sl)==p.charAt(pl)|| p.charAt(pl)=='.')){

            res2 = isMatchHelper(s,p,sl+1,pl);
        }

       }else{
        if(sl<s.length() && (s.charAt(sl)==p.charAt(pl)|| p.charAt(pl)=='.')){

            res3 = isMatchHelper(s,p,sl+1,pl+1);
        }


       }

       if(res1||res2||res3){
        return true;
       }
        

       return false;


    }

    public static void main(String[] args){

         // String s = "a";
      // String p= "a*a";

     //   String s = "aa";
    //   String p= "a";

      // String s = "aa";
      //  String p= "a*";

       //String s = "a";
      // String p= "a*";
      // String s = "ab";
       //String p= "a*b";
       // String s = "aa";
     // String p= "a*b";

        //String s = "ab";
      // String p= ".*";

      // String s = "aab";
       // String p= "c*a*b";
        // String s = "a";
       // String p= "ab*";

      String s ="bbbba";
       String p =".*a*a";

        System.out.println(isMatch(s,p));


        
    }
}
