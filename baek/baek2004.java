package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  조합 0의 개수
 *  https://www.acmicpc.net/problem/2004
 */
public class baek2004 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		long five = count(N, 5) - count(N - M, 5) - count(M, 5);
		long two = count(N, 2) - count(N - M, 2) - count(M, 2);

		System.out.println(Math.min(five, two));
	}

	public static long count(long num1, int num2) {
		long cnt = 0;
		while (num1 >= num2) {
			cnt += (num1 / num2);
			num1 /= num2;
		}
		return cnt;
	}
}
