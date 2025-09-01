package OOP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetectSquares2013 {


    // should not create key with array object

    HashMap<List<Integer>,Integer> pointMap ;
    List<int[]> pointList ;

    public DetectSquares2013() {
        pointMap = new HashMap<>();
        pointList = new ArrayList<>();


        
    }
    
    public void add(int[] point) {
        pointList.add(point);
        List<Integer> pointList = new ArrayList<>();
        pointList.add(point[0]);
        pointList.add(point[1]);

        pointMap.put(pointList,pointMap.getOrDefault(pointList,0)+1) ;

        
    }
    
    public int count(int[] point) {

            int xCurrent = point[0];
            int yCurrent = point[1];

            int finalCount=0;

        for(int[] otherPoint : pointList){

            int xOther = otherPoint[0];
            int yOther = otherPoint[1];
            // find the prospective diagonal corner
          if( Math.abs((double)xCurrent-xOther) == Math.abs((double)yCurrent-yOther) && xCurrent!=xOther && yCurrent!=yOther ){
           // int[] otherFirst = new int[2];
           //int[] otherSecond = new int[2];

            List<Integer> otherFirst =new ArrayList<>();
            List<Integer> otherSecond =new ArrayList<>();



           
           // otherFirst[0]=xCurrent;
            otherFirst.add(xCurrent);
           // otherFirst[1]=yOther;
            otherFirst.add(yOther);

           // otherSecond[0]=xOther;
            otherSecond.add(xOther);
           // otherSecond[1]=yCurrent;
            otherSecond.add(yCurrent);

            if( pointMap.containsKey(otherFirst) && pointMap.containsKey(otherSecond) ){

                int count1 = pointMap.get(otherFirst);
                int count2 = pointMap.get(otherSecond);
                int prod = count1*count2;
                finalCount = finalCount+prod;
                 
                //can not return from here since there can be multiple diagonal points
                // we have to calculate the entire for loop for all such occurences
                 // return prod;

            }


          }
            

        }

return finalCount;
        
    }

}
