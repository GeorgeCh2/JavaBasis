package cn.george.io.file;

import java.io.*;

/**
 * @author zhouzhi@qbb6.com
 * @date 2018/8/12 17:05
 */
public class FileStreamTest {
	private static final String FILE_NAME = "file.txt";

	public static void main(String[] args) {
		write();
		read();
	}

	private static void write() {
		try {
			File file = new File(FILE_NAME);

			//默认关闭"追加模式"
			FileOutputStream outputStream = new FileOutputStream(file);
			//为了方便操作，使用printStream写入数据
			PrintStream printStream = new PrintStream(outputStream);
			printStream.print("abcdefghijklmnopqrstuvwxyz");
			printStream.close();

			//使用"追加"模式，即写入的内容追加到原始的内容之后
			FileOutputStream output = new FileOutputStream(file, true);
			PrintStream print = new PrintStream(output);
			print.println("0123456789");
			print.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void read() {
		try {
			File file = new File(FILE_NAME);
			FileInputStream input1 = new FileInputStream(file);

			FileInputStream input2 = new FileInputStream(FILE_NAME);

			FileDescriptor descriptor = input2.getFD();
			FileInputStream input3 = new FileInputStream(descriptor);

			char ch = (char) input1.read();
			System.out.println("read input char: " + ch);


			input1.skip(25);

			byte[] buffer = new byte[10];
			input1.read(buffer, 0, buffer.length);
			System.out.println("read buffer: " + new String(buffer));

			BufferedInputStream bufferedInputStream = new BufferedInputStream(input3);
			char ch2 = (char) bufferedInputStream.read();
			System.out.println("read descriptor char: " + ch2);

			input1.close();
			input2.close();
			input3.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
