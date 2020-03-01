package baek;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 18429. 근손실
 * https://www.acmicpc.net/problem/18429
 */
public class baek18429 {
	static int cnt;
	static int[] arr;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();		
		
		arr = new int[n];
		v = new boolean[n];
		cnt =0;
		for(int i =0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		go(0,n,k,500);
		System.out.println(cnt);
	}
	static void go(int index, int n , int k , int sum) {
		if(sum<500) {
			return;
		}
		if(index==n) {
			System.out.println(Arrays.toString(v));
			cnt++;
			return;
		}
		for(int i =0;i<n;i++) {
			if(v[i]) {
				continue;
			}
			v[i] = true;
			sum += arr[i];
			sum -= k;
			go(index+1,n,k,sum);
			v[i] =false;
			sum -=arr[i];
			sum += k;
		}
	}
}
