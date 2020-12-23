import java.sql.Date;
import java.text.ParseException;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

public class DataDemo {
	public static void main(String[] args) {
		// Date today = new Date(0);
		// System.out.println(today);
		// long current = System.currentTimeMillis(); // ��ǰʱ��
		// System.out.println(current);
		// Date date2 = new Date(current);
		// System.out.println(date2);
		Calendar cal = Calendar.getInstance();
		StringBuffer sb = new StringBuffer();
		sb.append(cal.get(Calendar.YEAR)).append("��");
		sb.append(cal.get(Calendar.MONTH)).append("��");
		sb.append(cal.get(Calendar.DAY_OF_MONTH)).append("��");
		sb.append(cal.get(Calendar.HOUR_OF_DAY)).append("ʱ");
		sb.append(cal.get(Calendar.SATURDAY)).append("��");
		System.out.println(sb);

		// 3.SimpleDteFormat.��ʽ������ʱ�䣬���ַ�ת��������
		// ===3.1����ģʽ����ʽ������ʱ�䡣���ʽ���ɣ�2016��08��22�� 10��22��08��17
		String patter = "yy��MM��dd�� HH��mm:ss:SS";// (1)ʵ���������ڸ�ʽ����
		SimpleDateFormat sdf = new SimpleDateFormat(patter); // ���ַ���patter����Ϊ��ʽģ��
		String str = sdf.format(new Date(0));
		System.out.println("���ڸ�ʽ��Ϊ��" + str);

		// ====================�������ַ���ת��Ϊ��������
		String srcDate = "2017-08-15";
		String patter2 = "yy-MM-dd";// (1)������Ҫת���������ַ���ģʽ
		SimpleDateFormat sdf2 = new SimpleDateFormat(patter); // ��ʵ���������ڸ�ʽ����
		java.util.Date destDate = null;
		try {
			destDate = sdf2.parse(srcDate); // (3)����sdf2��һ�������ַ������������ڶ���
			System.out.println(destDate);
			System.out.println("2017-08-15��1970-01-01��ࣺ" + destDate.getTime() + "����");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ��Date����Ϊ����ʱ��
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(destDate);
		// System.out.println(cal2.getC);
	}
}
