package IOStreamDemo;

import java.io.IOException;
import java.io.PrintStream;

/** �ѵ������ض����� **/

public class PrintSreamDemo {
	public static void main(String[] args) throws IOException {
		String name[] = { "��˽�", "�����" };
		double[][] sorce = { { 22, 88, 92 }, { 19, 78, 86 } };
		PrintStream ps = new PrintStream(System.out);
		// System.setout(ps);//ps -> ceshi.txt;
		// �ٴ�System.outʱ�������ceshi.txt��
		ps.println("����\t����\tӢ��\t��ѧ\tƽ���ɼ�");
		for (int i = 0; i < name.length; i++) {
			ps.print(name[i] + "\t");
			for (int j = 0; j < sorce[i].length; j++) {
				ps.print(sorce[i][j]);
				ps.print("\t");
			}
			ps.print((sorce[i][1] + sorce[i][2]) / 2.00);
			ps.println();
		}
		PrintStream ps1 = new PrintStream("����2.txt");
	}
}
