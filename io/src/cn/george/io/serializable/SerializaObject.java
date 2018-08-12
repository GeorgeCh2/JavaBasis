package cn.george.io.serializable;

import java.io.Serializable;
import java.util.Date;

/**
 * 包含static和transient修饰的成员
 *
 * @author zhouzhi@qbb6.com
 * @date 2018/8/12 15:08
 */
public class SerializaObject implements Serializable {
	private static int  number;

	private transient int date;

	private String name;

	public SerializaObject(String name, int date, int number) {
		this.name = name;
		this.date = date;
		this.number = number;
	}

	public String toString() {
		return "[name: " + name + " date: " + date + " number: " + number +"]";
	}
}
