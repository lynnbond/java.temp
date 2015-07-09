package http;

import java.io.File;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;

public class Hclient {
	public static void main(String args[]) {
		String targetURL = null;// TODO 指定URL
		File targetFile = null;// TODO 指定上传文件

		targetFile = new File("D:/Works/Projects/照片墙/人员照片/褚剑.jpg");
		targetURL = "http://innerupload01.picupload.djt.sogou-op.org/http_upload?"; // servleturl
		PostMethod filePost = new PostMethod(targetURL); // 若没有commons-codec-1.4-bin.zip,
															// 这里将会出错
		try {

	        NameValuePair name=new NameValuePair("sign_f1", "chujian");
	        NameValuePair password=new NameValuePair("appid", "18990001");
	        
	        NameValuePair[] data = {name,password}; 
			
			// 通过以下方法可以模拟页面参数提交
			//filePost.setParameter("sign_f1", "chujian");
			//filePost.setParameter("appid", "18990001");
			filePost.setQueryString(data);
			Part[] parts = { new FilePart("f1", targetFile)};
			filePost.setRequestEntity(new MultipartRequestEntity(parts,filePost.getParams()));
			
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
			
			int status = client.executeMethod(filePost);
			
			if (status == HttpStatus.SC_OK) {
				System.out.println("上传成功");
				// 上传成功
			} else {
				System.out.println("上传失败");
				// 上传失败
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			filePost.releaseConnection();
		}
	}
}
