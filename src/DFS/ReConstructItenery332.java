package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ReConstructItenery332 {


    public static List<String> findItinerary(List<List<String>> tickets) {

        List<List<String>> result = new ArrayList<>();
        List<String>  path = new ArrayList<>();
        HashMap<List<String>,Integer> ticketMap = new HashMap<>();
        List<String> dummyTicket = new ArrayList<>();

        dummyTicket.add("*");
        dummyTicket.add("JFK");
        tickets.add(dummyTicket);
        HashMap<String,PriorityQueue<String>> graph = new HashMap();

        for(List<String> eachTicket: tickets){
            // create ticketmap and adjancency list graph
            ticketMap.put(eachTicket ,ticketMap.getOrDefault(eachTicket, 0)+1);
            PriorityQueue pq = graph.getOrDefault(eachTicket.get(0),new PriorityQueue<>()) ;
            pq.add(eachTicket.get(1));
            graph.put(eachTicket.get(0), pq);


        }
        System.out.println(graph);
        System.out.println(ticketMap);
        path.add("*");
        findItineraryHelper("JFK",graph,ticketMap,path,result);
        System.out.println("ticketMap after"+ticketMap);
        System.out.println(result);

 path.remove(0);
 return path;


        

        
    }


    public static boolean findItineraryHelper( String start,HashMap<String,PriorityQueue<String>> graph,HashMap<List<String>,Integer> ticketMap,  List<String>  path, List<List<String>> result) {

        //all tickets are exhausted

        System.out.println("ticketMap findItineraryHelper"+ticketMap+"*"+start);
        System.out.println("path findItineraryHelper"+path);
    
        if(ticketMap.isEmpty()){
    result.add(new ArrayList<>(path));
    return true;
    }
    List<String> ticket = new ArrayList<>();
    String prev = path.get(path.size()-1);
    ticket.add(prev);
    ticket.add(start);
    System.out.println(ticket);

    // this is an invalid ticket since the this ticket has exhausted
    if(ticketMap.getOrDefault(ticket,0)==0){
        return false;
    }

    //choose this ticket
   
    path.add(start);
    ticketMap.put(ticket, ticketMap.getOrDefault(ticket,0)-1);
    if(ticketMap.get(ticket)<=0){
        System.out.println("ticketMap findItineraryHelper"+ticketMap+"*"+prev+"*"+start);
        ticketMap.remove(ticket);
    }

    //explore
    PriorityQueue<String> allNeighbours = graph.getOrDefault(start,new PriorityQueue<>());
    PriorityQueue<String> allNeighboursClone = new PriorityQueue<String>(allNeighbours);

    List<String> sortedN = new ArrayList<>();


    while(!allNeighboursClone.isEmpty()){
        sortedN.add(allNeighboursClone.poll());

    }
    if(sortedN.isEmpty() && ticketMap.isEmpty() ){
       // result.add(new ArrayList<>(path));

    return true;
    }

    for (String n:sortedN){

        boolean r = findItineraryHelper(n,graph,ticketMap,path,result);

        if(r){
            return true;
        }
    }

    //unchoose
    path.remove(path.size()-1);
   // path.remove(path.size()-1);
    ticketMap.put(ticket, ticketMap.getOrDefault(ticket,0)+1);


    


       
    return false;
    }


    public static void main(String[] args){
       
         List<List<String>> tickets = new ArrayList<>();
         tickets.add(Arrays.asList("JFK", "SFO"));
         tickets.add(Arrays.asList("JFK", "ATL"));
         tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));



          // Create a List of List of String to hold the tickets
       // List<List<String>> tickets = new ArrayList<>();

        // Add each ticket as a new inner list
       // tickets.add(Arrays.asList("MUC", "LHR"));
       // tickets.add(Arrays.asList("JFK", "MUC"));
       // tickets.add(Arrays.asList("SFO", "SJC"));
       // tickets.add(Arrays.asList("LHR", "SFO"));

        System.out.println("Tickets (List<List<String>>): " + tickets);

        List<String> res = findItinerary(tickets);

        System.out.println("res"+res);

    }
}
