package text;

import java.text.Collator;

public class CollatorTest {
	
	
	public static void main(String[] args){
		Collator myCollator = Collator.getInstance();
		System.out.println(myCollator.compare("°¡", "²¦"));
	}
}
