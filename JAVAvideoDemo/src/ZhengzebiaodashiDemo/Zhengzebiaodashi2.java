package ZhengzebiaodashiDemo;

import java.util.regex.Pattern;

public class Zhengzebiaodashi2 {
	public static void main(String[] args) {
		// ��ַ������κοհ׷��������ո��Ʊ���ͻ�ҳ��
		String pat = "\\s";// ��ַ������κοհ׷��������ո��Ʊ���ͻ�ҳ��
		String str = "Knowledge is power";// ��Ҫ��ֵ��ַ���
		Pattern pattern = Pattern.compile(pat);// ����������֤��
		String[] words = pattern.split(str); // ִ�в�ַ���
		System.out.println("���У�" + words.length + "������");
		for (String word : words) {
			System.out.println(word);
		}

	}
}
