package IOStreamDemo;

import java.io.File;
import java.io.FilenameFilter;

class FileAccept implements FilenameFilter {

	private String extendName;

	@Override
	public boolean accept(File arg0, String arg1) {
		return arg1.endsWith(this.extendName); // arg1.endsWiht()拓展名结尾的字符串，a.endswith(b)判断a是不是以字符串b结尾
	}

	public void setExtendName(String name) {
		this.extendName = "." + name;
	}

}

public class FileNameFilterDemo {
	public static void main(String[] args) {
		File f = new File("C:\\Users\\廖兴广\\Desktop\\待删除的");
		FileAccept fa = new FileAccept(); // 文件过滤对象
		fa.setExtendName("java");// 设置过滤的文件拓展名为java
		/** 好神奇这样怎么产生作用的 **/
		String[] fn = f.list(fa); // 获得src路径下拓展名为Java的所以文件
		for (String name : fn)
			System.out.println(name);
	}
}
