package algorithms;


/**
 * 给定一个字符串，和数字，根据数字，输出对应的拉链体字符
 * @author Jarvis
 *
 */
public class ZigZag {
	
	public String convert(String s, int numRows) {
		StringBuilder sb = new StringBuilder();
		if(s.length()<=numRows) {
			return s;
		}
		int num = numRows*2 -2;
		for(int i = num, j = 0 ; i>=0&&j<num ; i=i-2 , j++) {
			StringBuilder temp = new StringBuilder();
			int k = j;
			int odd = 1;
			while(k<s.length()) {
				temp.append(s.charAt(k));
				if(i==0 || i == num) {
					k += num;
				} else {
					if(numRows >=4) {
						if(odd %2 ==1) {
							k+=i;
						} else {
							k += num - i; 
						}
						odd++;
					} else {
						k+=i;
					}
				}
			}
			sb.append(temp);
		}
		return sb.toString();
    }
	
	public static void main(String[] args) {
		ZigZag clazz = new ZigZag();
		System.out.println(clazz.convert("PAYPALISHIRING", 4));
	}
}
