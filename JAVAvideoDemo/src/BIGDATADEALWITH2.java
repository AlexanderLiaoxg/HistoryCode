import com.ibm.icu.math.BigDecimal;

public class BIGDATADEALWITH2 {
	public static void main(String[] args) {
		BigDecimal wind = new BigDecimal("0.00000000000000221");
		// �������״�ѧ���ӵı���
		BigDecimal jsu = new BigDecimal("4165165");
		BigDecimal result = wind.multiply(jsu);
		System.out.println("���״�ѧ����Ϊ��" + result);
		BigDecimal bigA = new BigDecimal("123213213213213.5616516565");
		BigDecimal bigB = new BigDecimal("123213213213213.5616516565");
		boolean flag = bigA.equals(bigB);
		System.out.println(bigA);
		System.out.println(bigB);
		System.out.println("bigA�Ƿ���bigB��ȣ�" + flag);
		BigDecimal big1 = new BigDecimal(1.23456);
		BigDecimal big2 = new BigDecimal(5.43214);
		BigDecimal division = big1.divide(big2);
		System.out.println(big1);
		System.out.println(big2);
		System.out.println(division);
	}

}
