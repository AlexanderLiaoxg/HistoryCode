package MultithreadingDemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\廖兴广\\Desktop\\测试2.txt");
		RandomAccessFile rgf = new RandomAccessFile(f, "r");
		System.out.println(new String(rgf.readLine().getBytes("8859_1")));// Java使用ISO-8859-1编码是因为这种编码国际上是通用的,可以兼容很多国家的语言编码。
		System.out.println(rgf.getFilePointer());
		rgf.seek(0);
		System.out.println(rgf.getFilePointer());
		System.out.println(new String(rgf.readLine().getBytes("8859_1")));// 是最统一的
	}
}
