package ZhengzebiaodashiDemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//正则表达式就是对字符串操作的一种模式

/*
 * 正则表达式：字符串匹配，查找，替换
 * [abc]:abc中的任意一个字符
 * \d:表示数字
 * \D:表示非数字
 * \w:表示字母、数字、下划线
 * \W：表示非\w
 * \s:表示空白字符（空白、换行）
 * \S:表示非空白字符
 * \t：tab
 * ^：表示正则表达式的开始；&：表示正则表达式的结束
 * +：表示一个或多个
 * *：表示0次或多次
 * .：表示除了换行符之外的任意一个字符
 * ?：0-1个字符
 * */

public class Zhengzebiaodashi {
	public static void main(String[] args) {
		/** 验证用户密码，以字母开头，长度6-12之间，只能包含字符、数字和下划线 **/
		// 使用正则表达式有四个步骤： 1、定义规则

		String pat = "[a-zA-Z]\\w{6,12}"; // a[-zA-Z]表示大小写的英文字母,\\w表示第二个之后的字符是单词字符，即可以是字母，数字，下划线
		String str = "good8A";
		Pattern pattern = Pattern.compile(pat); // 2、产生正则规则
		Matcher match = pattern.matcher(str);// 3、产生验证器
		boolean flag = match.matches();// 4、执行验证器
		System.out.println(flag);
		System.out.println("OK?");

	}

}
