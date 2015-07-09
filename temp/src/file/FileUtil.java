package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 文件读写工具
 * @author liyan 2009-03-10
 *@version 1.0.0
 */
public class FileUtil {
	private FileUtil(){};
	/**
	 * 逐行读取文件,返回List
	 * @param fileFullName
	 * @return
	 */
	public static List readFileAsList(String fileFullName){	
		List list=new ArrayList();
		File file=new File(fileFullName); 

		try 
		{ 
		BufferedReader input=new BufferedReader(new FileReader(file)); 
		String text; 
		while((text=input.readLine())!=null) 
			list.add(text); 
		} catch(Exception ex) {} 			

		return list;		
	}
	
	/**
	 * 将保存在List中的字符串写入文件
	 * @param fileFullName
	 * @param messageList
	 */
	public static void writeListToFile(String fileFullName,List messageList){
		File file=new File(fileFullName);
		Iterator iter=messageList.iterator();
		try{
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			while (iter.hasNext()) {
				output.write(iter.next().toString()+"\r\n");				
			}
			output.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	/**
	 * 将文本写文件
	 * @param fileFullName
	 * @param message
	 */
	public static void writeFile(String fileFullName,String message){
		File file=new File(fileFullName);
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(message);
			output.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 * 向文件中追加内容
	 * @param title
	 * @param message
	 */
	public static void appendFile(String fileFullName, String message){

		RandomAccessFile rf;
		try {
			rf = new RandomAccessFile(fileFullName,"rw");
			rf.seek(rf.length());//将指针移动到文件末尾 
			rf.write(message.getBytes("utf-8"));
			rf.close();//关闭文件流 
		} catch (Exception e) {			
			e.printStackTrace();
		} 
		
	}	
	
	/**
	 * 以二进制格式写文件
	 * @param sourceStream
	 * @param descPath
	 * @param fileName
	 * @throws Exception
	 */
	public static void writeBinFile(InputStream sourceStream,String descPath,String fileName) throws Exception{
		OutputStream os = new FileOutputStream(new File(descPath,fileName));
		InputStream is = sourceStream;
		int length = 0;
	    byte[] b = new byte[1024];
	    
        while ((length = is.read(b)) > 0) {
            os.write(b, 0, length);
        }	   
        
		os.flush();
		os.close();
		is.close();    
	}
	
	//============================================================================================
	
	/**
	 * 检查文件夹是否为空
	 */
	public static boolean checkFolderEmpty(String folderPath){
		File path=new File(folderPath);
		if (path.isDirectory()) {
			File[] child = path.listFiles();
			if (child == null || child.length == 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 检查文件/文件夹是否存在
	 */
	public static boolean checkExist(String path){
		File file = new File(path);
		return file.exists();
	}
	
	/** 
	* 移动文件到指定目录下（目标文件夹不存在，会自动创建）
	* @param srcFile eg: c:\windows\abc.txt 
	* @param destPath eg: c:\temp 
	* @return success 
	*/ 
	public static boolean moveFile(String sourFullName, String destPath) {
		File file = new File(sourFullName);
		File dir = new File(destPath);
		
		if(!dir.exists()) {
			dir.mkdirs(); 
		}
		
		boolean success = file.renameTo(new File(dir, file.getName()));
		return success;
	} 	
	
	
	/**
	 *  文件拷贝
	 * @param sourPath
	 * @param descPath
	 * @throws Exception
	 */
	public static void copyFile(String sourFullName, String descPath,String descFileName) throws Exception {
		File in=new File(sourFullName);
		if("".equals(descFileName)|| descFileName==null){
			descFileName=in.getName();
		}
		File out=new File(descPath,descFileName);
		copyFile(in,out);
	}
	
	/**
	 * 文件拷贝
	 * @param in
	 * @param out
	 * @throws Exception
	 */
	public static void copyFile(File in, File out) throws Exception {
		FileInputStream fis = new FileInputStream(in);
		FileOutputStream fos = new FileOutputStream(out);
		byte[] buf = new byte[1024];
		int i = 0;
		while ((i = fis.read(buf)) != -1) {
			fos.write(buf, 0, i);
		}
		fis.close();
		fos.close();
	}
	 	
	 /**
	 * 删除文件、文件夹
	 * （递归删除）
	 * @param path 需要删除的文件|文件夹
	 */
	public static void removeFile(String path) {
		removeFile(new File(path));
	}

	/**
	 * 删除文件、文件夹（递归删除）
	 * @param path 需要删除的文件|文件夹
	 */
	public static void removeFile(File path) {
		System.out.println("removing file " + path.getPath());
		if (path.isDirectory()) {
			File[] child = path.listFiles();
			if (child != null && child.length != 0) {
				for (int i = 0; i < child.length; i++) {
					removeFile(child[i]);
					child[i].delete();
				}
			}
		}
		path.delete();
	}  
    
	public static void main(String[] args) {
		try {
// FileUtil.writeBinFile(
// new
// FileInputStream("E:\\liyan\\Projects\\JYFX\\Documents\\报表模板\\GSM计费收入统计日报20090103.xls"),
//				"F:\\", "test.xls"
//			);
			//FileUtil.copyFile("E:\\liyan\\Projects\\JYFX\\Documents\\报表模板\\GSM计费收入统计日报20090103.xls", "F:\\","aaa.xls");
			FileUtil.removeFile("f:\\a.pdf");
			FileUtil.moveFile("f:\\anf.pdf", "f:\\temp2\\temp3\\temp4");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
