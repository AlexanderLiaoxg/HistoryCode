package IOStreamDemo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInStreamDemo {
	public static void main(String[] args) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\���˹�\\Desktop\\����.txt"));
		Object one = ois.readObject();
		System.out.println(one);
		Student2 two = (Student2) ois.readObject();// ����ת��ΪStudent
		System.out.println(two);
	}
}
