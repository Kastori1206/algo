package baek;
/*
 * 브루트포스 - 재귀
 * https://www.acmicpc.net/problem/15661
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek15661 {
	static int N;
	static int[][] persons;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		persons = new int[N][N];
		visited = new boolean[N];
		answer = Integer.MAX_VALUE;
		
		for(int r = 0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0;c <N;c++) {
				persons[r][c] = Integer.parseInt(st.nextToken());
			}
		}		
		dfs(0,N/2);
		System.out.println(answer);
	}
	private static void dfs(int cur, int r) {
		if(r==0) {
			//능력치 계산 비교
			calc();
			return;
		}
		for(int i = cur; i<N;i++) {
			visited[i] = true;
			dfs(i+1, r-1);
			visited[i] = false;
		}
	}
	private static void calc() {		
		int teamStart=0, teamLink=0;	

		for(int i =0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				//i번째 사람과 j 번째 사람이 true라면 스타트팀 점수
				if(visited[i] && visited[j]) {
					teamStart += persons[i][j] + persons[j][i];
				}
				//i번째 사람과 j 번째 사람이 false라면 링크팀 점수
				else if(!visited[i] && !visited[j]) {
					teamLink += persons[i][j] + persons[j][i];
				}
			}
		}
		
		answer = Math.min(answer, Math.abs(teamStart-teamLink));
	}
}
