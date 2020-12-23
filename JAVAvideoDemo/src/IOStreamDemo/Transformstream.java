package IOStreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Transformstream {
	public static void main(String[] args) throws UnsupportedEncodingException {
		File fileUTF = new File("C:\\Users\\廖兴广\\Desktop\\outUTF.txt");
		File fileGBK = new File("C:\\Users\\廖兴广\\Desktop\\outGBK.txt");

		try {
			OutputStreamWriter oswUTF = new OutputStreamWriter(new FileOutputStream(fileUTF), "UTF-8");

			OutputStreamWriter oswGBK = new OutputStreamWriter(new FileOutputStream(fileGBK), "GBK");

			// char[] ch = "What?!这是中文".toCharArray(); // 把字符串转换为字符数组
			String enter;
			Scanner input = new Scanner(System.in);
			System.out.println("请输入你要写入文档的话语：");
			enter = input.nextLine();
			oswUTF.write(enter);
			oswUTF.flush();
			oswUTF.close();
			oswGBK.write(enter);
			oswGBK.flush();
			oswGBK.close();

			oswUTF.close();
			// oswGBK.close();
			System.out.println("Succssed");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		try {
			InputStreamReader isrUTF = new InputStreamReader(new FileInputStream(fileUTF), "UTF-8");
			InputStreamReader isrGBK = new InputStreamReader(new FileInputStream(fileGBK), "GBK");
			char[] c = new char[1024];
			try {
				isrUTF.read(c);
				System.out.println(c);
				isrUTF.close();
				isrGBK.read(c);
				System.out.println(c);
				isrGBK.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
