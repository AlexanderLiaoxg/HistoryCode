package ZhengzebiaodashiDemo;

public class Zhengzebiaodashi3 {
	public static void main(String[] args) {
		String srcStr = "123knowledge231is6854685power";// 源字符串
		// String srcStr = "1978年12月19日";
		String pat = "\\d+";// 正则表达式 一个或者多个数字
		// String pat ="\\D+";//一个或者多个非数字
		String newStr = srcStr.replaceAll(pat, "##"); // replaceAll用于规则表达式的替换
		// String newStr = srcStr.replace(pat, "-");
		System.out.println(newStr);
	}
}
