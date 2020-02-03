package baek;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x;
	int y;
	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
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
		ArrayList<Integer> a = new ArrayList<>();
		int cnt = 0;
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				if(v[i][j] != 0 || map[i][j] ==0) {
					continue;
				}
				//dfs(map,v,result,j,i,N,++cnt);
				bfs(map,v,a,j,i,N,++cnt);
			}
		}
//		
//		for(int i =0;i<N;i++) {
//			for(int j =0;j<N;j++) {
//				System.out.print(v[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(cnt);
		Arrays.sort(result);//오름차순 정렬
		Collections.sort(a);
//		for(int i =N*N+1-cnt;i<N*N+1;i++) { //뒤에서 cnt번째 만큼 뺀곳부터 끝까지 출력
//			System.out.println(result[i]);
//		}
//	
	
		for(int i=0;i<cnt;i++) {
			System.out.println(a.get(i));
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
	static void bfs(int[][] map, int[][] v,ArrayList<Integer> a,int x, int y, int N, int cnt ) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x,y));
		int c =1;
		Pair temp=null;
		while(!q.isEmpty()) {
			temp = q.poll();
			v[temp.y][temp.x] = cnt;
			c++;			
			
			for(int i =0;i<4;i++) {
				int nx = temp.x + dx[i]; int ny =temp.y + dy[i];
				if(isBound(nx,ny,N)) {
					continue;
				}
				if(map[ny][nx] ==0) {
					continue;
				}
				if(v[ny][nx] !=0) {
					continue;
				}
				q.offer(new Pair(nx,ny));				
			}
		}
		a.add(c);
	}
	static boolean isBound(int x, int y, int N) {
		if(x>=N||x<0||y>=N||y<0) {
			return true;
		}
		return false;
	}

}
