package IOStreamDemo;

import java.io.File;
import java.io.FilenameFilter;

class FileAccept implements FilenameFilter {

	private String extendName;

	@Override
	public boolean accept(File arg0, String arg1) {
		return arg1.endsWith(this.extendName); // arg1.endsWiht()��չ����β���ַ�����a.endswith(b)�ж�a�ǲ������ַ���b��β
	}

	public void setExtendName(String name) {
		this.extendName = "." + name;
	}

}

public class FileNameFilterDemo {
	public static void main(String[] args) {
		File f = new File("C:\\Users\\���˹�\\Desktop\\��ɾ����");
		FileAccept fa = new FileAccept(); // �ļ����˶���
		fa.setExtendName("java");// ���ù��˵��ļ���չ��Ϊjava
		/** ������������ô�������õ� **/
		String[] fn = f.list(fa); // ���src·������չ��ΪJava�������ļ�
		for (String name : fn)
			System.out.println(name);
	}
}
