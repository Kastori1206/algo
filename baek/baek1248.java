package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 맞춰봐
 * https://www.acmicpc.net/problem/1248
 */

public class baek1248 {
	static int N;
	static char[][] map;
	static int[] answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String temp = br.readLine();
		
		map = new char[N][N];
		answer = new int[N];
		int idx = 0;
		for(int r =0;r<N;r++) {
			for(int c =r;c<N;c++) {
				map[r][c] = temp.charAt(idx++);
			}
		}
		
		go(0);
	}
	public static void go(int idx) {
		if(idx==N) {
			for(int i=0;i<N;i++) {
				System.out.print(answer[i] + " ");
			}
			System.exit(0);
			return;
		}
		
		for(int i=-10;i<=10;i++) {
			answer[idx] = i;
			
			if(check(idx)) {
				go(idx+1);
			}
			
		}
	}
	public static boolean check(int idx) {
		int sum = 0;
		for(int i=idx;i>=0;i--) {
			sum+= answer[i];
			
			if(map[i][idx] == '+' && sum <=0) {
				return false;
			}
			if(map[i][idx] == '0' && sum!=0) {
				return false;
			}
			if(map[i][idx] == '-' && sum >=0) {
				return false;
			}
		}
		return true;
	}
}
