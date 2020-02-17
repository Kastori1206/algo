package baek;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 	15663.N과 M(9)
 * https://www.acmicpc.net/problem/15663
 * 
 */
public class baek15663 {
	static int n;
	static int[] arr;
	static int[] num;
	static int[] cnt;
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();			
		
		arr = new int[N];
		num = new int[N];
		cnt = new int[N];
		result = new int[M];
		
		for(int i =0 ;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		num[0] = arr[0];
		cnt[0] = 1;
		int j=0;
		for(int i=1;i<N;i++) {
			if(arr[i]!=arr[i-1]) {
				j++;
				num[j] = arr[i];
				cnt[j]++;
			}else {
				cnt[j]++;
			}
			
		}
		go(0,M);
		
	}
	static void go(int index,int m) {
		if(index == m) {
			//출력			
			for(int i =0;i<result.length;i++) {
				System.out.print(result[i]);
				if(i!=m-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			return;
		}
		for(int i =0;i<arr.length;i++) {
			//중복제거
			if(cnt[i]>0) {
				cnt[i]--;
				result[index] = num[i];
				go(index+1,m);
				cnt[i]++;
			}			
		}
	}
}
