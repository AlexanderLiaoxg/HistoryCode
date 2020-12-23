package ZhengzebiaodashiDemo;

import java.util.regex.Pattern;

public class Zhengzebiaodashi2 {
	public static void main(String[] args) {
		// 拆分符号是任何空白符，包括空格，制表符和换页符
		String pat = "\\s";// 拆分符号是任何空白符，包括空格，制表符和换页符
		String str = "Knowledge is power";// 需要拆分的字符串
		Pattern pattern = Pattern.compile(pat);// 产生正则验证器
		String[] words = pattern.split(str); // 执行拆分方法
		System.out.println("共有：" + words.length + "个单词");
		for (String word : words) {
			System.out.println(word);
		}

	}
}
