package test;

public class Test3 {
	public static void main(String[] args){
		String a="网络分公司\\维护中心\\潘家园通信局";
		System.out.println(a.replaceAll("\\\\", "/"));
	}
}	
