package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Text2File2 {
	public static void main(String[] args) throws IOException {
		List<String> list=FileUtil.readFileAsList("e:/my-app-data.txt");
		Map<String,Set<String>> uidCodeMap=new HashMap<String,Set<String>>();
		//String xxx="";
		Map<String,ArrayList> hm=new HashMap();
		for(int i=0;i<list.size();i++){
			String str[]=list.get(i).split(",");
			if(!hm.containsKey(str[0])){
				hm.put(str[0], new ArrayList());
			}
			if(hm.get(str[0]).size()<9){
				hm.get(str[0]).add("{\"code\":\""+str[1]+"\"}");
			}
/*			if(!str[0].equals(xxx)){
				if(!xxx.equals("")){
					hm.get(xxx).add("{\"code\":\"\"}");
				}
				xxx=str[0];
			}*/
		}
		
		for(List item:hm.values()){
			item.add("{\"code\":\"75e415427f214a6495b5c9dd7e63e7f6\"}");
		}
		
		
		FileOutputStream os=new FileOutputStream(new File("d:\\xxx3.txt"));
		for(String userId:hm.keySet()){
			os.write(("insert into WOA_USER_KV_STORAGE (user_id,domain,key_str,value_str) values ('"+userId+"','sogou-inc.com','$KV_FRONT$config',"+"'{\"apps\":"+hm.get(userId)+"}');\n").getBytes());
		}
		
	}
}
