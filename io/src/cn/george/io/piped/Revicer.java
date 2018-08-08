package cn.george.io.piped;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * 接收者
 *
 * @author zhouzhi@qbb6.com
 * @date 2018/8/7 17:48
 */
public class Revicer extends Thread{
	private PipedInputStream in = new PipedInputStream();

	public PipedInputStream getInputStream() {
		return in;
	}

	@Override
	public void run() {
//		readMessage();
		readMessageDuation();
	}

	/**
	 * 从管道输入流中读取数据
	 */
	public void readMessage() {
		//由于管道输入流的缓冲区大小默认为1024，最多只能读取1024个字节
		byte[] buffer = new byte[2048];

		try {
			int len = in.read(buffer);
			System.out.println(new String(buffer, 0, len));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readMessageDuation() {
		int total = 0;
		while (true) {
			byte[] buffer = new byte[1024];
			try {
				int length = in.read(buffer);
				total += length;
				System.out.println(new String(buffer, 0, length));

				if (total > 1024) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
