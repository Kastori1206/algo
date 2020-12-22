package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 나무 자르기
 * https://www.acmicpc.net/problem/2805
 * 이분탐색
 */
public class baek2805 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		long low =0 , high=0, mid =0;
		for(int i = 0 ; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			high = Math.max(arr[i], high);
		}
		
		long ans = Long.MIN_VALUE;
		while(low <= high) {
			mid = (low+high)/2;
			long res = calc(mid,N,arr);
			
			if(res<M) {
				high = mid -1;
			}else if(res>=M) {
				low = mid +1;			
				ans = Math.max(ans, mid);
			}
//			else {
//				ans = Math.max(ans, mid);
//				break;
//			}
		}
		
		System.out.println(ans == Long.MIN_VALUE ? 0:ans);
	}
	private static long calc(long mid, int n, long[] arr) {
		long res=0;
		for(int i =0;i<n;i++) {
			long h = arr[i] - mid;
			if(h>0) {
				res+=h;
			}
		}
				
		return res;
	}
}
