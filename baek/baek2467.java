package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 용액
 * https://www.acmicpc.net/problem/2467
 */
public class baek2467 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] arr = new long[n];
		for(int i =0;i<n;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		long min = Long.MAX_VALUE;
		long[] answer = new long[2];
		int left =0, right = n-1;
		
		while(left<right) {
			long sum =Math.abs(arr[left] + arr[right]);
			long ll = Math.abs(arr[left]);
			long rr = Math.abs(arr[right]);
			if(sum==0) {
				answer[0] = arr[left];
				answer[1] = arr[right];
				break;
			}else {
				if(sum<min) {
					min = sum;
					answer[0] = arr[left];
					answer[1] = arr[right];
				}
			
				if(ll<rr) {
					right--;
				}else if(ll>rr) {
					left++;
				}
			}
		}
		System.out.println(answer[0] + " "+ answer[1]);
	}
}
