package ZhengzebiaodashiDemo;

public class Zhengzebiaodashi4 {
	public static void main(String[] args) {
		String srcStr = "һ���߰���ʮ����ʮ����";
		String pat = "��|��|��";// �����ꡢ�¡�������
		String[] nums = srcStr.split(pat);
		for (String str : nums) {
			System.out.println(str);
		}
	}
}
