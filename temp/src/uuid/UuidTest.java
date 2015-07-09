package uuid;

import java.util.UUID;

public class UuidTest {
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.fromString("1-1-1-1-1"));
		System.out.println(UUID.nameUUIDFromBytes(new byte[]{Byte.decode("0x1")}));
		
	}
}
