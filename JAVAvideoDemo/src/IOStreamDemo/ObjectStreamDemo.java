package IOStreamDemo;
/**
 * ���������洢�������
 * ��������л���ָ��һ��JAVA����д��IO��
 * ����ķ����л���ָ��һ��IO���ظ���JAVA����
 * ���л������ã����л�����ʹ�ö�����������������ж���������
 * Ҫ�������Ҫ��ĳ���������֧�����л����ƣ��������������ǿ����л���(serializable)��Ϊ����ĳ�����ǿ����л��ģ��������ʵ��Serializable�ӿڻ���Externalizable�ӿڡ�
 *  
 */

/*
 * �����Ҫ��дtoString���������Ż������е���Ϣ
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
		return "Person [����=" + name + ", ����=" + age + "]";
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
		return "Student [�༶��=" + className + ", per=" + per + "]";
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
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\���˹�\\Desktop\\����.txt"));// ObjectOutputStream�����ļ������
		Person s = new Person("�����", 22);
		Student2 swk = new Student2("��ѧһ��", s);
		oos.writeObject(swk);
		/*
		 * һ������ֻ�ܱ����л�һ�Σ����л�֮��Զ���ĸ��²����ܲ������л�����
		 */
		swk.setClassName("�����");// û����
		swk.getPer().setName("ĳĳ");// ����û���ã�������
		Person z = new Person("��˽�", 19);
		Student2 zbj = new Student2("��ѧ����", z);
		oos.writeObject(zbj);
		oos.close();
	}
}
