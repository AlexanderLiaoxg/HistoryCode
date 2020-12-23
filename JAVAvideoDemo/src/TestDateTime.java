import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TestDateTime {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println("今天是" + today);

		LocalTime current = LocalTime.now();
		System.out.println("当前时刻" + current);

		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("当前时间：" + ldt);

		// 2.取得时间的分量，年月日，星期几
		int year = ldt.getYear();
		int month = ldt.getMonthValue();
		int day = ldt.getDayOfMonth();
		DayOfWeek dw = ldt.getDayOfWeek();// 获得当前日期是一星期的哪天？
		System.out.println(dw);
		System.out.println(year + "年" + month + "月" + day + "日");

		// 3.构造一个新的日期时间对象
		LocalDate birthday = LocalDate.of(1987, 8, 19); // of 方法定义一个新的日期对象
		LocalTime newTime = LocalTime.of(23, 23, 45);
		LocalDate newdate = LocalDate.parse(1987, 8, 19);// parse方法把一个日期字符串解析为日期
		System.out.println(birthday);
		System.out.println(newTime);
		System.out.println(newdate);
		// 4.对日期时间进行格式化处理
		// 4.1采用本地默认方式格式化日期，时刻
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		// 4.2采用模式字符格式日期时间
		String pattern = "MM-dd-yyyy";
		System.out.println(birthday.format(DateTimeFormatter.ofPattern(pattern)));
		// 5.对日期时间的操作：判断日期是否相等，
		LocalDate toBirthday = LocalDate.of(1978, 8, 20);
		LocalDate jackBirthday = LOcalDate.of(19, 8, 20);
		System.out.println(tomBirthday.equals(jackBirthday));
	}
}
