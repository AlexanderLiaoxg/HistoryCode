package IOStreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferStreamDemo {
	public static boolean copyFile(String srcFile, String destFile) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		File src = new File(srcFile);
		File dest = new File(destFile);
		if (!dest.exists()) {
			try {
				dest.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos = new FileOutputStream(dest);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] buf = new byte[1024];
		int hasData = 0;
		try {
			while ((hasData = fis.read(buf)) > 0) {
				try {
					fos.write(buf, 0, hasData);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return true;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static void main(String[] args) {
		String src = "D:\\filedemo\\core.jpg";
		// String src = "D:\\filedemo\\core.jpg";
		// if(copyFile(src,dest)) {
		// System.out.println("复制成功");
		// }
		// esle{
		// System.out.println("复制失败");
		// }
	}
}
