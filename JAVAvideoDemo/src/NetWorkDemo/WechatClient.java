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
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WechatClient extends JFrame {
	static JTextArea textarea = new JTextArea("�����������-Client_�����\n");
	static JTextField input = new JTextField("");
	static String clientname = "�����";
	static JPanel p = new JPanel();
	static JScrollPane jp = new JScrollPane(textarea);

	public static void main(String[] args) throws Exception {
		new WechatClient();
	}

	public WechatClient() throws Exception {
		super("WeChat");
		this.setSize(300, 500);
		this.setLayout(new BorderLayout());
		textarea.setEditable(false);
		p.setLayout(new GridLayout(1, 0));
		this.add(p, BorderLayout.CENTER);
		this.add(input, BorderLayout.SOUTH);
		p.add(jp);
		this.add(p);
		this.setVisible(true);
		textarea.setLineWrap(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Socket socket = new Socket("127.0.0.1", 9998); // ��127.0.0.1���ҵ���������ͨ��ָ���˿�

		/** ������Ϣ **/
		OutputStream os = socket.getOutputStream(); // ����socket�����������
		DataOutputStream dos = new DataOutputStream(os); // ����
		input.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {
					try {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

						/* ʹ��Ϣ��ʾ��������棨C�������ͳ�ȥ */
						textarea.append(dateFormat.format(new Date()).toString() + "\n   " + clientname + "�� "
								+ input.getText() + "\n\n");
						dos.writeUTF(dateFormat.format(new Date()).toString() + "\n   " + clientname + "�� "
								+ input.getText() + "\n\n");
						input.setText("");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		dos.flush();

		/** ��ȡ��Ϣ **/
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		while (true) {

			String result = dis.readUTF();
			textarea.append(result);
		}
	}
}
