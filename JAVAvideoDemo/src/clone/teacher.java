package clone;

public class teacher implements Cloneable{
private String name;


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public Object clone() throws CloneNotSupportedException{
         return super.clone();
    }
}
