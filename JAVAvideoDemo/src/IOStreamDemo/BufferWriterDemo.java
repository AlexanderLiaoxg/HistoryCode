package IOStreamDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterDemo {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("C:\\Users\\廖兴广\\Desktop\\测试2.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("hello");
			bw.newLine();
			bw.newLine();
			bw.write("What is this ?");
			bw.newLine();
			bw.newLine();
			bw.write("LXG");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RDemo();
	}

	private static void RDemo() {

		try {
			BufferedReader br = null;
			FileReader fr = new FileReader("C:\\Users\\廖兴广\\Desktop\\测试2.txt");
			br = new BufferedReader(fr);
			String str = null;
			try {
				while ((str = br.readLine()) != null) {
					System.out.println(str);
				}
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
