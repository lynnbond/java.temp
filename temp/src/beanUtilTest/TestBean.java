package beanUtilTest;

import java.sql.Date;
import java.sql.Timestamp;

public class TestBean {
	String str;
	Integer integer;
	Double dou;
	Date date;
	Timestamp timestamp;
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public Integer getInteger() {
		return integer;
	}
	public void setInteger(Integer integer) {
		this.integer = integer;
	}
	public Double getDou() {
		return dou;
	}
	public void setDou(Double dou) {
		this.dou = dou;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
