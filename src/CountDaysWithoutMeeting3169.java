import java.util.*;
class CountDaysWithoutMeeting3169 {

    public static int countDays(int days, int[][] meetings) {

        int firstPointer=0;
        int secondPointer=1;
        List<int[]> mergedIntervals = new ArrayList();
        Arrays.sort(meetings, (arr1,arr2) -> Integer.compare(arr1[0],arr2[0]));
        int[] firstInterval = new int[2];
        int[] secondInterval = new int[2];
        while(secondPointer<meetings.length) {
            for (int[] interval:mergedIntervals){
                System.out.println("***"+Arrays.toString(interval));
            }
            System.out.println("*first"+Arrays.toString(firstInterval));
            System.out.println("*second"+Arrays.toString(secondInterval));


            if(mergedIntervals.size()==0){
            firstInterval[0] = meetings[firstPointer][0];
            firstInterval[1] = meetings[firstPointer][1];
            }
            secondInterval[0] = meetings[secondPointer][0];
            secondInterval[1] = meetings[secondPointer][1];

            System.out.println("**first"+Arrays.toString(firstInterval));
            System.out.println("**second"+Arrays.toString(secondInterval));

            if (firstInterval[1]>=secondInterval[0]){
                //create a merge interval
                int[]  mergeediInterval = new int[2];
                mergeediInterval[0] =firstInterval[0];
                mergeediInterval[1]= Math.max(firstInterval[1],secondInterval[1]);
                mergedIntervals.add(mergeediInterval);
                firstInterval[0]=mergeediInterval[0];
                firstInterval[1]=mergeediInterval[1];

            }else{
                //no merge interval
                int[] newFirstInterval = new int[2];
                int[] newSecondInterval = new int[2];
                newFirstInterval[0]=firstInterval[0];
                newFirstInterval[1]=firstInterval[1];
                newSecondInterval[0]=secondInterval[0];
                newSecondInterval[1]=secondInterval[1];
                mergedIntervals.add(newFirstInterval);
                mergedIntervals.add(newSecondInterval);
                firstInterval[0]=secondInterval[0];
                firstInterval[1]=secondInterval[1];
               // firstPointer++;

            }
            secondPointer++;
            System.out.println("***first"+Arrays.toString(firstInterval));
            System.out.println("***second"+Arrays.toString(secondInterval));

        }

        System.out.println(mergedIntervals);
        for (int[] interval:mergedIntervals){
            System.out.println(Arrays.toString(interval));
        }

        return 0;
        
    }

    public static int countDays1(int days, int[][] meetings) {

        //Algorithmic Steps
//Sort the intervals by their start time.
//Take the first interval from the sorted list and add it to the merged intervals list.
//For each subsequent interval, compare its start time with the end time of the last interval in the merged list.
//If it overlaps (i.e., its start time is less than or equal to the end time of the last interval in the merged list), merge it by updating the end time of the last interval in the merged list.
//If it doesn’t overlap, simply add it to the merged list as a new interval. and the diff -1 is the free day for employee
// also finally after merging check for thee first interval and last interval for free days.

         List<int[]> mergedList = new ArrayList();
         Arrays.sort(meetings, (arr1,arr2) -> Integer.compare(arr1[0],arr2[0]));
         mergedList.add(meetings[0]);
         int originalListPointer = 1;
         int freedays=0;
         while(originalListPointer<meetings.length){
          int [] firstInterval = mergedList.get(mergedList.size()-1);
          int [] secondInterval = Arrays.copyOf(meetings[originalListPointer],2);

          if(firstInterval[1]>=secondInterval[0]){
            // merge case
            firstInterval[1]=Math.max(firstInterval[1],secondInterval[1]);

          }
          else{
            mergedList.add(secondInterval);
            freedays = secondInterval[0]- firstInterval[1]-1 +freedays ;

          }
          originalListPointer++;
          

         }
         for (int[] interval:mergedList){
            System.out.println("***"+Arrays.toString(interval));
        }
        
         int[] firstmergedList = mergedList.get(0);
         int [] lastmergedList = mergedList.get(mergedList.size()-1);
         if(firstmergedList[0]>1){
            freedays= freedays+ firstmergedList[0] - 1 -1;
         }
         if(lastmergedList[1]<days){
            freedays= freedays+ days - lastmergedList[1] ;
         }
        return freedays;
        
    }


    public static void main (String[] args){

        int[][] maeetings = { {1, 3}, {5, 7} ,{6,9} };

       int result = countDays1(10,maeetings);
       System.out.println(result);

    }

    
}