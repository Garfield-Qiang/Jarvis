package algorithms;


/**
 * 判断一个数字是否是回文数字
 * @author Jarvis
 *
 */
public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
		String string = x+"";
		string.replace("+", "");
		
		return string.equals(getReverseString(string));
	}
	
	private String getReverseString(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = s.length()-1 ; i >= 0 ; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}
