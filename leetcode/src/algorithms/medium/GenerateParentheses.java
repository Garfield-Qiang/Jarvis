package algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定 n对（），排列出合法的组合
 * @author Jarvis
 *
 */
public class GenerateParentheses {
	
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        while(n>0) {
        	n--;
        	temp = getStrings(temp, "()");
        }
        
        for (String string : temp) {
			if(isValid(string)) {
				result.add(string);
			}
		}
        return result;
    }
	
	private List<String> getStrings(List<String> list,String string) {
		List<String> temp = new ArrayList<>();
		if(list.size()==0) {
			for (int i = 0;i<string.length();i++) {
				temp.add(""+string.charAt(i));
			}
			return temp;
		}
		for (String string2 : list) {
			for (int i = 0;i<string.length();i++) {
				temp.add(string2+string.charAt(i));
			}
		}
		return temp;
	}
	
	public boolean isValid(String s) {
		Stack<String> stack = new Stack<>();
		int i = 0;
		while(i<s.length()) {
			String dst = s.charAt(i)+"";
			if(isLeft(dst)) {
				stack.push(dst);
				i++;
			} else {
				if(stack.isEmpty()) {
					return false;
				}
				String src = stack.pop()+"";
				if(match(src, dst)) {
					i++;
					continue;
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
    }
	
	private boolean match(String src,String dst) {
		if(src.equals("(")) {
			return dst.equals(")");
		}
		return false;
	}
	
	private boolean isLeft(String c) {
		return c .equals("(");
	}
	
	public static void main(String[] args) {
		GenerateParentheses clazz = new GenerateParentheses();
		System.out.println(clazz.generateParenthesis(6));
	}
}
