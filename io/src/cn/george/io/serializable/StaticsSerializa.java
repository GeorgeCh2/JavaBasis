package cn.george.io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 对于static以及transient类型变量不会自动保存状态
 * 但static类型变量意味着所有的对象共用同一个变量
 * @author zhouzhi@qbb6.com
 * @date 2018/8/12 15:05
 */
public class StaticsSerializa {
	private static final String TMP_FILE = ".staticSerial.txt";

	public static void main(String[] args) {
		testWrite();
		testRead();
	}

	private static void testWrite() {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(
							new FileOutputStream(TMP_FILE));

			//包含static及transient修饰的成员
			SerializaObject object = new SerializaObject("serializa", 4, 8);
			outputStream.writeObject(object);

			System.out.println("Write object: " + object);

			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testRead() {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(TMP_FILE));

			SerializaObject object = (SerializaObject) inputStream.readObject();
			System.out.println("Read Object: " + object);

			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
