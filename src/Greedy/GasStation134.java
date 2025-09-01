package Greedy;

import java.util.Arrays;

public class GasStation134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totGas = 0;
        int totCost=0;

        for (int i=0;i<gas.length;i++){
            totGas=totGas+gas[i];

        }

        for (int j=0;j<cost.length;j++){
            totCost=totCost+cost[j];

        }
        if(totCost>totGas){
            return -1;
        }

      //  int start = 0;

        int[] netcost = new int[gas.length];

        for (int i=0;i<gas.length;i++){
            netcost[i]=gas[i]-cost[i];
        }
        System.out.println(Arrays.toString(netcost));

        for (int i=0;i<netcost.length;i++){
           if (netcost[i]>0){
            return i;
           }
        }
return -1;
        
    }

}
