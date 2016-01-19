package basic;

public class ThirdPow {
	
	public static long intCubeSumDiv(long n) {
		long m = 0;
		long curNum = 6;
		while (m < n) {
			if (isThirdPow(curNum)) {
				m++;
			}
			curNum++;
		}
		return curNum-1;
	}
	
	private static boolean isThirdPow (long n) {
		long powN = (n*n*n);
		long sumDivisors = 0;
		for (long i = n; i >= 1; i--) {
			if ((n % i) == 0) {
				sumDivisors += i;
			}
		}
		if (sumDivisors == 1) return false;
		return (powN % sumDivisors) == 0;
	}
}
