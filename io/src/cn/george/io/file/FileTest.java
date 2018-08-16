package cn.george.io.file;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author zhouzhi@qbb6.com
 * @date 2018/8/14 19:04
 */
public class FileTest {

	public static void main(String[] args) {
		printFileSeparator();

		fileApis();
	}

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

			String uri_path = "file:" + dirPath + File.separator + "uri.txt";
			URI uri = new URI(uri_path);
			File file = new File(uri);
			file.createNewFile();

			File normal = new File(sub1, "normal.txt");
			normal.createNewFile();

			System.out.println("normalFile is exists: " + normal.exists());
			System.out.println("normalFile's name is: " + normal.getName());
			System.out.println("normalFile's parent is:" + normal.getParent());
			System.out.println("normalFile's path is: " + normal.getPath());
			System.out.println("normalFile's absolutePath is: " + normal.getAbsolutePath());
			//返回此抽象路径名的规范路径名字符串
			System.out.println("normalFile's canonicalPath is: " + normal.getCanonicalPath());
			//文件最后一次被修改的时间
			System.out.println("normalFile's lastModified is: " + getLastModify(normal.lastModified()));
			System.out.println("normalFile's uri is: " + normal.toURI());

			//列出"dir"目录下的文件和文件夹
			System.out.println("----dir list files and folders----");
			File[] files = dir.listFiles();
			for (File file1 : files) {
				String isAbs = file1.isAbsolute() ? "[Absolute]" : "";
				String isHidden = file1.isHidden() ? "[Hidden]" : "";
				String isDir = file1.isDirectory() ? "[Directory]" : "";
				String isFile = file1.isFile() ? "[File]" : "";
				System.out.println(file1.getName() + isAbs + isHidden + isDir + isFile);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getLastModify(Long time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return format.format(calendar.getTime());
	}
}
