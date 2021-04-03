package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 팩토리얼 0의 개수
 * https://www.acmicpc.net/problem/1676
 */
public class baek1676 {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int two = 0;
		int five = 0;
		for(int i =1;i<=N;i++) {
			int num = i;
			while(num%5==0||num%2==0) {
				if(num%2==0) {
					two++;
					num /= 2;
				}
				if(num%5==0) {
					five++;
					num/=5;
				}
			}			
		}
		int answer = Math.min(five, two);
		System.out.println(answer);
	}
}
