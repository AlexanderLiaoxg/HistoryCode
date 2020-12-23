package IOStreamDemo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInStreamDemo {
	public static void main(String[] args) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\廖兴广\\Desktop\\测试.txt"));
		Object one = ois.readObject();
		System.out.println(one);
		Student2 two = (Student2) ois.readObject();// 向下转型为Student
		System.out.println(two);
	}
}
