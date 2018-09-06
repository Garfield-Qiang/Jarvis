package algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一串数字，打印出，九宫格按键，可能出现的字母的排列
 * @author Jarvis
 *
 */
public class LetterCombinationsofaPhoneNumber {
	
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		Map<String, String> map = getStringMap();
		char[] chars = new char[digits.length()];
		for(int i = 0;i<digits.length();i++) {
			chars[i] = digits.charAt(i);
		}
		for (char c : chars) {
			String string = map.get(c+"");
			result = getStrings(result, string);
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
	
	private Map<String, String> getStringMap(){
		Map<String,String> map = new HashMap<>();
		map.put("1", "*");
		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");
		return map;
	}
	
	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber clazz = new LetterCombinationsofaPhoneNumber();
		System.out.println(clazz.letterCombinations("123"));
	}
}
