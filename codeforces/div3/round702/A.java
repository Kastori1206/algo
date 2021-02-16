package codeforces.div3.round702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://codeforces.com/contest/1490/problem/A
 * A. Dense Array
 */
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t =0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			
			for(int i =0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			for(int i =0;i<n-1;i++) {
				double min = Math.min(arr[i], arr[i+1]);
				double max = Math.max(arr[i], arr[i+1]);
//				System.out.println(max/min);
				if(max/min <=2) {
					continue;
				}else {
					if(arr[i] > arr[i+1]) {
						double temp = Math.ceil((double)arr[i]/2);
						while(temp>arr[i+1]) {
							answer++;
//							System.out.println(temp);
							temp = Math.ceil(temp/2);
						}
					}else if(arr[i] < arr[i+1]){
						double temp = Math.ceil((double)arr[i+1]/2);
						while(temp>arr[i]) {
							answer++;
//							System.out.println(temp);
							temp = Math.ceil(temp/2);
						}
					}
				}
			}
			
			System.out.println(answer);
		}
	}
}
