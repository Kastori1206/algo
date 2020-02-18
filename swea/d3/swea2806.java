package swea.d3;

import java.util.Arrays;
import java.util.Scanner;

public class swea2806 {
	static int N;
	static int[] map;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			cnt = 0;
			N = sc.nextInt();		
			map = new int[N];
			Arrays.fill(map, -1);//초기화
			dfs(0);
			System.out.println(String.format("#%d %d", t,cnt));
		}
	}
	static void dfs(int line) {
		//정답인경우
		if(line == N) {
			cnt++;
			return;
		}
		for(int i =0;i<N;i++) {
			if(isPromising(line,i)) {
				map[line]=i;
				dfs(line+1);
				map[line]=-1;
			}
		}
	}
	static boolean isPromising(int y, int x) {
		for(int i=y-1 ; i>=0;i--) {
			//위, 왼쪽대각선, 오른쪽대각선 검사
			if(map[i] ==x || map[i]== x -(y-i) || map[i]==x+(y-i)) {
				return false;
			}
		}
		return true;
	}
}
