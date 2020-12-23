package IOStreamDemo;

import java.io.FileOutputStream;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesDemo {
	public static void main(String[] args) throws Exception {
		// �����ļ�
		Files.copy(Paths.get("C:\\Users\\���˹�\\Desktop\\test.txt"),
				new FileOutputStream("C:\\Users\\���˹�\\Desktop\\testtb.txt"));
		// 2.����ָ���ַ�����ȡ�ļ�����
		List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\���˹�\\Desktop\\test.txt"));
		for (String str : lines)
			System.out.println(str);
		// 3.���ַ���д���ļ���
		List<String> words = new ArrayList();
		words.add("��������");
		words.add("��������");
		// Files.write(Paths.get("C:\\Users\\���˹�\\Desktop\\test.txt", words,
		// Charset.forName("GB2312")));
		// 4.ʹ��Java 8������Stream API�г�Ŀ¼�������ļ�����Ŀ¼
		Files.list(Paths.get("C:\\Users\\���˹�\\Desktop\\"));
		// 5.�ж�C�̵��ܿռ䣬���ÿջ��Ͱ�
		FileStore cDisk = Files.getFileStore(Paths.get("c:"));
		System.out.println("C�̹��пռ䣺" + cDisk.getTotalSpace());
		System.out.println("C�̹��пռ䣺" + cDisk.getTotalSpace());

	}
}
