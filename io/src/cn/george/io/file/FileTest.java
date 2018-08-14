package cn.george.io.file;

import java.io.File;

/**
 * @author zhouzhi@qbb6.com
 * @date 2018/8/14 19:04
 */
public class FileTest {

	private static void printFileSeparator() {
		System.out.printf("File.pathSeparator: \"%s\"\n", File.pathSeparator);

		System.out.printf("File.pathSeparatorChar: \"%c\"\n", File.pathSeparatorChar);

		System.out.printf("File.separator: \"%s\"\n", File.separator);

		System.out.printf("File.separatorChar: \"%s\"\n", File.separatorChar);
	}

	private static void fileApis() {
		try {
			//新建目录"dir"
			File dir = new File("dir");
			dir.mkdir();

			//新建目录"dir/sub1", 父目录"dir"必须已经存在
			File sub1 = new File("dir", "sub1");
			sub1.mkdir();

			//新建目录"dir/sub2"。父目录"dir"必须存在
			File sub2 = new File(dir, "sub2");
			sub2.mkdir();

			//新建目录"dir/sub3"。会自动创建不存在的父目录
			File sub3 = new File("dir/sub3");
			sub3.mkdir();

			//获取dir的绝对路径
			String dirPath = dir.getAbsolutePath();
			String sub4AbsPath = dirPath + File.separator + "sub4";
			//新建目录"dir/sub4"。根据"绝对路径"创建
			File sub4 = new File(sub4AbsPath);
			sub4.mkdir();

			//新建文件
			File txtFile = new File(dir, "normal.txt");
			txtFile.createNewFile();

			File hideFile = new File("dir", ".hide.txt");
			hideFile.createNewFile();

			String absFilePath = dirPath + File.separator + "abs.txt";
			File absFile = new File(absFilePath);
			absFile.createNewFile();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
