package algorithms;

/**
 * 求一个数字的倒序数
 * @author Jarvis
 *
 */
public class ReverseInteger {
	
	public int reverse(int x) {
		int result = 0;
		String s = x>0 ? x+"":(0-x)+"";
		String temp = "";
		for(int i = s.length()-1;i>=0;i--) {
			temp+=s.charAt(i);
		}
		try {
			result = Integer.parseInt(temp);
			if(x<0) {
				result = 0-result;
			}
		} catch (Exception e) {
			return 0;
		}
		
		if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) {
			return 0;
		}
		return result;
	}
	
	public static void main(String[] args) {
		ReverseInteger clazz = new ReverseInteger();
		System.out.println(clazz.reverse(1234567899));
	}
}
