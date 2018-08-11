package cn.george.io.objetStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zhouzhi@qbb6.com
 * @date 2018/8/11 14:19
 */
public class ObjectStreamTest {
	private static final String TMP_FILE = "Stream.tmp";

	public static void main(String[] args) {
		testWrite();
		testRead();
	}

	/**
	 * 测试写入
	 */
	private static void testWrite() {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(
							new FileOutputStream(TMP_FILE));
			outputStream.writeBoolean(true);
			outputStream.writeByte((byte)63);
			outputStream.writeChar('a');
			outputStream.writeInt(20180811);
			outputStream.writeFloat(3.14F);
			outputStream.writeDouble(1.414D);

			//写入map对象
			Map<String, String> map = new HashMap<>();
			map.put("one", "1");
			map.put("two", "2");
			map.put("three", "3");
			outputStream.writeObject(map);

			//写入自定义对象，需实现Serializable接口
			TestStream stream = new TestStream("george", new Date());
			outputStream.writeObject(stream);

			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testRead() {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(
							new FileInputStream(TMP_FILE));

//			System.out.printf("boolean: %b\n", inputStream.readBoolean());
			System.out.printf("byte: %d\n", inputStream.readByte());
			System.out.printf("char: %c\n", inputStream.readChar());
			System.out.printf("int: %d\n", inputStream.readInt());
			System.out.printf("float: %f\n", inputStream.readFloat());
			System.out.printf("double: %f\n", inputStream.readDouble());

			Map<String, String> map = (Map<String, String>) inputStream.readObject();
			for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
				String key = it.next();
				System.out.printf("%-6s -- %s\n", key, map.get(key));
			}

			TestStream stream = (TestStream) inputStream.readObject();
			System.out.println("stream: " + stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
