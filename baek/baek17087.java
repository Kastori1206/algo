package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 숨바꼭질 6
 * https://www.acmicpc.net/problem/17087
 */
public class baek17087 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		String[] arr = br.readLine().split(" ");
		int[] diff = new int[N];
		//수빈이와 동생들의 거리 차이
		for (int i = 0; i < N; i++) {
			diff[i] = Math.abs(S-Integer.parseInt(arr[i]));
		}
		int answer = diff[0]; 
		for(int i = 1;i<N;i++) {
			answer = gcd(answer, diff[i]);
		}
		System.out.println(answer);
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
}
