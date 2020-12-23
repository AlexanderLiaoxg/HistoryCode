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
		System.out.println("JVM默认字符集：" + Charset.defaultCharset());
		System.out.println("操作系统字符集：" + System.getProperty("file.encoding"));
		// 创建简体中文字符集
		Charset cn = Charset.forName("gb2312");

		Charset cn2 = Charset.forName("gb2312");

		// 获得字符集的编码和解码器
		CharsetEncoder cnEncoder = cn.newEncoder(); // 获得编码器
		CharsetDecoder cnDecoder = cn2.newDecoder();// 获得编码器
		// 创建字符串缓冲器对象，并加入字符
		CharBuffer cbuf = CharBuffer.allocate(10);
		cbuf.put("传统文化");
		cbuf.flip(); // 重置position = 0

		ByteBuffer bbuf = cnEncoder.encode(cbuf); // 把字符缓冲区字符编码成字节
		System.out.println(bbuf.capacity());

		for (int i = 0; i < bbuf.capacity(); i++) {
			System.out.println("This is: " + bbuf.get(i));
		}

		// 将字节序列解码成字符序列
		CharBuffer result = cnDecoder.decode(bbuf);
		System.out.println("解码结果：" + result);

	}
}
// }
