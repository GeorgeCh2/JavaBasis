package cn.george.io.serializable;

import cn.george.io.objetStream.TestStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author zhouzhi@qbb6.com
 * @date 2018/8/12 11:50
 */
public class SerializaTest {
	private static final String TMP_FILE = ".serializaTest.txt";

	public static void main(String[] args) {
		testWrite();
		testRead();
	}

	/**
	 * 将TestStream通过序列化，保存到文件中
	 */
	private static void testWrite() {
		try {
			//ObjectOutputStream:只能写入"基本数据"或"支持序列化的对象"
			ObjectOutputStream outputStream = new ObjectOutputStream(
							new FileOutputStream(TMP_FILE));

			TestStream stream = new TestStream("serializa", new Date());
			outputStream.writeObject(stream);
			System.out.println("Write Stream: " + stream);

			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从文件中读取出"序列化的对象"
	 */
	private static void testRead() {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(
							new FileInputStream(TMP_FILE));

			TestStream stream= (TestStream) inputStream.readObject();
			System.out.println("Read stream: " + stream);

			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
