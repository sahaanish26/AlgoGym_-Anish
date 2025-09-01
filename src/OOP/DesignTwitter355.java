package OOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter355 {
    HashMap<Integer, Set<Integer>> userGraph;

    HashMap<Integer, List<Integer>> userFeed;

   PriorityQueue<Integer> pq ;

// The tweet id will be always unique a
//higher the tweet id the more recent the tweet id is , so we can sort on the tweet id
// recent 10 tweet id is the highest most valued tweetids.
// as per test case 18 [[],[1,5],[1,3],[1]] , higher tweet id can come before lower so logic needs to be complex.
    public DesignTwitter355() {

        userGraph = new HashMap<>();
        userFeed = new HashMap<>();
       

      
        
    }
    
    public void postTweet(int userId, int tweetId) {
       
           // create user graph with empty list of people they follow
            Set<Integer> followers = userGraph.getOrDefault(userId, new HashSet<>());
            userGraph.put(userId, followers);

            List<Integer> feeds = userFeed.getOrDefault(userId, new ArrayList<>());
            feeds.add(tweetId);
            userFeed.put(userId, feeds);

            System.out.println(userFeed +"*"+userGraph);
        

        
    }
    
    public List<Integer> getNewsFeed(int userId) {

        System.out.println(userFeed +"start*getNewsFeed"+userGraph);

        // find all the followers of user id
        Set<Integer> allUsers = userGraph.get(userId);
        List<Integer> combinedList = new ArrayList<>();
        combinedList.add(userId);
        combinedList.addAll(allUsers);
        // to get the top 10 feedIds we create the min heap 
        pq = new PriorityQueue<>();

        for (int user : combinedList){
            List<Integer> feeds = userFeed.get(user);
            for(int feed:feeds){

                pq.add(feed);
                 
            while(pq.size()>10){
                pq.poll();

            }

            }
          
           


        }
List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());


        }
       
        System.out.println(userFeed +"getNewsFeed*end*"+userGraph);
        Collections.reverse(ans);
        System.out.println("ans"+ans);
return ans;
        
    }
    
    public void follow(int followerId, int followeeId) {
        System.out.println(userFeed +"before*follow*"+userGraph);

        List<Integer> followers = userGraph.getOrDefault(followerId, new ArrayList<>());
        followers.add(followeeId);
        userGraph.put(followerId, followers);

        System.out.println(userFeed +"*follow*"+userGraph);


        
    }
    
    public void unfollow(int followerId, int followeeId) {
        List<Integer> followers = userGraph.getOrDefault(followerId, new ArrayList<>());
        followers.remove(Integer.valueOf(followeeId));
        //followers.re(followeeId);
        userGraph.put(followerId, followers);

        
    }

    public static void main(String[] args){

        DesignTwitter355 twitter = new DesignTwitter355();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1); 
twitter.follow(1, 2);  
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).

twitter.getNewsFeed(1);
twitter.unfollow(1, 2);
twitter.getNewsFeed(1); 
    }

}
