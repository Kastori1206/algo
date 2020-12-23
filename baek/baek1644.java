package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 소수의 연속합
 * https://www.acmicpc.net/problem/1644
 */

public class baek1644 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		boolean[] prime = new boolean[N+1];
		prime[0] = prime[1] = true;
		List<Integer> list = new ArrayList<>();
		
		//소수구하기
		for(int i =2;i<=Math.sqrt(N); i++) {
			if(!prime[i]) {
				for(int j=i*i; j<=N; j+=i) {
					prime[j] = true;
				}				
			}
		}
		
		//구한 소수 리스트화
		for(int i =0;i<=N;i++) {
			if(!prime[i]) {
				list.add(i);		
			}
		}
		
		//연속합 구하기
		int len = list.size();
		int left =0, right =0, sum =0;
		while(left <= right && right <=len) {
			if(right< len && sum<N) {
				sum+= list.get(right++);
			}else if(sum == N) {
				ans++;
				sum-= list.get(left++);
			}else if(left <len && sum>N){
				sum-= list.get(left++);
			}else {
				break;
			}
		}
		
		System.out.println(ans);
	}
}
