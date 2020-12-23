import com.ibm.icu.math.BigDecimal;

public class BIGDATADEALWITH2 {
	public static void main(String[] args) {
		BigDecimal wind = new BigDecimal("0.00000000000000221");
		// 传动吉首大学增加的倍数
		BigDecimal jsu = new BigDecimal("4165165");
		BigDecimal result = wind.multiply(jsu);
		System.out.println("吉首大学风力为：" + result);
		BigDecimal bigA = new BigDecimal("123213213213213.5616516565");
		BigDecimal bigB = new BigDecimal("123213213213213.5616516565");
		boolean flag = bigA.equals(bigB);
		System.out.println(bigA);
		System.out.println(bigB);
		System.out.println("bigA是否与bigB相等：" + flag);
		BigDecimal big1 = new BigDecimal(1.23456);
		BigDecimal big2 = new BigDecimal(5.43214);
		BigDecimal division = big1.divide(big2);
		System.out.println(big1);
		System.out.println(big2);
		System.out.println(division);
	}

}
