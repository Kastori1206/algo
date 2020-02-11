package baek;

import java.util.Scanner;

public class baek8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N  =sc.nextInt();
		int sum = N;
		int answer =0;
		for(int i=2;i<=N/2;i++) {
			for(int j =i; j<=N;j++) {
				if(i*j <=N) {
					sum++;
				}
			}					
		}
		System.out.println(sum);
		
//		for(int i=1;i<=N;i++) {
//			int cnt = 0;
//			for(int j=1;j<=Math.sqrt(i);j++) {
//				if(i%j==0) cnt++;
//			}
//			answer +=cnt;
//		}
		System.out.println(answer);
	}
}
