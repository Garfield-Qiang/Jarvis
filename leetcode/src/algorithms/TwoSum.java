package algorithms;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
	
	 public int[] twoSum(int[] nums, int target) {
		 if(nums.length < 2) {
			 return null;
		 }
		 List<Integer> list = new ArrayList<>();
		 for (int i : nums) {
			 list.add(i);
		}
		 
		 int[] indices = null;
	        for(int i = 0;i < list.size();i++){
	            int tmp = target - list.get(i);
	            tmp = list.indexOf(tmp);
	            if (tmp != -1 && tmp != i) {
	            	indices = new int[2];
					indices[0] = i;
					indices[1] = tmp;
					break;
				}
	        }
	        return indices;
	    }
	 
	 public static void main(String[] args) {
		TwoSum clazz = new TwoSum();
		int[] nums = {3,2,4};
		int[] indices = clazz.twoSum(nums, 6);
		System.out.println(indices[0]+","+indices[1]);
	}
}
