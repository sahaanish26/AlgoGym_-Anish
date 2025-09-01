package HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IntersectionofMultipleArrays2248 {


    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				map.put(nums[i][j], map.getOrDefault(nums[i][j],0)+1);
			}
		}
        for (Map.Entry<Integer, Integer> ans : map.entrySet()) {
			if (ans.getValue() == nums.length) {
				list.add(ans.getKey());
			}
		}
        	//	Collections.sort(list);
		return list;
        
    }


    public static void main(String[] args){

    }

}
