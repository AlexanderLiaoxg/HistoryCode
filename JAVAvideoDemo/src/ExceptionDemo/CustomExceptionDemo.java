package ExceptionDemo;

import javax.swing.JOptionPane;

class MyExcepyion extends RuntimeException{
	String s;
	public MyExcepyion(String s) {
		super();
		this.s = s;System.out.println(s);
	}
	public MyExcepyion() {
		throw new RuntimeException("你触犯了我的规则！");  //红体字，RuntimeException
	}
}

public class CustomExceptionDemo {
     public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("请输入：");
		try {
		if(input.equals("I obey u")) {
			System.out.println("乖");
		}else {
			throw new MyExcepyion();
		}
		}catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println("不可赦免！斩立决！");
			throw e;                                     //抛出异常对象
		}
	}
}
