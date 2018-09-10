package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

public class RemoveElement {
	
    public int removeElement(int[] nums, int val) {
    	if(nums.length==0) {
    		return nums.length;
    	}
    	List<Integer> list = new ArrayList<>();
    	for (int num : nums) {
			if(num != val) {
				list.add(num);
			}
		}
    	for (int i=0;i<list.size();i++) {
			nums[i] = list.get(i);
		}
        return list.size();
    }
    
    public static void main(String[] args) {
		RemoveElement clazz = new RemoveElement();
		int[] nums = {3,2,2,3};
		clazz.removeElement(nums, 3);
		for(int i = 0 ;i<nums.length;i++) {
			System.out.println(nums[i]);
		}
	}
    
}
