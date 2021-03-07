package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 가장 긴 증가하는 부분 수열 3
 * https://www.acmicpc.net/problem/12738
 */
public class baek12738 {
	static int N;
	static int[] arr, lis;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		lis = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		lis[0] = arr[0];
		int idx = 0;
		int answer = 0;
		for(int i =1 ;i<N;i++) {
			if(lis[idx] < arr[i]) {
				lis[++idx] = arr[i];
				answer++;
			}else {
				int ii = lower_bound(idx, arr[i]);
				lis[ii] = arr[i];
			}
		}
		System.out.println(answer+1);
	}
	private static int lower_bound(int end, int target) {
		int start = 0;
		while(start <end) {
			int mid = (start+end)/2;
			if(lis[mid] >= target) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		return end;
	}
}
