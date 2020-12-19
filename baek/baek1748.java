package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 수이어쓰기
 * https://www.acmicpc.net/problem/1748
 */
public class baek1748 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		int num  = Integer.parseInt(N);
		int len = N.length();
		
		//((N - 10^len-1) +1)*len 
		int ans = (num - ((int)Math.pow(10, len))+1)*len;
		
		while(true) {
			if(len<=0) {
				break;
			}
			//(9*10^len-1)* len 자리수마다 9*10^len-1개를 가지고있음
			ans += 9*((int)Math.pow(10, len-1))*len;
			len--;
		}
		System.out.println(ans);
	}
}
