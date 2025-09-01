import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EmployeeImportance690 {

    public static void main(String[] args){


    }

     public static int getImportance(List<Employee> employees, int id) {

        //create a graph with adj list
        // and also keep the starting employee in queue
        Queue bfsQ = new LinkedList<>();
        HashSet<Integer> visited = new HashSet();
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Map<Integer,Employee> egraph = new HashMap<>();

        for (int i=0;i<employees.size();i++){
            Employee e = employees.get(i);
            if(e.id==id){
                bfsQ.add(e);
                visited.add(id);
            }
                 egraph.put(e.id,e);

        }

        System.out.println("graph"+graph);
        int importance =0;
        while(!bfsQ.isEmpty()){
        //doing level by level bfs
         int len = bfsQ.size();

         for(int i=0;i<len;i++){

       Employee e  = (Employee) bfsQ.poll();

       importance = importance + e.importance;

       List<Integer> subOrdinates= e.subordinates;

       for (int k=0;k<subOrdinates.size();k++){
        if(!visited.contains(subOrdinates.get(k))){
            bfsQ.add(egraph.get(subOrdinates.get(k)));
            visited.add(subOrdinates.get(k));
        }

       }



         }

            
        }
        

        return importance;
    }

    
}


class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
