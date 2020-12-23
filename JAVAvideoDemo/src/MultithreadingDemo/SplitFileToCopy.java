package MultithreadingDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**����bug������Ϊ���ᱻ�����������һ�����Ʋ�����**/
/** ���ڸ��ƺ��������� **/

public class SplitFileToCopy {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println("��ʼ��ʱ��start" + start);
		String str = null;
		/* ��ʼ��ʱ */

		File Filename = new File("C:\\Users\\���˹�\\Desktop\\��.pdf");
		File toFilename = new File("C:\\Users\\���˹�\\Desktop\\����2.pdf");
		long Filelength = Filename.length();
		MyRunnabel my = new MyRunnabel();
		my.setFilename(Filename);
		my.setToFilename(toFilename);
		my.setFilelength(Filelength);
		Thread th1 = new Thread(my, "1");
		Thread th2 = new Thread(my, "2");
		Thread th3 = new Thread(my, "3");
		Thread th4 = new Thread(my, "4");
		Thread th5 = new Thread(my, "5");
		Thread th6 = new Thread(my, "6");
		Thread th7 = new Thread(my, "7");
		Thread th8 = new Thread(my, "8");
		Thread th9 = new Thread(my, "9");
		Thread th10 = new Thread(my, "10");
		/** ׼������ **/
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		th6.start();
		th7.start();
		th8.start();
		th9.start();
		th10.start();

		/* ��ʱ���� */
		long over = System.currentTimeMillis();
		System.out.println("����ʱ��" + (over - start) / 1000);

	}
}

class MyRunnabel implements Runnable {
	private File Filename;

	public void setFilename(File filename) {
		Filename = filename;
	}

	public void setToFilename(File toFilename) {
		this.toFilename = toFilename;
	}

	public void setFilelength(long filelength) {
		Filelength = filelength;
	}

	private File toFilename;
	long Filelength;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/** �����̵߳�����ת��Ϊ�����������д���ǲ��� **/
		long average = Filelength / 10;
		int id = Integer.valueOf(Thread.currentThread().getName()); // �����ǹؼ������̵߳�����ת��Ϊ�����������д���ǲ���
		System.out.println(id + Filename.getName() + toFilename.getName());
		/** �и�Դ�ļ� **/
		try {
			RandomAccessFile rgfr = new RandomAccessFile(Filename, "r");
			RandomAccessFile rgfw = new RandomAccessFile(toFilename, "rw");
			System.out.println(average);
			byte ch[] = new byte[(int) average];
			try {
				rgfr.seek((id - 1) * average); // ���㸴���Ĳ���
				rgfr.read(ch);
				System.out.println(new String(ch));
				rgfw.seek((id - 1) * average);
				rgfw.write(ch);
				rgfw.close();
				rgfr.close();
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

// class AcessFlie{
// public void splitFile() throws IOException {
// File Filename = new File("C:\\Users\\���˹�\\Desktop\\����2.txt");
// long Filelength = Filename.length();
// RandomAccessFile rgf = new RandomAccessFile(Filename, "r");
// System.out.println(new String(rgf.readLine().getBytes("8859_1")));
// System.out.println(rgf.getFilePointer());
// rgf.seek(0);
// System.out.println(rgf.getFilePointer());
// System.out.println(new String(rgf.readLine().getBytes("8859_1")));
// }
// }