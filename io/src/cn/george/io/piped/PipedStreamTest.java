package cn.george.io.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道输入流和输出流的测试
 *
 * @author zhouzhi@qbb6.com
 * @date 2018/8/7 18:10
 */
public class PipedStreamTest {
	public static void main(String[] args) {
		Sender sender = new Sender();

		Revicer revicer = new Revicer();

		PipedOutputStream outputStream = sender.getOutputStream();

		PipedInputStream inputStream = revicer.getInputStream();

		try {
			inputStream.connect(outputStream);

			sender.start();
			revicer.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
