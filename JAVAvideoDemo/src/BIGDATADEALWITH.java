import java.math.BigInteger;

public class BIGDATADEALWITH {
	public static void main(String[] args) {
		// 1.大证书乘法
		BigInteger bigX = new BigInteger("123456789");
		BigInteger bigY = new BigInteger("1000000000000000000012345");
		BigInteger bigZ = bigX.multiply(bigY);
		System.out.println("大整数乘法:" + bigZ);
		// 2. 计算机64格子有多少大米
		BigInteger bigResult = new BigInteger("2");
		bigResult = bigResult.pow(64);
		System.out.println("64格子大米数量:\t" + bigResult);
		System.out.println("长整型最大值:\t" + bigResult);
		// 3.求最大公约数
		BigInteger bigA = new BigInteger("2317984644684865616");
		BigInteger gcd = bigA.gcd(BigInteger.valueOf(98234));
		System.out.println("最大公约数：" + gcd);
	}
}
