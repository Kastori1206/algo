package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 수 정렬하기 3
 * https://www.acmicpc.net/problem/10989
 */
public class baek10989 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int index = Integer.parseInt(br.readLine());
			arr[index]++;
		}

		for (int i = 1; i <= 10000; i++) {
			if (arr[i] == 0) {
				continue;
			}
			while (arr[i] > 0) {
				sb.append(i + "\n");
				arr[i]--;
			}
		}

		System.out.println(sb.toString());
	}
}
