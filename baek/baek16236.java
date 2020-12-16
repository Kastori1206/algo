package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 아기상어
 * https://www.acmicpc.net/problem/16236
 */
public class baek16236 {
	static class Point{
		int r, c;
		
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}	
		
	}
	static int N,ans,w,eat;
	//상, 좌, 하, 우
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int[][] map, dist;
	static List<Point>[] fishs;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new int[N][N];
		fishs = new ArrayList[8];
		ans = 0;
		for(int i = 1 ; i<=7;i++) {
			fishs[i] = new ArrayList<>();
		}
		int eat = 0;
		w = 2;
		Point start=null;
		for(int r = 0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c =0 ;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());;
				if(map[r][c] ==9) {
					start = new Point(r,c);
				}else if(map[r][c] != 0) {
					fishs[map[r][c]].add(new Point(r,c));
				}
			}
		}
		while(true) {
			if(!check(start)) {
				break;
			}
			bfs(start);
			
			map[start.r][start.c] = 0;
			int min = Integer.MAX_VALUE;
			Point temp = null;
			int index = -1;
			int weight = -1;

			for(int i =1;i<w;i++) {
				for(int j=0;j<fishs[i].size();j++) {
					temp = fishs[i].get(j);
					if(min> dist[temp.r][temp.c] && dist[temp.r][temp.c] != -1) {
						min = dist[temp.r][temp.c];
						start = fishs[i].get(j);
						index = j;
						weight=i;
					}else if(min == dist[temp.r][temp.c] && dist[temp.r][temp.c] != -1) {
						if(start.r >temp.r) {
							start = fishs[i].get(j);
							index = j;
							weight=i;
						}else if(start.r==temp.r) {
							if(start.c>temp.c) {
								start = fishs[i].get(j);
								index = j;
								weight=i;
							}
						}
					}
				}
			}
			if(min==-1 || weight== -1 || index == -1) {
				break;
			}
			map[start.r][start.c]= 9; 

			fishs[weight].remove(index);			
			if(w<7) {
				eat++;
				if(eat==w) {
					w++;
					eat=0;
				}				
			}
			ans+=min;
		}
		System.out.println(ans);
	}
	private static boolean check(Point start) {
		for(int i = 1 ;i<w;i++) {
			if(fishs[i].size()!=0) {
				return true;
			}
		}
		return false;
	}
	static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		dist = new int[N][N];
		for(int i =0 ;i<N;i++) {
			Arrays.fill(dist[i], -1);
		}
		
		q.add(start);
		dist[start.r][start.c] = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i = 0 ;i<4;i++) {
				int nr = p.r  + dr[i];
				int nc = p.c  + dc[i];
				
				if(!isIn(nr, nc)) {
					continue;
				}
				if(dist[nr][nc] != -1) {
					continue;
				}
				if(map[nr][nc]>w) {
					continue;
				}
				dist[nr][nc] = dist[p.r][p.c]+1;
				q.add(new Point(nr,nc));
			}
		}
	}
	static boolean isIn(int r, int c) {
		return r<N && c<N && r>=0 && c>=0;
	}
}
