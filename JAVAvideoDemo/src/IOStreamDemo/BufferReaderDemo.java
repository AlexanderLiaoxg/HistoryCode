package IOStreamDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * �ļ��Ķ��߳�copy��3�Σ������������߳������� Thread,RandoomAccessFile 
*/
public class BufferReaderDemo {
	/** ���������������ļ� **/
	public static void main(String[] args) {
		BufferedReader br = null; // �����ַ�����������������
		// ����װ����ʵ�����ַ�����������������
		br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.println("���������ݣ�");
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����������:" + str);

	}
}
