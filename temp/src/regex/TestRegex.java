package regex;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

	public static String getGroupValue(String regex, String source, int groupId) {
		String value = "";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(source);
		while (m.find()) {
			for (int i = 0; i <= m.groupCount(); i++) {
				if (i == groupId) {
					value = m.group(i);
				}
			}
		}
		return value;
	}
	
	public static List<String> getMatchList(String regex, String source){
		String value = "";
		Pattern p = Pattern.compile(regex,Pattern.MULTILINE);
		Matcher m = p.matcher(source);
		while (m.find()) {
			
			System.out.println(m.group(0));

		}
		return null;
	}
	public static void main(String[] args){
		//Pattern p = Pattern.compile("^[0-9]+$");	
		//Matcher m = p.matcher("111");
		
		//System.out.println(m.matches());
		//System.out.println(TestRegex.getGroupValue("^(\\w+?)([0-9]+)", "11sss111dddd", 0));

		
		//System.out.println("F=0".matches("F=[1,0]"));
		
		//String s = "select * FROM dd";  
		//System.out.println(Pattern.matches("\\s{0,}select\b",s)); 
		
/*		Pattern p = Pattern.compile("^(.+?)=(.+?)\\?([01])$");
		Matcher m = p.matcher("ͬ��sdfasdddasdf=Casdfasdfsdf?1");
		m.find();
		System.out.println(m.group(1));
*/

		getMatchList("@[A-Za-z0-9]+","@liy34an@wangqidfasdfan哈sd卡分解法@卡大富科技@jklasdjfklj@1@jklsdf");
	}
}
