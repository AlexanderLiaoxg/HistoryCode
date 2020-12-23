package IOStreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOCopy {
	public FileIOCopy() {
		File fp = new File("C:\\Users\\���˹�\\Desktop\\MyPhoto.jpg");
		try {
			FileInputStream in = new FileInputStream(fp);
			FileOutputStream out = new FileOutputStream("C:\\Users\\���˹�\\Desktop\\��ɾ����\\MyPhoto.jpg");
			byte[] b = new byte[1024];
			int readFile;
			try {
				while ((readFile = in.read(b)) != -1) {
					out.write(b);
				}
				out.flush();
				out.close();
				in.close();
				System.out.println("�����ɹ���");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new FileIOCopy();
	}
}
