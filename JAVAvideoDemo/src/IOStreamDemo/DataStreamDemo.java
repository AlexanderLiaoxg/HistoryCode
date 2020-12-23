package IOStreamDemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//  DataI/OStream�ĺô���������data�ļ�ֻ����DataI/OStream���ж�д

public class DataStreamDemo {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\���˹�\\Desktop\\����.txt");
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeChars("�����\t");
		dos.writeInt(22);
		dos.writeDouble(88.6);
		dos.writeDouble(92.5);
		dos.writeChars("��˽�\t");
		dos.writeInt(19);
		dos.writeDouble(78.0);
		dos.writeDouble(86.00);
		dos.close();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		DataInputStream dis = new DataInputStream(bis);
		char name[] = new char[10];
		int age;
		double english, math;
		while (true) {
			char t;
			int index = 0;
			while ((t = dis.readChar()) != '\t') {
				name[index++] = t;
			}
			age = dis.readInt();
			english = dis.readDouble();
			math = dis.readDouble();
			System.out.println(new String(name));
			System.out.println(age + "��" + english + "��" + math);
		}
	}
}
