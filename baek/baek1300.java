package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * K번째 수
 * https://www.acmicpc.net/problem/1300
 */
public class baek1300 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int left = 1, right = K;
		int answer = -1;
		while(left <= right) {
			int cnt = 0;
			int mid = (left + right)/2;
			for(int i = 1;i<=N;i++) {
				cnt += Math.min(mid/i, N);
			}
			if(cnt <K) {
				left = mid +1;
			}else {
				answer = mid;
				right = mid -1;
			}
		}
		System.out.println(answer);
	}
	
}
