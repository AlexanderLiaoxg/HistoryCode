package ClassTo;

import java.lang.reflect.Field;

public class ReplyDemo {
public static void main(String[] args) throws Exception {
	Class<?> a = null;
	a = Class.forName("ClassTo.DataDemo");
	Object obj = a.newInstance();//  ʵ������������
	Field idemo = a.getDeclaredField("i");
	Field iClassto = a.getDeclaredField("Classto");
	System.out.println("This is : " + idemo);
	System.out.println("This is : " + iClassto);
	System.out.println("This is : " + idemo.get(obj));
	System.out.println("This is : " + iClassto.get(obj));
	idemo.setAccessible(true);
	iClassto.setAccessible(true);
	idemo.set(obj, 6);
	iClassto.set(obj, "�޸��ˣ���");
	System.out.println("This is : " + idemo.get(obj));
	System.out.println("This is : " + iClassto.get(obj));
	DataDemo d = new DataDemo();
	d.setI(2);
	d.setClassto("New������иı�");
	System.out.println("New is : " + d.getI());
	System.out.println("New is : " + d.getClassto());
}
}
