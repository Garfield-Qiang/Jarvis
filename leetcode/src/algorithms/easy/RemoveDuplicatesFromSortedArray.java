package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有序数组，去除重复的数字
 * @author Jarvis
 *
 */
public class RemoveDuplicatesFromSortedArray {
	
    public int removeDuplicates(int[] nums) {
    	if(nums.length==0) {
    		return nums.length;
    	}
    	List<Integer> list = new ArrayList<>();
    	list.add(nums[0]);
    	int temp = nums[0];
    	for (int num : nums) {
			if(num != temp) {
				temp = num;
				list.add(temp);
			}
		}
    	for (int i=0;i<list.size();i++) {
			nums[i] = list.get(i);
		}
        return nums.length;
    }
    
    public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray clazz = new RemoveDuplicatesFromSortedArray();
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		clazz.removeDuplicates(nums);
	}
    
}
