package algorithms;

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return "";
		} 
		if(strs.length == 1) {
			return strs[0];
		} 
		
		return "";
    }
	
	
	
	public static void main(String[] args) {
		LongestCommonPrefix clazz = new LongestCommonPrefix();
		String[] strs = {"flower","flow","flight"};
		System.out.println(clazz.longestCommonPrefix(strs));
	}
	
}
