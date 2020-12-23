package IOStreamDemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyFile {
	public static void main(String[] args) throws Exception {
		boolean flag = false;
		String srcFile = "C:\\廖兴广\\Desktop\\srcFile.txt";
		String destFile = "C:\\廖兴广\\Desktop\\destFile.txt";
		flag = copyFile(srcFile, destFile);
		if (flag) {
			System.out.println("复制成功");
		}
	}

	public static boolean copyFile(String srcFile, String destFile) throws Exception {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(srcFile)));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(destFile)));
		byte[] s = new byte[1024];
		int hasdata = 0;
		while ((hasdata = bis.read(s)) > 0) {
			bos.write(s);
		}
		return true;

	}
}
