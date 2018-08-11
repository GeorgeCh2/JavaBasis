package cn.george.io.objetStream;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhouzhi@qbb6.com
 * @date 2018/8/11 14:27
 */
public class TestStream implements Serializable {
	private String name;
	private Date date;

	public TestStream(String name, Date date) {
		this.name = name;
		this.date = date;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String toString() {
		return "name: " + this.name + " date: " + this.date;
	}
}
