package IOStreamDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * PrintStream��PrintWriter������
 * PrintStream��System.out���õ��鴦��ʽ�������ϵͳĬ�ϵ��ַ���ʽ��������һ��ƽ̨���������һ��ƽ̨��ʱ��ͻ���ֲ��ɿ��ԣ����룩
 * PrintWriter���ֵı�PrintStream�����ǹ��ܱ������ӵ�ǿ�󣬿��Գ���Ա�Զ���������ַ���ʽ���������Ŀɿ��Ի���ӵĺ�
 * 
 * ������⣺ʹ��ת����װ��һ��printStream
 **/

class Student {
	private String name;
	private int age;
	private double english;
	private double math;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getEnglish() {
		return english;
	}

	public double getMath() {
		return math;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEnglish(double english) {
		this.english = english;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public Student(String name, int age, double english, double math) {
		super();
		this.name = name;
		this.age = age;
		this.english = english;
		this.math = math;
	}
}

public class PrintWriterDemo {
	public static void printStudent(Student[] std, String fileName, String charSet) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\���˹�\\Desktop\\����2.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, charSet); // Ϊ��ӡȷ��ģʽ
		PrintWriter pw = new PrintWriter(osw, true);// ����true��ʾ�Զ�ˢ�£�����ַ�����ʱ��ת��Ϊ�ֽ���
		pw.println("����\t����\tӢ��\t��ѧ\tƽ���ɼ�");
		for (int i = 0; i < std.length; i++) {
			pw.print(std[i].getName() + "\t");
			pw.print(std[i].getAge() + "\t");
			pw.print(std[i].getEnglish() + "\t");
			pw.print(std[i].getMath() + "\t");
			pw.print((std[i].getEnglish() + std[i].getMath()) / 2);
			pw.println();
		}
		fos.close();
		osw.close();
	}

	// ����ָ���ַ�����ȡ�ı��ļ� Դ�ļ� �ַ���
	public static void readStudent(String fileName, String charSet) throws IOException, FileNotFoundException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), charSet);
		char[] buf = new char[1024];
		int hasData = 0;
		while ((hasData = isr.read(buf)) > 0) {
			System.out.println(new String(buf, 0, hasData));
		}
		isr.close();
	}

	public static void main(String[] args) throws IOException {
		Student[] std = new Student[2];
		std[0] = new Student("�����", 22, 88.6, 92.5);
		std[1] = new Student("��˽�", 19, 78, 86);
		printStudent(std, "C:\\Users\\���˹�\\Desktop\\����2.txt", "GBK");
		readStudent("C:\\Users\\���˹�\\Desktop\\����2.txt", "GBK");
	}

}
