package ZhengzebiaodashiDemo;

public class Zhengzebiaodashi3 {
	public static void main(String[] args) {
		String srcStr = "123knowledge231is6854685power";// Դ�ַ���
		// String srcStr = "1978��12��19��";
		String pat = "\\d+";// ������ʽ һ�����߶������
		// String pat ="\\D+";//һ�����߶��������
		String newStr = srcStr.replaceAll(pat, "##"); // replaceAll���ڹ�����ʽ���滻
		// String newStr = srcStr.replace(pat, "-");
		System.out.println(newStr);
	}
}
