package algorithms.hard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionMatching {
	
	public boolean isMatch(String s, String p) {
		Pattern r = Pattern.compile(p);
		Matcher m = r.matcher(s);
        return m.matches();
    }
	
	public static void main(String[] args) {
		RegularExpressionMatching clazz = new RegularExpressionMatching();
		System.out.println(clazz.isMatch("mississi", "mis*is*i"));
	}
}
