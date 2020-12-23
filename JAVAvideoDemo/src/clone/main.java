package clone;

public class main {
	public static void main(String[] args) {
	// TODO Auto-generated constructor stub
	Student s1 = new Student("lisi", 1);
	Student s2 = s1;
	System.out.println("Before:");
	System.out.println("s1" + s1.toString());
	System.out.println("s2" + s1.toString());
	
	System.out.println("After:");
	System.out.println("s1" + s1.toString());
	System.out.println("s2" + s1.toString());
}
}
