package cn.george.io.file;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author zhouzhi@qbb6.com
 * @date 2018/8/16 21:37
 */
public class FileDescriptorTest {
	private static final String FILE_NAME = "file.txt";
	private static final String OUT_TEXT = "FileDescriptor out!!!";

	public static void main(String[] args) {
		testWrite();
		testRead();
		
		testPrint();
	}

	/**
	 * out:标准输出（屏幕）的描述符
	 * out本质是FileDecriptor对象
	 */
	private static void testPrint() {
		PrintStream out = new PrintStream(new FileOutputStream(FileDescriptor.out));

		out.println(OUT_TEXT);
		out.close();
	}

	/**
	 * 通过文件名创建 FileOutputStream 与 通过文件描述符（FileDecriptor)创建的FileOutputStream 对象是等效的
	 */
	private static void testWrite() {
		try {
			FileOutputStream out = new FileOutputStream(FILE_NAME);
			FileDescriptor descriptor = out.getFD();

			FileOutputStream outputStream = new FileOutputStream(descriptor);

			out.write('A');
			outputStream.write('a');

			if (descriptor != null) {
				System.out.printf("FileDecriptor(%s) is %s\n", descriptor, descriptor.valid());
			}

			out.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testRead() {
		try {
			FileInputStream in = new FileInputStream(FILE_NAME);
			FileDescriptor descriptor = in.getFD();

			FileInputStream inputStream = new FileInputStream(descriptor);

			System.out.println("in.read(): " + (char)in.read());
			System.out.println("inputStream.read(): " + (char)inputStream.read());

			if (descriptor != null) {
				System.out.printf("FileDescriptor(%s) is %s\n", descriptor, descriptor.valid());
			}

			in.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
