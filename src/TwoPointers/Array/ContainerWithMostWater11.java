package TwoPointers.Array;

public class ContainerWithMostWater11 {

    public int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;
        int left=0;
        int right = height.length-1;

        while (left<right){

     int minOfHeights =  Math.min(height[left],height[right]);

     int area = (right-left)*minOfHeights;

     if(area>maxArea){
        maxArea=area;
     }
     // now we have two possibility we can either go left +1 or right -1
    
     // MISTAKE PRONE AREA
     //REMEMBER: we will discard the shorter pointer. and keep the taller pointer.

     if(height[left]<height[right]){
        // discard left pointer and move towards right
        left=left+1;

     }
     else{
        // in case both are equal does not matter which direction we are going
        right=right-1;
     }





       


        }
        
    

    return maxArea;
}

}
