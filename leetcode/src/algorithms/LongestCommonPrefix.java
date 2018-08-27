package algorithms;

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return "";
		} 
		if(strs.length == 1) {
			return strs[0];
		} 
		String prefix = getPrefix(strs[0], strs[1]);
		if(strs.length == 2) {
			return prefix;
		}
		
		for(int i = 2;i<strs.length;i++) {
			prefix = getPrefix(prefix, strs[i]);
			if(prefix == "") {
				return "";
			}
		}
		
		return prefix;
    }
	
	public String getPrefix(String s1,String s2) {
		StringBuilder sb = new StringBuilder();
		int length = s1.length()>s2.length() ? s2.length() : s1.length();
		for(int i = 0 ;i<length; i++) {
			if(s1.charAt(i) == s2.charAt(i)) {
				sb.append(s1.charAt(i));
			} else {
				break;
			}
		}
		return sb.toString();
	}
	
	
	
	public static void main(String[] args) {
		LongestCommonPrefix clazz = new LongestCommonPrefix();
		String[] strs = {"flower","flow","flight"};
		System.out.println(clazz.longestCommonPrefix(strs));
	}
	
}
