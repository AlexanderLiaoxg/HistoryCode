package NetWorkDemo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WeChatSevers {
	static JFrame frame = new JFrame("WeChat");
	static JTextArea textarea = new JTextArea("�����������Server\n");
	static JTextField input = new JTextField("");
	static String severname = "����������";
	static JPanel p = new JPanel();
	static JScrollPane jp = new JScrollPane(textarea);

	public static void main(String[] args) throws Exception {
		ui();
		ServerSocket server = new ServerSocket(9998);
		System.out.println("����������!");
		Socket client = server.accept();
		System.out.print("���ӳɹ���");

		/* ����ʵ��Writer���������������˼�����һֱ���У�Ȼ�󲻶϶�ȡ��Ϣ���ɣ��˴��������̣߳���������ȡ�� */
		Writer(client);
		while (true) {
			Reader(client);       
		}

	}

	public static void ui() {

		frame.setSize(300, 500);
		frame.setLayout(new BorderLayout());
		textarea.setEditable(false);
		p.setLayout(new GridLayout(1, 0));
		p.add(jp);
		frame.add(p, BorderLayout.CENTER);
		frame.add(input, BorderLayout.SOUTH);
		frame.setVisible(true);
		textarea.setLineWrap(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void Reader(Socket client) throws Exception {
		// ��ȡ��Ϣ
		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		String result = dis.readUTF();
		textarea.append(result);
	}

	public static void Writer(Socket client) throws Exception {
		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		input.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {
					try {
						dos.writeUTF(dateFormat.format(new Date()).toString() + "\n   " + severname + "�� " + input.getText() + "\n\n");
						textarea.append(dateFormat.format(new Date()).toString() + "\n   " + severname + "�� " + input.getText() + "\n\n");
						input.setText("");
						dos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
}
