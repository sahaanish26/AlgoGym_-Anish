package BFS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII210 {



    public static void main(String[] args){
        int[][] pre = {{1,0},{2,0},{3,1},{3,2}};
        findOrder(4,pre);
        
        
            }
        
            /**
             * @param numCourses
             * @param prerequisites
             * @return
             */
            public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,Integer> inDegreeMap = new HashMap();
        Queue zeroDegreeQueue = new LinkedList<>();

        Map<Integer,List<Integer>> graph = new HashMap();

        

        for (int i=0;i<prerequisites.length;i++){

            int[] preReq= prerequisites[i];
            inDegreeMap.put(preReq[0],inDegreeMap.getOrDefault(preReq[0],0)+1);
         //   graph.put(preReq[1],graph.getOrDefault(preReq[1],new ArrayList<Integer>()).add(preReq[0]));

            if(graph.containsKey(preReq[1])){
                List<Integer> n= graph.get(preReq[1]);
                n.add(preReq[0]);

            }else{
                List<Integer> n= new ArrayList<>();
                n.add(preReq[0]);
                graph.put(preReq[1],n);
            }


        }
        System.out.println("inDegreeMap"+inDegreeMap);

        for (int i=0;i<numCourses;i++){
            if(!inDegreeMap.containsKey(i)){
                inDegreeMap.put(i,0);
                zeroDegreeQueue.add(i);
            }

           
        }
        System.out.println("inDegreeMap"+inDegreeMap);
        System.out.println("zeroDegreeQueue"+zeroDegreeQueue);
        System.out.println("graph"+graph);

List<Integer> sortedList = new ArrayList();

while(!zeroDegreeQueue.isEmpty()){

    int sizeAteachlevel = zeroDegreeQueue.size();
    System.out.println("sizeAteachlevel"+sizeAteachlevel);
    for ( int i = 0;i<sizeAteachlevel;i++){
    
    int source = (int) zeroDegreeQueue.poll();

sortedList.add(source);
// get neighbours of source
List<Integer> neighBours = graph.getOrDefault(source, new ArrayList<>());

for (int nei :neighBours ){

    int inDegree = inDegreeMap.get(nei);
    if(inDegree-1 ==0){
       zeroDegreeQueue.add(nei);
    }
    inDegreeMap.put(nei,inDegree-1);
}
}



}

System.out.println("sortedLisr"+sortedList);
//there is a cycle
if(sortedList.size()!=numCourses){
return new int[0];
}

int[] resultArr = new int[sortedList.size()];
for(int i=0;i<sortedList.size();i++){
    resultArr[i] = sortedList.get(i);
}
return resultArr ;


        
    }
}
    

