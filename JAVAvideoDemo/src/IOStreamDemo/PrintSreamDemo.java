package IOStreamDemo;

import java.io.IOException;
import java.io.PrintStream;

/** 难点在于重定向流 **/

public class PrintSreamDemo {
	public static void main(String[] args) throws IOException {
		String name[] = { "猪八戒", "孙悟空" };
		double[][] sorce = { { 22, 88, 92 }, { 19, 78, 86 } };
		PrintStream ps = new PrintStream(System.out);
		// System.setout(ps);//ps -> ceshi.txt;
		// 再次System.out时是输出到ceshi.txt中
		ps.println("姓名\t年龄\t英语\t数学\t平均成绩");
		for (int i = 0; i < name.length; i++) {
			ps.print(name[i] + "\t");
			for (int j = 0; j < sorce[i].length; j++) {
				ps.print(sorce[i][j]);
				ps.print("\t");
			}
			ps.print((sorce[i][1] + sorce[i][2]) / 2.00);
			ps.println();
		}
		PrintStream ps1 = new PrintStream("测试2.txt");
	}
}
