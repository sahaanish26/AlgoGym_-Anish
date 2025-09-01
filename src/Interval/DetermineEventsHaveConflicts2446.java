package Interval;

public class DetermineEventsHaveConflicts2446 {


    public boolean haveConflict(String[] event1, String[] event2) {

        //since there are only two events , hence not sorting by collections.sort or PQ
        //Find the ist interval

        String start1 = event1[0];
        String end1=event1[1];
        String start2 =event2[0];
        String end2 =event2[1];

        //if start of interval at the same time, there is a intersection.
        if(start1.compareTo(start2)==0){
            return true;
        }

        //if start1 <start2
        //then check if  end1>=start2 return true;
        //else return false

        if(start1.compareTo(start2)<0){
            if(end1.compareTo(start2)>=0){
                return true;
            }
            return false;
        }

        //if start1 >start2
        //then check if  end2>=start1 return true;
        //else return false

        if(start1.compareTo(start2)>0){
            if(end2.compareTo(start1)>=0){
                return true;
            }
            
            return false;
        }
        return false;
       
    }
   

}
