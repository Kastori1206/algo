package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 숨바꼭질5
 * https://www.acmicpc.net/problem/17071
 */
public class baek17071 {
	static int N,K;
	static int[][] visited;
	static final int max = 500_000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new int[2][max+1];
		for(int i = 0; i<2;i++) {
			Arrays.fill(visited[i], -1);
		}
		visited[0][N] = 0;
		System.out.println( N==K ? 0: bfs());
	}
	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		
		int len, mod, time = 0;
		
		while(!q.isEmpty()) {
			len = q.size();
			time++;
			mod = time%2; //2초마다 중복 방문
			
			while(len >0) {
				int n = q.poll();
				if(n-1>=0) {
					if(visited[mod][n-1] == -1) {
						q.add(n-1);
						visited[mod][n-1] = time;
					}
				}
				if(n+1<=max) {
					if(visited[mod][n+1] == -1) {
						q.add(n+1);
						visited[mod][n+1] = time;
					}
				}
				if(n*2<=max) {
					if(visited[mod][n*2] == -1) {
						q.add(n*2);
						visited[mod][n*2] = time;
					}
				}
				len--;
			}
			K+=time;
			//동생의 위치가 500000보다 큰 경우
			if(K>max) {
				break;
			}
			//동생 찾았을 경우
			if(visited[mod][K] != -1) {
				return time;
			}
			
		}
		return -1;
	}
}
