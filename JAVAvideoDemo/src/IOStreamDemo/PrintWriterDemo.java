package IOStreamDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * PrintStream与PrintWriter的区别
 * PrintStream是System.out采用的书处格式，输出是系统默认的字符格式，这样从一个平台输出到另外一个平台的时候就会出现不可控性（乱码）
 * PrintWriter出现的比PrintStream晚，但是功能比它更加的强大，可以程序员自定义输出的字符格式，这样它的可控性会更加的好
 * 
 * 个人理解：使用转换流装饰一下printStream
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
		FileOutputStream fos = new FileOutputStream("C:\\Users\\廖兴广\\Desktop\\测试2.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, charSet); // 为打印确定模式
		PrintWriter pw = new PrintWriter(osw, true);// 参数true表示自动刷新，输出字符流的时候转换为字节流
		pw.println("姓名\t年龄\t英语\t数学\t平均成绩");
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

	// 采用指定字符集读取文本文件 源文件 字符集
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
		std[0] = new Student("孙悟空", 22, 88.6, 92.5);
		std[1] = new Student("猪八戒", 19, 78, 86);
		printStudent(std, "C:\\Users\\廖兴广\\Desktop\\测试2.txt", "GBK");
		readStudent("C:\\Users\\廖兴广\\Desktop\\测试2.txt", "GBK");
	}

}
