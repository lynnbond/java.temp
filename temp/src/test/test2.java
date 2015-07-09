package test;

public class test2 {
	public static void print(int val){
		val=++val;
		System.out.println("val="+val);
	}
	public static void print(String val){
		//val="bbbbb";
		val=val.concat("bbbbb");
		System.out.println("val="+val);
	}
	public static void print(StringBuffer val){
		//val="bbbbb";
		val.append("bbbb");
		System.out.println("val="+val);
	}
	public static void main (String[] args){
		int i=0;
		String str="aaaa";
		StringBuffer bf=new StringBuffer("aaaaa");
		test2.print(i);
		test2.print(str);
		test2.print(bf);
		System.out.println("i="+i);
		System.out.println("str="+str);
		System.out.println("bf="+bf);
	}
}
