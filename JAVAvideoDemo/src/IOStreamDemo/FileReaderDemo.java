package IOStreamDemo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderDemo {
	public static void main(String[] args) throws IOException {
		String file = "C:\\Users\\มฮะหนใ\\Desktop\\outUTF.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String str;
			while ((str = br.readLine()) != null) {
				System.out.print(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
