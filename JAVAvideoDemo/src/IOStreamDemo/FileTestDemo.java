package IOStreamDemo;

import java.io.File;

// isDirectory()是检查对象是否为文件夹，为布尔类型；
//.exists()是检查文件是否存在

public class FileTestDemo {
	public static void main(String[] args) {
		// java中:windows:D:\\
		// Unix:D:/
		// .
		// File file = new File("D:\\hehe\\.txt"); // File 类是一个路径 ,
		// 俩个斜杠的原因是以为\是在JAVA里面是转义字符
		// File file1 = new File("D:/hehe/1.txt");
		File file = new File("."); // . 表示当前路径
		System.out.println(file.getName());

		System.out.println(file.getAbsolutePath());
		File newFile = new File("C:\\Users\\廖兴广\\Desktop\\待删除的");
		// try {
		// newFile.createNewFile();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.out.println("newFile对象是否存在：" + newFile.exists());
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
