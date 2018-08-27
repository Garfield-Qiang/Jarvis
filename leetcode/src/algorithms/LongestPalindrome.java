package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindrome {
	
	public String longestPalindrome(String s) {
		int length = s.length();
		if(length<=1) {
			return s;
		}
		String r = getReverseString(s);
		int[][] c = new int[length+1][length+1];
		Map<Integer, List<Integer>> map = new HashMap<>();
		int max = 0,index = 0;
		for (int i = 0; i <= length; i++) {
			for (int j = 0; j <= length; j++) {
				if( i == 0 || j == 0 ) {
					c[i][j] = 0;
				} else if(s.charAt(i-1) == r.charAt(j-1)) {
					c[i][j] = c[i-1][j-1] + 1;
						max = c[i][j];
						index = i;
						if(max>1&& i != length && j!= length&&s.charAt(i) != r.charAt(j)) {
							if(map.get(max)==null) {
								List<Integer> list = new ArrayList<>();
								list.add(index);
								map.put(max, list);
							} else {
								List<Integer> list = map.get(max);
								list.add(index);
								map.put(max, list);
							}
						}
						if(max>1&& (i == length || j== length)) {
							if(map.get(max)==null) {
								List<Integer> list = new ArrayList<>();
								list.add(index);
								map.put(max, list);
							} else {
								List<Integer> list = map.get(max);
								list.add(index);
								map.put(max, list);
							}
						}
				} else {
					c[i][j] = 0;
				}
			}
		}
		max = 0;
		StringBuilder sb = new StringBuilder();
		String result = "";
		for (Integer tempMax : map.keySet()) {
			for (Integer tempIndex : map.get(tempMax)) {
				for(int i = 0;i<tempMax;i++){
					sb.append(s.charAt(tempIndex-1));
					tempIndex--;
				}
				if(sb.toString().equals(getReverseString(sb.toString()))&&max<sb.length()) {
					max = sb.length();
					result = sb.toString();
				}
				sb = new StringBuilder();
			}
		}
		return result != "" ? result : s.charAt(0)+result;
	}
	
	private String getReverseString(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = s.length()-1 ; i >= 0 ; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		LongestPalindrome clazz = new LongestPalindrome();
		System.out.println(clazz.longestPalindrome("abcdbbfcba"));
	}
}
