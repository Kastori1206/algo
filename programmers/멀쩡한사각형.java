package programmers;

public class 멀쩡한사각형 {
	public static void main(String[] args) {
		System.out.println(solution(8, 12));
	}

	public static long solution(int w, int h) {
		long answer = (long) w * (long) h - (w + h);
		long gcd = GCD(Math.max(w, h), Math.min(w, h));

		return answer + gcd;
	}

	public static long GCD(long a, long b) {
		while (b > 0) {
			long temp = a;
			a = b;
			b = temp % b;
		}
		return a;
	}
}
