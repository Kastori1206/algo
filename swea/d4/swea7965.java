package swea.d4;

import java.util.Scanner;

public class swea7965 {
	static long mod = 1000000007;	
	static long[] arr = new long[1000000+1];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t= 1; t<=T;t++) {
			int N = sc.nextInt();
			long result =0;
			
			for(int i =1;i<=N;i++) {
				if(arr[i]!=0) {
					result = arr[i];
				}else {
					result +=pow(i,i);
					result %= mod;					
					arr[i] = result;
				}
			}		
			System.out.println(String.format("#%d %d", t,result));
		}
		
		
	}
	static long pow(int base, int exp) {
		if(exp ==0 ) {
			return 1;
		}
		if(exp ==1) {
			return base;
		}
		long num=(pow(base,exp/2))%mod;
		
		if(exp%2==0) {
			return (num * num)%mod;
		}else {
			return (((num * num)%mod) * base)%mod;
		}		
	}
}
