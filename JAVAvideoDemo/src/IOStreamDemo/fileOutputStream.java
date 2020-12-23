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
			out = new FileOutputStream("C:\\Users\\廖兴广\\Desktop\\待删除的\\nihao.txt", true);
			String w = scan.nextLine();
			try {
				out.write(w.getBytes());
				out.flush(); // 一旦（管道）有异常，尽量把存在管道中的数据放到文件中
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
