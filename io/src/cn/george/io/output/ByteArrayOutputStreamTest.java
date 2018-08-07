package cn.george.io.output;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * ByteArrayOutputStream 测试
 *
 * @author zhouzhi@qbb6.com
 * @date 2018/8/7 15:49
 */
public class ByteArrayOutputStreamTest {
	private static final int LEN = 5;

	/**
	 * 对应英文字母："abcdefghijklmnopqretuvwxyz"
	 */
	private static final byte[] arrayLetters = {0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69,
					0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
					0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A};

	public static void main(String[] args) {
		testByteArrayOutputStream();
	}

	private static void testByteArrayOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();

		//写入"A", "B", "C"
		stream.write(0x41);
		stream.write(0x42);
		stream.write(0x43);
		System.out.printf("stream = %s\n", stream);

		//将 arrayLetters 数组中从第3个位置之后的5个字节写入stream
		stream.write(arrayLetters, 3, 5);
		System.out.printf("stream = %s\n", stream);

		//长度
		System.out.printf("size = %s\n", stream.size());

		//装换为byte[] 数组
		byte[] buf = stream.toByteArray();
		String bufStr = new String(buf);
		System.out.printf("bufStr = %s\n", bufStr);

		try {
			//写入另一个输入流
			ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
			stream.writeTo(stream1);
			System.out.printf("stream1 = %s\n", stream1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
