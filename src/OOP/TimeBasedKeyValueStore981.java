package OOP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore981 {

HashMap<String,List<Pair>> map ;

    public TimeBasedKeyValueStore981() {

        map = new HashMap<>();

        
    }
    
    public void set(String key, String value, int timestamp) {

        List<Pair> existingList = map.getOrDefault(key,new ArrayList<>());
        Pair p = new Pair(value, timestamp);
        existingList.add(p);
        map.put(key, existingList);

        System.out.println("map value after set"+map);



        
    }
    
    public String get(String key, int timestamp) {

        List<Pair> existingList = map.getOrDefault(key,new ArrayList<>());
        if(existingList.size()==0){
            return "";
        }


        // the existingList should be sorted as timestamp is always increasing
        //so we can do binary search and get the last one with criteria timestamp_prev <= timestamp
        // the last one approach should work since there are supposed to be no duplcate ts. otherwise we had split
        // to look for exact match and last value < target timestamp seperately

        int ans =-1;
        int r= existingList.size()-1;
        int l =0;
        while(l<=r){
          int mid = l + (r-l)/2;
          Pair pAtMid = existingList.get(mid);
          int tsAtMid = pAtMid.timeStamp;

          if(tsAtMid<=timestamp){
            ans =mid;

            //look further to rit to get more suitable value
            l =mid+1;


          }
          else{
            //move to the left 
            r =mid -1;
          }

        }


        if(ans>-1){
            System.out.println("match found in"+ans);

            return existingList.get(ans).val;
        }

        return "";
        
    }

}


class Pair{
    String val;
    int timeStamp;

    public Pair(String value, int timeStamp) {
        this.val=value;
        this.timeStamp=timeStamp;
        
    }

   

}