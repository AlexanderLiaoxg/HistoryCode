package IOStreamDemo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class fileinputStream { // �����Ǵ�Ӳ�����뵽�ڴ���ȥ
	public static void main(String[] args) {
		File f = new File("C:\\Users\\���˹�\\Desktop\\��ɾ����\\nihao.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f); // I/O����������Ӳ�̺��ڴ�֮�佨��һ���ܵ�

			BufferedInputStream bis = new BufferedInputStream(fis); // ��Buffer��ͷ�������Դ��������� , ����IO����

			int readFile;
			byte buf[] = new byte[1024]; // 1K,�Լ�����һ��������
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
