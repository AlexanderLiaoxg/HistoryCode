import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TestDateTime {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println("������" + today);

		LocalTime current = LocalTime.now();
		System.out.println("��ǰʱ��" + current);

		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("��ǰʱ�䣺" + ldt);

		// 2.ȡ��ʱ��ķ����������գ����ڼ�
		int year = ldt.getYear();
		int month = ldt.getMonthValue();
		int day = ldt.getDayOfMonth();
		DayOfWeek dw = ldt.getDayOfWeek();// ��õ�ǰ������һ���ڵ����죿
		System.out.println(dw);
		System.out.println(year + "��" + month + "��" + day + "��");

		// 3.����һ���µ�����ʱ�����
		LocalDate birthday = LocalDate.of(1987, 8, 19); // of ��������һ���µ����ڶ���
		LocalTime newTime = LocalTime.of(23, 23, 45);
		LocalDate newdate = LocalDate.parse(1987, 8, 19);// parse������һ�������ַ�������Ϊ����
		System.out.println(birthday);
		System.out.println(newTime);
		System.out.println(newdate);
		// 4.������ʱ����и�ʽ������
		// 4.1���ñ���Ĭ�Ϸ�ʽ��ʽ�����ڣ�ʱ��
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		// 4.2����ģʽ�ַ���ʽ����ʱ��
		String pattern = "MM-dd-yyyy";
		System.out.println(birthday.format(DateTimeFormatter.ofPattern(pattern)));
		// 5.������ʱ��Ĳ������ж������Ƿ���ȣ�
		LocalDate toBirthday = LocalDate.of(1978, 8, 20);
		LocalDate jackBirthday = LOcalDate.of(19, 8, 20);
		System.out.println(tomBirthday.equals(jackBirthday));
	}
}
