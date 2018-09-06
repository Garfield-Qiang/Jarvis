package algorithms;

import java.util.Stack;

/**
 * '(', ')', '{', '}', '[' and ']'，
 * 给定字符串，只包含上述元素，检验该字符串是否正常使用括号
 * @author Jarvis
 *
 */
public class ValidParentheses {
	
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
		if(src.equals("{")) {
			return dst.equals("}");
		}
		if(src.equals("[")) {
			return dst.equals("]");
		}
		return false;
	}
	
	private boolean isLeft(String c) {
		return c .equals("(")||c.equals("{")||c.equals("[");
	}
	
	
	public static void main(String[] args) {
		ValidParentheses clazz = new ValidParentheses();
		System.out.println(clazz.isValid("([)]"));
	}
}
