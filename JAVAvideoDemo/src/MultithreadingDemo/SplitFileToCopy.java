package MultithreadingDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**存在bug可能因为不会被三整除，最后一个复制不完整**/
/** 存在复制好慢。。。 **/

public class SplitFileToCopy {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println("开始计时：start" + start);
		String str = null;
		/* 开始计时 */

		File Filename = new File("C:\\Users\\廖兴广\\Desktop\\啊.pdf");
		File toFilename = new File("C:\\Users\\廖兴广\\Desktop\\测试2.pdf");
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
		/** 准备工作 **/
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

		/* 计时结束 */
		long over = System.currentTimeMillis();
		System.out.println("共耗时：" + (over - start) / 1000);

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
		/** 利用线程的名字转换为数字来分配读写的那部分 **/
		long average = Filelength / 10;
		int id = Integer.valueOf(Thread.currentThread().getName()); // 这里是关键利用线程的名字转换为数字来分配读写的那部分
		System.out.println(id + Filename.getName() + toFilename.getName());
		/** 切割源文件 **/
		try {
			RandomAccessFile rgfr = new RandomAccessFile(Filename, "r");
			RandomAccessFile rgfw = new RandomAccessFile(toFilename, "rw");
			System.out.println(average);
			byte ch[] = new byte[(int) average];
			try {
				rgfr.seek((id - 1) * average); // 计算复制哪部分
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
// File Filename = new File("C:\\Users\\廖兴广\\Desktop\\测试2.txt");
// long Filelength = Filename.length();
// RandomAccessFile rgf = new RandomAccessFile(Filename, "r");
// System.out.println(new String(rgf.readLine().getBytes("8859_1")));
// System.out.println(rgf.getFilePointer());
// rgf.seek(0);
// System.out.println(rgf.getFilePointer());
// System.out.println(new String(rgf.readLine().getBytes("8859_1")));
// }
// }