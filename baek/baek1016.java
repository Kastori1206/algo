package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 제곱 ㄴㄴ수
 * https://www.acmicpc.net/problem/1016
 */
public class baek1016 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		boolean[] prime = new boolean[1000001];

		prime[0] = prime[1] = true;
		for (int i = 2; i <= 1000000; i++) {
			if (!prime[i]) {
				for (int j = 2; i * j <= 1000000; j++)
					prime[i * j] = true;
			}
		}
		
		boolean[] check = new boolean[(int) (max - min + 1)];
		for (long i = 2; i * i <= max; i++) {
			if (prime[(int) i]) {
				continue;
			}
			long start = min / (i*i);
			if(min%(i*i)!=0) {
				start++;
			}
			for (long j =start; j * (i*i) <= max; j++) {
				if (!check[(int) (j * (i*i) - min)]) {
					check[(int) (j * (i*i) - min)] = true;
				}
			}
		}
		int answer = 0;
		for (long i = min; i <= max; i++) {
			if (!check[(int) (i - min)]) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
