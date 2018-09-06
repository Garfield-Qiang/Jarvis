package algorithms.medium;

import java.util.regex.Pattern;

/**
 * 给定一个字符串 招数这个字符串里的最大数字
 * @author Jarvis
 *
 */
public class String2Integer {
	
	public int myAtoi(String str) {
		int result = 0;
		String[] array = str.split(" ");
		String temp = "";
		for (String string : array) {
			if(!string.equals("")) {
				temp = string;
				break;
			}
		}
		String regex = "[a-zA-Z]";
		Pattern pattern = Pattern.compile(regex);
		if(pattern.matcher(temp.charAt(0)+"").find()) {
			return result;
		}
		regex = "[0-9]";
		StringBuilder sb = new StringBuilder();
		sb.append(temp.charAt(0));
		for(int i=1;i<temp.length();i++) {
			if(pattern.matcher(temp.charAt(i)+"").find()) {
				sb.append(temp.charAt(i));
			} else {
				break;
			}
		}
		temp = sb.toString();
		if(temp.equals("+")||temp.equals("-")) {
			return result;
		}
		boolean flag =temp.contains("-");
		try {
			double d = Double.parseDouble(temp);
			result = (int) (d/1);
		} catch (Exception e) {
			if(flag) {
				return Integer.MIN_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String2Integer clazz = new String2Integer();
		System.out.println(clazz.myAtoi("words and 987"));
//		System.out.println(Integer.parseInt("+00012"));
	}
}
