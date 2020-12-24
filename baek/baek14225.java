package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 부분수열의 합
 * https://www.acmicpc.net/problem/14225
 */
public class baek14225 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		int ans = 0;
		for(int i =0;i<N;i++) {
			if(ans+1 < arr[i]) {
				break;
			}
			ans += arr[i];
		}
		
		System.out.println(ans+1);
	}
}
