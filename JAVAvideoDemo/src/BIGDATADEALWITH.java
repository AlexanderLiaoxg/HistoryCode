import java.math.BigInteger;

public class BIGDATADEALWITH {
	public static void main(String[] args) {
		// 1.��֤��˷�
		BigInteger bigX = new BigInteger("123456789");
		BigInteger bigY = new BigInteger("1000000000000000000012345");
		BigInteger bigZ = bigX.multiply(bigY);
		System.out.println("�������˷�:" + bigZ);
		// 2. �����64�����ж��ٴ���
		BigInteger bigResult = new BigInteger("2");
		bigResult = bigResult.pow(64);
		System.out.println("64���Ӵ�������:\t" + bigResult);
		System.out.println("���������ֵ:\t" + bigResult);
		// 3.�����Լ��
		BigInteger bigA = new BigInteger("2317984644684865616");
		BigInteger gcd = bigA.gcd(BigInteger.valueOf(98234));
		System.out.println("���Լ����" + gcd);
	}
}
