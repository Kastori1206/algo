package baek;

import java.util.Arrays;
import java.util.Scanner;

public class baek2667 {
	//상,하,좌,우
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		int[][] map = new int[N][N]; //1: 집있는경우 0: 없는경우
		//배열 초기화
		for(int i =0;i<N;i++) {
			String str = sc.next();				
			for(int j =0;j<N;j++) {
				map[i][j] = Integer.parseInt(str.split("")[j]); 
			}
		}
		
		int[][] v = new int[N][N];//방문 체크
		int[] result = new int[N*N+1]; //단지번호수저장 배열
		int cnt = 0;
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				if(v[i][j] != 0 || map[i][j] ==0) {
					continue;
				}
				dfs(map,v,result,j,i,N,++cnt);
			}
		}
		
		System.out.println(cnt);
		Arrays.sort(result);//오름차순 정렬
		for(int i =N*N+1-cnt;i<N*N+1;i++) { //뒤에서 cnt번째 만큼 뺀곳부터 끝까지 출력
			System.out.println(result[i]);
		}
		
	}
	static void dfs(int[][] map, int[][]v,int[] result, int x, int y, int N, int cnt) {
		v[y][x] = cnt;
		result[cnt]++;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i]; int ny = y+dy[i];		
			if(nx >= N || nx<0 || ny>= N|| ny<0) {
				continue;
			}
			if(map[ny][nx] == 0) {
				continue;
			}
			if(v[ny][nx] != 0) {
				continue;
			}
			dfs(map,v,result,nx,ny,N,cnt);
		}
	}

}
