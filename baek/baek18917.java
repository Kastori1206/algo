package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 수열과 쿼리 38
 * https://www.acmicpc.net/problem/18917
 */
public class baek18917 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		long sum = 0;
		long xor = 0;
		StringBuilder answer = new StringBuilder();
		for(int i =0;i<M;i++) {
			String[] temp = br.readLine().split(" ");
			int num = Integer.parseInt(temp[0]);
			long x = 0;
			switch(num) {
			case 1:
				x = Long.parseLong(temp[1]);
				sum+=x;
				xor ^=x;
				break;
			case 2:
				x = Long.parseLong(temp[1]);
				sum-=x;
				xor ^=x;
				break;
			case 3:
				answer.append(sum).append("\n");
				break;
			case 4:
				answer.append(xor).append("\n");
				break;
			}

		}
		System.out.println(answer.toString());
	}
}
