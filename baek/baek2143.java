package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 두 배열의 합
 * https://www.acmicpc.net/problem/2143
 */
public class baek2143 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		long[] arr1 = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ;i<N;i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		long[] arr2 = new long[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ;i<M;i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Long, Long> hm1 = new HashMap<>();
		Map<Long, Long> hm2 = new HashMap<>();
		for(int i =0;i<N;i++) {
			long sum = 0;
			for(int j=i;j<N;j++) {
				sum+=arr1[j];
				if(!hm1.containsKey(sum)) {
					hm1.put(sum, (long) 1);
				}else {
					hm1.put(sum, hm1.get(sum)+1);
				}
			}
		}
		
		for(int i =0;i<M;i++) {
			long sum = 0;
			for(int j=i;j<M;j++) {
				sum+=arr2[j];
				if(!hm2.containsKey(sum)) {
					hm2.put(sum, (long) 1);
				}else {
					hm2.put(sum, hm2.get(sum)+1);
				}
			}
		}
		
		long ans = 0;
		
		for(Long key : hm1.keySet()) {
			long num = T-key;
			if(hm2.containsKey(num)) {
				ans += hm1.get(key) * hm2.get(num);
			}
		}
		
		System.out.println(ans);
	}
}
