package file;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Text2File {
	public static void main(String[] args) {
		List<String> list=FileUtil.readFileAsList("e:/my-app-data.txt");
		Map<String,Set<String>> uidCodeMap=new HashMap<String,Set<String>>();
		
		for(String item:list){
			String[] data=item.split(",");
			String uid=data[0];
			String code=data[1];
			Set<String> codeSet=uidCodeMap.get(uid);
			if(codeSet==null){
				codeSet=new HashSet<String>();
				uidCodeMap.put(uid, codeSet);
			}
			codeSet.add(code);
			
		}
		
		//System.out.println(uidCodeMap);
		
		Iterator<Map.Entry<String, Set<String>>> iter=uidCodeMap.entrySet().iterator();
		
		while(iter.hasNext()){
			StringBuffer sb=new StringBuffer();
			Map.Entry<String,Set<String>> entry=iter.next();
			Set codeSet=entry.getValue();
			Iterator<Set<String>> iter2=codeSet.iterator();
			
			while(iter2.hasNext()){
				if(sb.length()>1){
					sb.append(",");
				}
				sb.append("\"code\":\"").append(iter2.next()).append("\"");
			}
			
			FileUtil.appendFile("e:/app-import.txt","{\"app\":["+sb.toString()+"]}");
		}
		
	}
}
