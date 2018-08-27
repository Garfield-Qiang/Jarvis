package algorithms;

import java.util.LinkedList;


/**
 * 求出最大的无重复字符的子字符串
 * @author Jarvis
 *
 */
public class LengthOfLongestSubstring {

	/**
	 * 时间复杂度太高
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring1(String s) {
		int i = 0;
		if(s.length()<=1) {
			i = s.length();
			return i;
		}
        for(int k = 0;k<s.length();k++) {
        	char[] chars = s.substring(k, s.length()).toCharArray();
        	String temp = "";
        	for (int j = 0;j < chars.length;j++) {
            	if(-1==temp.indexOf(chars[j])) {
            		temp += chars[j];
            	} else {
            		i = i > temp.length() ? i : temp.length();
            		temp = ""+chars[j];
            	}
    		}
        	i = i > temp.length() ? i : temp.length();
        }
        return i;
    }
	
	public int lengthOfLongestSubstring2(String s) {
		int i = 0;
		String target = "",temp = "";
        for(int k = 0;k<s.length();k++) {
        	temp = s.charAt(k)+"";
        	if(!target.contains(temp)) {
        		target += temp;
        	} else {
        		int index = target.indexOf(temp);
        		target = target.substring(index+1, target.length())+temp;
        	}
        	i = i > target.length() ? i : target.length();
        }
        return i;
    }
	
	public int lengthOfLongestSubstring(String s) {
		int i = 0;
		LinkedList<String> list = new LinkedList<>();
        for(int k = 0;k<s.length();k++) {
        	String temp = s.charAt(k)+"";
        	if(!list.contains(temp)) {
        		list.push(temp);
        	} else {
        		while(list.contains(temp)) {
        			list.removeLast();
        		}
        		list.push(temp);
        	}
        	i = i > list.size() ? i : list.size();
        }
        return i;
    }
	
	public static void main(String[] args) {
		LengthOfLongestSubstring clazz = new LengthOfLongestSubstring();
		System.out.println(clazz.lengthOfLongestSubstring2("abc"));
	}
}
