package NetWorkDemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServersDemo {
   public static void main(String[] args) throws Exception {
	ServerSocket server = new ServerSocket(9998);
	System.out.println("服务器启动!");
	Socket client = server.accept();
	System.out.print("连接成功！");
	
	InputStream is = client.getInputStream();
	DataInputStream dis = new DataInputStream(is);
	String result = dis.readUTF();
	JOptionPane.showMessageDialog(null, result);

	
	OutputStream os = client.getOutputStream();
	DataOutputStream dos = new DataOutputStream(os); 
	dos.writeUTF("你好,我是服务器");
	dos.flush();
}
}
