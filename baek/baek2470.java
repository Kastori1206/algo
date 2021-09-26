package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 용액
 * https://www.acmicpc.net/problem/2470
 */
public class baek2470 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int min = Integer.MAX_VALUE;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] answer = new int[2];
		for(int i =0;i<N;i++) {
			int a = arr[i];
			for(int j= i+1;j<N;j++) {
				int b = arr[j];
				int sum = Math.abs(a+b);
				if(sum == 0) {
					System.out.println(a + " " + b);
					return;
				}
				if(min > sum) {
					min = sum;
					answer[0] = a;
					answer[1] = b;
				}				
			}
		}
		
		System.out.println(answer[0] + " " + answer[1]);
	}

}
