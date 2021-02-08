package codeforces.div2.round700;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * D1. Painting the Array I
 */
public class D {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int a = 0;
		int b = 0;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != a && arr[i] != b) {
				if (i + 1 < n && arr[i + 1] == b)
					b = arr[i];
				else
					a = arr[i];
				answer++;
			} else if (a != arr[i]) {
				a = arr[i];
				answer++;
			} else if (b != arr[i]) {
				b = arr[i];
				answer++;
			}
		}
		System.out.println(answer);

	}
}
