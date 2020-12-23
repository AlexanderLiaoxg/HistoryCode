package IOStreamDemo;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.SortedMap;

public class NEWIOCharset {
	public static void main(String[] args) throws Exception {
		SortedMap<String, Charset> cs = Charset.availableCharsets();
		// for (String alias : cs.keySet()) {
		System.out.println("JVMĬ���ַ�����" + Charset.defaultCharset());
		System.out.println("����ϵͳ�ַ�����" + System.getProperty("file.encoding"));
		// �������������ַ���
		Charset cn = Charset.forName("gb2312");

		Charset cn2 = Charset.forName("gb2312");

		// ����ַ����ı���ͽ�����
		CharsetEncoder cnEncoder = cn.newEncoder(); // ��ñ�����
		CharsetDecoder cnDecoder = cn2.newDecoder();// ��ñ�����
		// �����ַ������������󣬲������ַ�
		CharBuffer cbuf = CharBuffer.allocate(10);
		cbuf.put("��ͳ�Ļ�");
		cbuf.flip(); // ����position = 0

		ByteBuffer bbuf = cnEncoder.encode(cbuf); // ���ַ��������ַ�������ֽ�
		System.out.println(bbuf.capacity());

		for (int i = 0; i < bbuf.capacity(); i++) {
			System.out.println("This is: " + bbuf.get(i));
		}

		// ���ֽ����н�����ַ�����
		CharBuffer result = cnDecoder.decode(bbuf);
		System.out.println("��������" + result);

	}
}
// }
