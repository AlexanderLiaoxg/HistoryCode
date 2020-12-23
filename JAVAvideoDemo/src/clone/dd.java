package clone;

public class dd {
public static void main(String[] args) throws CloneNotSupportedException {
	Student s1 = new Student("lisi", 1);
	teacher t = new teacher();t.setName("王晓晓");
	System.out.println(t.getName());
	s1.setT(t);
	Student s2 = (Student) s1.clone();
	System.out.println("Before:");
	System.out.println("s1" + s1.toString());
	System.out.println("s2" + s2.toString());
	teacher t2 = s2.getT();
	t2.setName("李明明");
	s2.setT(t2);
	s2.setStr("s2的信息改变");
	s2.setNo(6);
	System.out.println("After:");
	System.out.println("s1" + s1.toString());
	System.out.println("s2" + s2.toString());
}
}
