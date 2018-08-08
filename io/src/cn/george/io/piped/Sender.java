package cn.george.io.piped;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * 发送者
 *
 * @author zhouzhi@qbb6.com
 * @date 2018/8/7 17:57
 */
public class Sender extends Thread {
	private PipedOutputStream out = new PipedOutputStream();

	public PipedOutputStream getOutputStream() {
		return this.out;
	}

	@Override
	public void run() {
//		writeMessage("Hello piped!!!");

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 102; i++) {
			stringBuilder.append("0123456789");
		}

		stringBuilder.append("abcdefghigklmnopqrstuvwxyz");

		String str = stringBuilder.toString();

		try {
			writeMessage(str);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 向管道输入流中写入消息
	 * @param message 要写入的消息
	 */
	private void writeMessage(String message) {
		try {
			out.write(message.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
