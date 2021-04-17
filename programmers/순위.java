package programmers;

import java.util.*;

/*
 * 순위
 * https://programmers.co.kr/learn/courses/30/lessons/49191
 */
public class 순위 {
	public static void main(String[] args) {
		int n =5;
		int[][] results = new int[][]{
				{4,3},
				{4,2},
				{3,2},
				{1,2},
				{2,5}
		};
		System.out.println(solution(n,results));
	}

	public static int solution(int n, int[][] results) {
		final int INF = (int) 1e9; //무한을 의미하는 값 10억

		int answer = 0;

		int[][] graph = new int[n+1][n+1];

		for(int i =0;i<=results.length; i++){
			Arrays.fill(graph[i],INF);
		}

		for(int i =0;i<results.length;i++){
			int win = results[i][0];
			int lose = results[i][1];
			graph[win][lose] = 1;
			graph[lose][win] = -1;
		}

		for(int k = 1; k<=n;k++){
			for(int a = 1; a<=n; a++){
				for(int b = 1; b<=n;b++){
					if(graph[a][b] == INF){
						if(graph[a][k] == 1 && graph[k][b] == 1){
							graph[a][b] = 1;
						}
						if(graph[a][k] == -1 && graph[k][b] == -1){
							graph[a][b] = -1;
						}
					}
				}
			}
		}

		for(int i = 1;i<=n;i++){
			boolean flag = false;
			for(int j = 1; j<=n;j++){
				if (i!= j && graph[i][j] == INF){
					flag = true;
					break;
				}
			}
			if(!flag){
				answer++;
			}
		}
		return answer;
	}
}
