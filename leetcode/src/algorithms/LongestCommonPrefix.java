package algorithms;


/**
 * 给定一个字符串数组，求出这个数组里，最长的公共前缀
 * @author Jarvis
 *
 */
public class LongestCommonPrefix {
	
	/**
	 * 先提取出前两个的公共前缀，再拿去和后面的字符串依次提取，
	 * 如果公共前缀为空了，则停止比较，直接返回空
	 * @param strs
	 * @return
	 */
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
	
	/**
	 * 获取两个字符串的相同前缀
	 * @param s1
	 * @param s2
	 * @return
	 */
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
