package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 가장 긴 증가하는 팰린드롬 부분수열
 * https://www.acmicpc.net/problem/16161
 */
public class baek16161 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;
		int answer = 1;

		while (left <= right && right < N - 1) {
			if (arr[right] < arr[right + 1]) {
				right++;
			} else if (arr[right] == arr[right + 1]) {
				int i = 0;
				for (i = 0; i <= right - left; i++) {
					if (right + 1 + i >= N || arr[right - i] != arr[right + 1 + i]) {
						break;
					}
				}
				answer = Math.max(answer, i * 2);
				
				right++;
				left = right;
			} else {
				int i = 0;
				for (i = 0; i < right - left; i++) {
					if (right + 1 + i >= N || arr[right - 1 - i] != arr[right + 1 + i]) {
						break;
					}
				}
				answer = Math.max(answer, i * 2 + 1);

				right++;
				left = right;
			}
		}
		System.out.println(answer);
	}
}
