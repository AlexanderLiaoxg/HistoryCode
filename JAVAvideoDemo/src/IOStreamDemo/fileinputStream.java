package IOStreamDemo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class fileinputStream { // 输入是从硬盘输入到内存中去
	public static void main(String[] args) {
		File f = new File("C:\\Users\\廖兴广\\Desktop\\待删除的\\nihao.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f); // I/O流的作用在硬盘和内存之间建设一根管道

			BufferedInputStream bis = new BufferedInputStream(fis); // 有Buffer开头代表是自带缓冲区的 , 降低IO次数

			int readFile;
			byte buf[] = new byte[1024]; // 1K,自己定义一个缓冲区
			try {
				while ((readFile = fis.read(buf)) != -1) {
					System.out.print(new String(buf, 0, readFile));
					// System.out.print((char) readFile);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
