package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * 구간 합 구하기 5
 * https://www.acmicpc.net/problem/11660
 */
public class baek11660 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		
		for(int r= 1; r<=N;r++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for(int c = 1;c<=N;c++) {
				sum += Integer.parseInt(st.nextToken());
				map[r][c] = sum;
			}
		}
		
		StringBuilder answer = new StringBuilder();
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			if(x1==x2 && y1==y2) {
				answer.append(map[x1][y1] - map[x1][y1-1]).append("\n"); 
			}else {
				long temp = 0;
				for(int r = x1; r<=x2;r++) {
					temp += map[r][y2] - map[r][y1-1];
				}
				answer.append(temp).append("\n");
			}
		}
		System.out.println(answer.toString());
	}
}
