package IOStreamDemo;

import java.io.FileOutputStream;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesDemo {
	public static void main(String[] args) throws Exception {
		// 复制文件
		Files.copy(Paths.get("C:\\Users\\廖兴广\\Desktop\\test.txt"),
				new FileOutputStream("C:\\Users\\廖兴广\\Desktop\\testtb.txt"));
		// 2.采用指定字符集读取文件内容
		List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\廖兴广\\Desktop\\test.txt"));
		for (String str : lines)
			System.out.println(str);
		// 3.把字符串写到文件中
		List<String> words = new ArrayList();
		words.add("保护环境");
		words.add("人人有责");
		// Files.write(Paths.get("C:\\Users\\廖兴广\\Desktop\\test.txt", words,
		// Charset.forName("GB2312")));
		// 4.使用Java 8新增的Stream API列出目录下所有文件和子目录
		Files.list(Paths.get("C:\\Users\\廖兴广\\Desktop\\"));
		// 5.判断C盘的总空间，可用空机就按
		FileStore cDisk = Files.getFileStore(Paths.get("c:"));
		System.out.println("C盘共有空间：" + cDisk.getTotalSpace());
		System.out.println("C盘共有空间：" + cDisk.getTotalSpace());

	}
}
