package IOStreamDemo;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
	public static void main(String[] args) {
		// 1,�Ե�ǰ·��������Path����
		Path path = Paths.get(".");
		System.out.println("path������·��������" + path.getNameCount());
		System.out.println("path�ĸ�·����" + path.getRoot());
		// ��ȡpath��Ӧ����Ծ���·��
		Path absolutePath = path.toAbsolutePath();
		System.out.println("����·����" + absolutePath);
		// ��ȡ����·���ĸ�·��
		System.out.println("·��" + absolutePath.getRoot());
		// ��ȡ����·����������·������
		for (int i = 0; i < absolutePath.getNameCount(); i++)
			System.out.println("·����" + absolutePath.getName(i));
		// �Զ��String������path����
		Path path2 = Paths.get("D", "tempDir", "temp");
	}
}
