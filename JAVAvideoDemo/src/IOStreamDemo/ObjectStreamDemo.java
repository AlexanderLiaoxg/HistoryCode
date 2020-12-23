package IOStreamDemo;
/**
 * 对象流：存储对象的流
 * 对象的序列化：指将一个JAVA对象写入IO流
 * 对象的反序列化：指将一个IO流回复成JAVA对象
 * 序列化的作用：序列化机制使得对象可以脱离程序的运行而独立存在
 * 要求：如果需要让某个对象可以支持序列化机制，必须让它的类是可序列化的(serializable)，为了让某个类是可序列化的，该类必须实现Serializable接口或者Externalizable接口。
 *  
 */

/*
 * 类对象要重写toString方法输出类才会是所有的信息
 */
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Person [名字=" + name + ", 年龄=" + age + "]";
	}

}

class Student2 implements Serializable {
	private String className;
	private Person per;

	public Student2(String className, Person per) {
		super();
		this.className = className;
		this.per = per;
	}

	public Student2() {
		super();
	}

	@Override
	public String toString() {
		return "Student [班级名=" + className + ", per=" + per + "]";
	}

	public String getClassName() {
		return className;
	}

	public Person getPer() {
		return per;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setPer(Person per) {
		this.per = per;
	}

}

public class ObjectStreamDemo {
	public static void main(String[] args) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\廖兴广\\Desktop\\测试.txt"));// ObjectOutputStream修饰文件输出流
		Person s = new Person("孙悟空", 22);
		Student2 swk = new Student2("国学一班", s);
		oos.writeObject(swk);
		/*
		 * 一个对象只能被序列化一次，序列化之后对对象的更新并不能波及序列化对象，
		 */
		swk.setClassName("粤语版");// 没有用
		swk.getPer().setName("某某");// 还是没有用，见上面
		Person z = new Person("猪八戒", 19);
		Student2 zbj = new Student2("国学二班", z);
		oos.writeObject(zbj);
		oos.close();
	}
}
