package IOStreamDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DUOXIANCHENG {
	public static void main(String[] args) {

		MyRunnableReader my = new MyRunnableReader();
		Thread thread1 = new Thread(my, "�߳�A");
		Thread thread2 = new Thread(my, "�߳�B");
		Thread thread3 = new Thread(my, "�߳�C");
		thread1.start();
		thread2.start();
		thread3.start();

	}
}

class MyRunnableReader implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("C:\\Users\\���˹�\\Desktop\\����.txt");
			int hasdata;
			char[] ch = new char[2];
			try {
				while ((hasdata = fr.read(ch)) != -1) {
					System.out.print(ch);
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

// class MyRunnableWriter implements Runnable {
//
// @Override
// public void run() {
// // TODO Auto-generated method stub
// try {
// FileWriter fr = new FileWriter("C:\\Users\\���˹�\\Desktop\\����2.txt");
// int hasdata;
// char[] ch = new char[2];
// try {
// while ((hasdata = fr.read(ch)) != -1) {
// System.out.print(ch);
// }
// } catch (IOException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// } catch (FileNotFoundException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// }
//
// }
