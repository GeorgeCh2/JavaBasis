package cn.george.io.input;

import java.io.ByteArrayInputStream;

/**
 * ByteArrayInputStream 测试
 *
 * @author zhouzhi@qbb6.com
 * @date 2018/8/7 14:28
 */
public class ByteArrayInputStreamTest {
	private static final int LEN = 5;

	/**
	 * 对应英文字母："abcdefghijklmnopqretuvwxyz"
	 */
	private static final byte[] arrayLetters = {0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69,
					0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
					0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A};

	public static void main(String[] args) {
		String arrayStr = new String(arrayLetters);
		System.out.println("ArrayLetters = " + arrayStr);

		testByteArrayInputStream();
	}

	private static void testByteArrayInputStream() {
		ByteArrayInputStream stream = new ByteArrayInputStream(arrayLetters);

		for (int i = 0; i < LEN; i++) {
			//能否继续读取下一个字节
			if (stream.available() >= 0) {
				int temp = stream.read();
				System.out.printf("%d : 0x%s\n", i, Integer.toHexString(temp));
			}
		}

		if (!stream.markSupported()) {
			System.out.println("make not supported!");
			return;
		}

		//标记“字节流中下一个被读取的位置”，当前已经读了5个字节，所以标记的为第6个位置；此方法的参数没有任何实际意义
		stream.mark(0);

		//跳过5个字节，即下一个要读取的位置为第11个字节
		stream.skip(5);

		byte[] buf = new byte[LEN];
		//从字节流中读取5个字节到buf中
		stream.read(buf, 0, LEN);

		//将字节数组转换为字符串
		String str = new String(buf);
		System.out.printf("str=%s\n", str);

		//重置“字节流”：将下一个要读取的位置重置到之前标记的位置，即第6个字节
		stream.reset();

		//从第6个字节开始读取5个字节到buf中
		stream.read(buf, 0, LEN);

		String str1 = new String(buf);
		System.out.printf("str1=%s\n", str1);
	}
}
