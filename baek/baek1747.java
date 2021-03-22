package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 소수&팰린드롬
 * https://www.acmicpc.net/problem/1747
 */
public class baek1747 {
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		//N을 기준으로 소수이면서 팰린드롬 수 1003001
		int max = 1_003_001;
		boolean[] check = new boolean[max+1];
		
		//에라토스테네스의 소수 구하기
		int len = (int)Math.sqrt(max);
		check[0] = check[1] = true;
		for(int i =2;i<=len;i++) {
			if(check[i]) {
				continue;
			}
			for(int j=i+i;j<=max;j+=i) {
				check[j] = true;
			}						
		}
	
		for(int i =N;i<=max;i++) {
			if(!check[i]&& isOk(i)) {
				System.out.println(i);
				break;
			}
		}
	}
	private static boolean isOk(int n) {
		StringBuilder num = new StringBuilder();
		num.append(n);
		return num.toString().equals(num.reverse().toString());
	}
}
