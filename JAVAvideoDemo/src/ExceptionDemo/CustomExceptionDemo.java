package ExceptionDemo;

import javax.swing.JOptionPane;

class MyExcepyion extends RuntimeException{
	String s;
	public MyExcepyion(String s) {
		super();
		this.s = s;System.out.println(s);
	}
	public MyExcepyion() {
		throw new RuntimeException("�㴥�����ҵĹ���");  //�����֣�RuntimeException
	}
}

public class CustomExceptionDemo {
     public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("�����룺");
		try {
		if(input.equals("I obey u")) {
			System.out.println("��");
		}else {
			throw new MyExcepyion();
		}
		}catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println("�������⣡ն������");
			throw e;                                     //�׳��쳣����
		}
	}
}
