package ClassTo;

import java.lang.reflect.Field;

public class ReplyDemo {
public static void main(String[] args) throws Exception {
	Class<?> a = null;
	a = Class.forName("ClassTo.DataDemo");
	Object obj = a.newInstance();//  实例化操作对象
	Field idemo = a.getDeclaredField("i");
	Field iClassto = a.getDeclaredField("Classto");
	System.out.println("This is : " + idemo);
	System.out.println("This is : " + iClassto);
	System.out.println("This is : " + idemo.get(obj));
	System.out.println("This is : " + iClassto.get(obj));
	idemo.setAccessible(true);
	iClassto.setAccessible(true);
	idemo.set(obj, 6);
	iClassto.set(obj, "修改了？？");
	System.out.println("This is : " + idemo.get(obj));
	System.out.println("This is : " + iClassto.get(obj));
	DataDemo d = new DataDemo();
	d.setI(2);
	d.setClassto("New对象进行改变");
	System.out.println("New is : " + d.getI());
	System.out.println("New is : " + d.getClassto());
}
}
