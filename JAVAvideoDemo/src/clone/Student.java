package clone;

public class Student implements Cloneable{
public String str = "≥¢ ‘…Ó∂»øÀ¬°";
public String name;
public int no;
private teacher t;

public teacher getT() {
	return t;
}

public void setT(teacher t) {
	this.t = t;
}

public Student(String name, int no) {
	super();
	this.name = name;
	this.no = no;
}

public String getStr() {
	return str;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getNo() {
	return no;
}

public void setNo(int no) {
	this.no = no;
}



@Override
public String toString() {
	return "Student [str=" + str + ", name=" + name + ", no=" + no + ", t=" + t.getName()
			+ "]";
}

public void setStr(String str) {
	this.str = str;
}
public Object clone() throws CloneNotSupportedException{
	Student s = (Student) super.clone();
	s.t = (teacher) t.clone();
         return s;
    }
}
