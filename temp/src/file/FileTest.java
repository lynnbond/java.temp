package file;

import java.io.File;
import java.io.IOException;

public class FileTest {
	
	public static void main(String[] arg) throws IOException{
		File file =new File("e:/Temp/b.txt");
		file.createNewFile();
	}
}
