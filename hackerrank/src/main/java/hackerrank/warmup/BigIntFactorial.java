package hackerrank.warmup;

import java.math.BigInteger;

public class BigIntFactorial {

	static BigInteger fact(int N) {
		if(N==0 || N==1)
			return BigInteger.ONE;
		return BigInteger.valueOf(N).multiply(fact(N - 1));
	}
	
	
	public static void main(String[] args) {
		System.out.println(fact(5));
	}
}
