package MultithreadingDemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\���˹�\\Desktop\\����2.txt");
		RandomAccessFile rgf = new RandomAccessFile(f, "r");
		System.out.println(new String(rgf.readLine().getBytes("8859_1")));// Javaʹ��ISO-8859-1��������Ϊ���ֱ����������ͨ�õ�,���Լ��ݺܶ���ҵ����Ա��롣
		System.out.println(rgf.getFilePointer());
		rgf.seek(0);
		System.out.println(rgf.getFilePointer());
		System.out.println(new String(rgf.readLine().getBytes("8859_1")));// ����ͳһ��
	}
}
