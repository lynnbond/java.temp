package number;

public class ConvertTest {
	public static void main(String[] args) {
		Integer i=0xFF;
		byte b=i.byteValue();
		System.out.println(b);
		
		byte b2=0x1F;
		short s2=0x1ff1;
		int i2=0xFFFFFFFF;
		
		b=-0x7f;
		System.out.println(b);
		System.out.println(i.bitCount(i));
		System.out.println("i2="+i2);
	}
}
