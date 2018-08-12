package cn.george.io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化存储static和transient变量
 *
 * @author zhouzhi@qbb6.com
 * @date 2018/8/12 15:40
 */
public class SerializaStatic {
	private static final String TMP_FILE = ".serialStatic.txt";

	public static void main(String[] args) {
		testWrite();
		testRead();
	}

	private static void testWrite() {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(
							new FileOutputStream(TMP_FILE));

			StaticObject object = new StaticObject("serialStatic", 4, 8);
			outputStream.writeObject(object);

			System.out.println("Write Object: " + object);

			object = new StaticObject("transient", 80, 39);

			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testRead() {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(
							new FileInputStream(TMP_FILE));

			StaticObject object = (StaticObject) inputStream.readObject();
			System.out.println("Read Object: " + object);

			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
