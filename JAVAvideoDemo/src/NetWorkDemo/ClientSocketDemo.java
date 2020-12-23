package NetWorkDemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientSocketDemo {
	JFrame frame;
	JTextArea textarea;
	JTextField input;
  public static void main(String[] args) throws Exception {
	Socket socket = new Socket("127.0.0.1",9999);
	
	OutputStream os = socket.getOutputStream();   //基于socket的输入输出流
	DataOutputStream dos = new DataOutputStream(os); //修饰
	dos.writeUTF("你好,我是Client");
	dos.flush();
	
	InputStream is = socket.getInputStream();
	DataInputStream dis = new DataInputStream(is);
	String result = dis.readUTF();
	JOptionPane.showMessageDialog(null, result);
	System.out.println(result);
}
}
