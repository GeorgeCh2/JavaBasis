package cn.george.io.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 重写writeObject() 和 readObject() 方法
 *
 * @author zhouzhi@qbb6.com
 * @date 2018/8/12 15:45
 */
public class StaticObject implements Serializable {
	private static int number;

	private transient int age;

	private String name;

	public StaticObject(String name, int age, int number) {
		this.name = name;
		this.age = age;
		this.number = number;
	}

	/**
	 * writeObject 的原始定义在 ObjectOutputStream 中
	 * 通过覆写此方法，将static和transient变量手动保存
	 */
	private void writeObject(ObjectOutputStream outputStream) throws IOException {
		//使定制的writeObject 方法可以利用自动序列化中内置的逻辑
		outputStream.defaultWriteObject();
		outputStream.writeInt(this.age);
		outputStream.writeInt(this.number);
	}

	/**
	 * readObject 的原始定义在 ObjectInputStream 中
	 */
	private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
		//使定制的readObject 方法可以利用自动序列化内置的逻辑
		inputStream.defaultReadObject();
		this.age = inputStream.readInt();
		this.number = inputStream.readInt();
	}

	public String toString() {
		return "[name: " + this.name + " age:" + this.age + " number:" + this.number +"]";
	}
}
