package IOStreamDemo;

import java.io.File;

// isDirectory()�Ǽ������Ƿ�Ϊ�ļ��У�Ϊ�������ͣ�
//.exists()�Ǽ���ļ��Ƿ����

public class FileTestDemo {
	public static void main(String[] args) {
		// java��:windows:D:\\
		// Unix:D:/
		// .
		// File file = new File("D:\\hehe\\.txt"); // File ����һ��·�� ,
		// ����б�ܵ�ԭ������Ϊ\����JAVA������ת���ַ�
		// File file1 = new File("D:/hehe/1.txt");
		File file = new File("."); // . ��ʾ��ǰ·��
		System.out.println(file.getName());

		System.out.println(file.getAbsolutePath());
		File newFile = new File("C:\\Users\\���˹�\\Desktop\\��ɾ����");
		// try {
		// newFile.createNewFile();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.out.println("newFile�����Ƿ���ڣ�" + newFile.exists());
		System.out.println(newFile.getParent());
		for (String one : newFile.list()) {
			File onetodelet = new File(newFile.getAbsolutePath() + "\\" + one);
			System.out.println("TIHS IS ONE" + one);
			System.out.println(onetodelet.getAbsolutePath());
			if (onetodelet.delete()) {
				System.out.println("succsed");
			} else {
				System.out.println("failed");
			}
		}
		// newFile.delete();
	}
}
