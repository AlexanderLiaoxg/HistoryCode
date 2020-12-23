package IOStreamDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 文件的多线程copy：3段，他是在三个线程里拷贝。 Thread,RandoomAccessFile 
*/
public class BufferReaderDemo {
	/** 将键盘数据输入文件 **/
	public static void main(String[] args) {
		BufferedReader br = null; // 声明字符缓冲器输入流对象
		// 采用装饰器实例化字符缓冲器输入流对象
		br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.println("请输入数据：");
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("输入内容是:" + str);

	}
}
