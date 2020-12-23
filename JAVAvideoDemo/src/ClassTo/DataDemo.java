package ClassTo;

public class DataDemo {
	int i=8;
	String Classto = "我是反射的字符串显示";
	public void ShowString() {
		System.out.println(Classto);
	}
public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getClassto() {
		return Classto;
	}
	public void setClassto(String classto) {
		Classto = classto;
	}
	public DataDemo() {
	
	}

}
