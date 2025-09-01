import java.util.*;

public class CoinChangeII518 {

public static int numOfCalls;
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

      int[] intChoiceArray = new int[]{ 411,412,413,414,415,416,417,418,419,420,421,422};
     int desiredSum =9864;

    // int[] intChoiceArray = new int[]{ 1,2,5,7,3};
   // int desiredSum =15;
    //fianlResult61,numOfCalls647
    //after caching fianlResult61 numOfCalls95



    // int[] intChoiceArray = new int[]{ 1,2,5,7,3};
   // int desiredSum =15;
   ////fianlResult4,numOfCalls26
    //after caching fianlResult4 numOfCalls8

   // int[] intChoiceArray = new int[]{ 10};
   //int desiredSum =10;

  // int[] intChoiceArray = new int[]{ 1,2,5};
 // int desiredSum =5;


 //int [] intChoiceArray= new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98,100,102,104,106,108,110,112,114,116,118,120,122,124,126,128,130,132,134,136,138,140,142,144,146,148,150,152,154,156,158,160,162,164,166,168,170,172,174,176,178,180,182,184,186,188,190,192,194,196,198,200,202,204,206,208,210,212,214,216,218,220,222,224,226,228,230,232,234,236,238,240,242,244,246,248,250,252,254,256,258,260,262,264,266,268,270,272,274,276,278,280,282,284,286,288,290,292,294,296,298,300,302,304,306,308,310,312,314,316,318,320,322,324,326,328,330,332,334,336,338,340,342,344,346,348,350,352,354,356,358,360,362,364,366,368,370,372,374,376,378,380,382,384,386,388,390,392,394,396,398,400,402,404,406,408,410,412,414,416,418,420,422,424,426,428,430,432,434,436,438,440,442,444,446,448,450,452,454,456,458,460,462,464,466,468,470,472,474,476,478,480,482,484,486,488,490,492,494,496,498,500,502,504,506,508,510,512,514,516,518,520,522,524,526,528,530,532,534,536,538,540,542,544,546,548,550,552,554,556,558,560,562,564,566,568,570,572,574,576,578,580,582,584,586,588,780,936,1170,1560,2340,4680};
 //int desiredSum =4681;



      int fianlResult = change(desiredSum,intChoiceArray);
      System.out.println("fianlResult"+ fianlResult );
      System.out.println("numOfCalls"+ numOfCalls );





  }


    public static  int change(int amount, int[] coins) {

        List<List<Integer>> resultSets = new ArrayList<>();
        List<Integer> chosen = new ArrayList<Integer>();
        List<Integer> choices = new ArrayList<Integer>();
        Map<List<List<Integer>>,Integer> cacheMap = new HashMap<>();

        int coinSize= coins.length;
        boolean allEven = true;


        for (int i : coins)
        {
            choices.add(i);
            if(i%2==0){

            }else{
                allEven=false;
            }
        }
        //if target sum is odd but the choices are all even then we can never make that target
        if (amount%2!=0 && allEven ){
            return 0;
        }
        System.out.println(allEven);
        Collections.sort(choices,Collections.reverseOrder());
       int result =  combinationSumHelper(choices,chosen,resultSets,amount,cacheMap,0);
       System.out.println(resultSets);
      return result;
      
  

        
    }


    private static int combinationSumHelper(List<Integer> choices, List<Integer> chosen, List<List<Integer>> resultSets, int target, Map<List<List<Integer>>,Integer> cacheMap, int chosenum) {

        numOfCalls++;

      // System.out.println("chosen"+chosen+"choices"+choices+"target"+target);

     //  System.out.println("chosenum"+chosenum+"choices"+choices+"target"+target);



       //create cacheMap entry
       List<List<Integer>> mapKey1 = new ArrayList<>();
       List<Integer> keyChoices1 = new ArrayList<>(choices);
       List<Integer>keyTarget1 = new ArrayList<>();
       keyTarget1.add(target);
     // Collections.sort(keyChoices1);
       mapKey1.add(keyChoices1);
       mapKey1.add(keyTarget1);
       if(cacheMap.containsKey(mapKey1)){
        System.out.println("Cache Hit for " +mapKey1 + "cache result"+cacheMap.get(mapKey1) );
        return cacheMap.get(mapKey1);
       }
       if(target<0){
       // resultSets.add(new ArrayList<>(chosen));
        return 0;
    }

    

    

        if(target==0){
            resultSets.add(new ArrayList<>(chosen));
            return 1;
        }
        else if (target>0 && !choices.isEmpty()){

            //choose
            ///do not choose the first choice
            /// remove the first one from choice
            int firstChoice= choices.get(0);
            choices.remove(0);
            //explore
           int ways1= combinationSumHelper(choices,chosen,resultSets,target,cacheMap,chosenum);
            //unchoose
            choices.add(0,firstChoice);

            //choose
            //choose the first choice
            chosen.add(firstChoice);
            // since choices are infinite , removing choices does not matter
            //choices.remove(firstChoice)
            int ways2 =0 ;
            if(target-firstChoice>=0){
                ways2  = combinationSumHelper(choices,chosen,resultSets,target-firstChoice,cacheMap,chosenum+firstChoice);
            }
            //unchoose
            chosen.remove(chosen.size()-1);

            //create cacheMap entry
            List<List<Integer>> mapKey = new ArrayList<>();
            List<Integer> keyChoices = new ArrayList<>(choices);
            List<Integer>keyTarget = new ArrayList<>();
            keyTarget.add(target);
           // Collections.sort(keyChoices);
            mapKey.add(keyChoices);
            mapKey.add(keyTarget);
            cacheMap.put(mapKey, ways1+ways2);
           // System.out.println("chosen "+chosen+" choices "+choices+" target "+target+" numberOfWays "+(ways1+ways2)+ "cahceMap"+cacheMap);

            return ways1+ways2;
            

        }

        return 0;
    }

    
}
