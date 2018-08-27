package algorithms;

import java.util.ArrayList;
import java.util.List;

public class FindMedianSortedArrays {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<Integer>();
		int j=0,k=0;
		for (int i = 0; i < nums1.length+nums2.length; i++) {
			if(j==nums1.length && k<nums2.length) {
				list.add(nums2[k]);
				k++;
				continue;
			}
			if(k == nums2.length && j<nums1.length) {
				list.add(nums1[j]);
				j++;
				continue;
			}
			if(nums1[j]<nums2[k] && j < nums1.length) {
				list.add(nums1[j]);
				j++;
			}else if(nums1[j]>=nums2[k] && k < nums2.length) {
				list.add(nums2[k]);
				k++;
			}
			
		}
		int middle = list.size()/2;
		if(list.size()%2!=0) {
			return list.get(middle);
		} else {
			int s1 = list.get(middle);
			int s2 = list.get(middle -1);
			return (double)(s1+s2)/2.0;
		}
    }
	
	public static void main(String[] args) {
		FindMedianSortedArrays clazz = new FindMedianSortedArrays();
		int[] nums1 = {1, 3};
		int[] nums2 = {2, 4};
		System.out.println(clazz.findMedianSortedArrays(nums1, nums2));
	}
}
