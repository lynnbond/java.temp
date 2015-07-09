package beanUtilTest;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.WrapDynaBean;
import org.apache.commons.beanutils.WrapDynaClass;
import org.apache.commons.beanutils.converters.SqlDateConverter;


public class Test {
	
	
	
	public static void main(String[] args) throws Exception{
		//ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
		//ConvertUtils.register(new SqlDateConverter(null), java.util.Date.class);
//		TestBean bean=new TestBean();
//		BeanMap bmap=new BeanMap(bean);
//		System.out.println(bmap.getType("str"));
//		System.out.println(bmap.getType("integer"));
//		System.out.println(bmap.getType("dou"));
//		System.out.println(bmap.getType("date"));
//		System.out.println(bmap.getType("timestamp"));
//		System.out.println(bmap.containsKey("sdddtr"));
//		
//		Field[] fields =bean.getClass().getDeclaredFields();
//		
//		bmap.put("str", "dddd");
//		//bmap.put("dou", Integer.valueOf("11"));
//		//bmap.put("date", "2010-05-01");
//		
//		// DynaBean wrapper = new WrapDynaBean(bean);
//		 //   String firstName =(String) wrapper.get("str");
//		for(int i=0;i<fields.length;i++){
//			
//			System.out.println(fields[i].getType());
//		}
//		if(bmap.getType("str").equals(String.class)){
//			bmap.put("str", "aaa");
//		}
//		bean=(TestBean)bmap.getBean();
//		System.out.println(bean.getDate());
		
		
		//=========================ConvertUtilsBean test==========
//		ConvertUtilsBean cub=new ConvertUtilsBean();
//
//		java.sql.Date date=(java.sql.Date)cub.convert("2010-01-11", java.sql.Date.class);
//		
//		Timestamp ts=(Timestamp)cub.convert("2010-01-11 10:10:10", Timestamp.class);
//		System.out.println(date);
//		System.out.println(ts);
		
		//=========================WrapDynaClass test==========
//		String field="timestamp";
//		String fieldValue="10:10:10";
//		ConvertUtilsBean cub=new ConvertUtilsBean();
//		TestBean bean=new TestBean();
//		WrapDynaBean wdb=new WrapDynaBean(bean);
//		DynaClass dc= wdb.getDynaClass();
//		DynaProperty dp=dc.getDynaProperty(field);
//		Object value=cub.convert(fieldValue, dp.getType());
//		wdb.set(field, value);
//		System.out.println(wdb.get(field));
		//System.out.println(bean.getDou());
		
		
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		System.out.println( myFmt.format(Timestamp.valueOf("2010-01-01 10:10:10")));
		
	}
	
	
}
