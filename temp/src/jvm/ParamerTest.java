package jvm;

public class ParamerTest {
	String str="abc";
	char[] chr=new char[]{'g','o','o','d'};
	
	public void test(String str,char[] chr){
		str="cde";
		chr[0]='f';
	}
	
	public static void main(String[] args){
		ParamerTest pt=new ParamerTest();
		pt.test(pt.str, pt.chr);
		
		System.out.println(pt.str);
		System.out.println(pt.chr);
	}
}
