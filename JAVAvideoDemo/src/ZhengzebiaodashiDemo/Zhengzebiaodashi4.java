package ZhengzebiaodashiDemo;

public class Zhengzebiaodashi4 {
	public static void main(String[] args) {
		String srcStr = "一九七八年十二月十九日";
		String pat = "年|月|日";// 按照年、月、日区分
		String[] nums = srcStr.split(pat);
		for (String str : nums) {
			System.out.println(str);
		}
	}
}
