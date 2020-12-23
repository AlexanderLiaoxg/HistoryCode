package IOStreamDemo;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
	public static void main(String[] args) {
		// 1,以当前路径来创建Path对象
		Path path = Paths.get(".");
		System.out.println("path包含的路径数量：" + path.getNameCount());
		System.out.println("path的根路径：" + path.getRoot());
		// 获取path对应的相对绝对路径
		Path absolutePath = path.toAbsolutePath();
		System.out.println("绝对路径：" + absolutePath);
		// 获取绝对路径的根路径
		System.out.println("路径" + absolutePath.getRoot());
		// 获取绝对路径所包含的路径数量
		for (int i = 0; i < absolutePath.getNameCount(); i++)
			System.out.println("路径：" + absolutePath.getName(i));
		// 以多个String来构建path对象
		Path path2 = Paths.get("D", "tempDir", "temp");
	}
}
