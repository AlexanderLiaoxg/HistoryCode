import java.sql.Date;
import java.text.ParseException;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

public class DataDemo {
	public static void main(String[] args) {
		// Date today = new Date(0);
		// System.out.println(today);
		// long current = System.currentTimeMillis(); // 当前时间
		// System.out.println(current);
		// Date date2 = new Date(current);
		// System.out.println(date2);
		Calendar cal = Calendar.getInstance();
		StringBuffer sb = new StringBuffer();
		sb.append(cal.get(Calendar.YEAR)).append("年");
		sb.append(cal.get(Calendar.MONTH)).append("月");
		sb.append(cal.get(Calendar.DAY_OF_MONTH)).append("日");
		sb.append(cal.get(Calendar.HOUR_OF_DAY)).append("时");
		sb.append(cal.get(Calendar.SATURDAY)).append("秒");
		System.out.println(sb);

		// 3.SimpleDteFormat.格式化日期时间，把字符转换成日期
		// ===3.1按照模式来格式化日期时间。如格式化成：2016年08月22日 10：22：08：17
		String patter = "yy年MM月dd日 HH：mm:ss:SS";// (1)实例化简单日期格式对象
		SimpleDateFormat sdf = new SimpleDateFormat(patter); // 将字符串patter定义为格式模型
		String str = sdf.format(new Date(0));
		System.out.println("日期格式化为：" + str);

		// ====================把日期字符串转换为日期类型
		String srcDate = "2017-08-15";
		String patter2 = "yy-MM-dd";// (1)定义需要转换的日期字符串模式
		SimpleDateFormat sdf2 = new SimpleDateFormat(patter); // ②实例化简单日期格式对象
		java.util.Date destDate = null;
		try {
			destDate = sdf2.parse(srcDate); // (3)利用sdf2把一个日期字符串解析成日期对象
			System.out.println(destDate);
			System.out.println("2017-08-15与1970-01-01相距：" + destDate.getTime() + "毫秒");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 把Date设置为日历时间
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(destDate);
		// System.out.println(cal2.getC);
	}
}
