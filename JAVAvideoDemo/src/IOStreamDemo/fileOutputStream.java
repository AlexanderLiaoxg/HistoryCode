package IOStreamDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class fileOutputStream {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("C:\\Users\\���˹�\\Desktop\\��ɾ����\\nihao.txt", true);
			String w = scan.nextLine();
			try {
				out.write(w.getBytes());
				out.flush(); // һ�����ܵ������쳣�������Ѵ��ڹܵ��е����ݷŵ��ļ���
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
