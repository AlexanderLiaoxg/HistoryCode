package ZhengzebiaodashiDemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//������ʽ���Ƕ��ַ���������һ��ģʽ

/*
 * ������ʽ���ַ���ƥ�䣬���ң��滻
 * [abc]:abc�е�����һ���ַ�
 * \d:��ʾ����
 * \D:��ʾ������
 * \w:��ʾ��ĸ�����֡��»���
 * \W����ʾ��\w
 * \s:��ʾ�հ��ַ����հס����У�
 * \S:��ʾ�ǿհ��ַ�
 * \t��tab
 * ^����ʾ������ʽ�Ŀ�ʼ��&����ʾ������ʽ�Ľ���
 * +����ʾһ������
 * *����ʾ0�λ���
 * .����ʾ���˻��з�֮�������һ���ַ�
 * ?��0-1���ַ�
 * */

public class Zhengzebiaodashi {
	public static void main(String[] args) {
		/** ��֤�û����룬����ĸ��ͷ������6-12֮�䣬ֻ�ܰ����ַ������ֺ��»��� **/
		// ʹ��������ʽ���ĸ����裺 1���������

		String pat = "[a-zA-Z]\\w{6,12}"; // a[-zA-Z]��ʾ��Сд��Ӣ����ĸ,\\w��ʾ�ڶ���֮����ַ��ǵ����ַ�������������ĸ�����֣��»���
		String str = "good8A";
		Pattern pattern = Pattern.compile(pat); // 2�������������
		Matcher match = pattern.matcher(str);// 3��������֤��
		boolean flag = match.matches();// 4��ִ����֤��
		System.out.println(flag);
		System.out.println("OK?");

	}

}
