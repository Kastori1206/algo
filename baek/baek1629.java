package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 곱셈
 * https://www.acmicpc.net/problem/1629
 */
public class baek1629 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		System.out.println(pow(A,B,C));
		
	}
	public static long pow(long a, long b, long c) {
		if(b==0) {
			return 1;
		}
		long n = pow(a,b/2,c);
		long temp = n*n %c;
		
		if(b%2==0) {
			return temp;
		}else {
			return a*temp %c;
		}
	}
}
