package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class swea1873 {
	//상하좌우
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int x,y,H,W;
	static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 1; t<=T;t++) {
			//입력
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());			
			
			map = new char[H][W];
			for(int i=0;i<H;i++) {
				String str = br.readLine();
				for(int j=0;j<W;j++) {
					map[i][j] = str.charAt(j);
					if(str.charAt(j)=='v'|| str.charAt(j)=='^' || str.charAt(j)=='<' || str.charAt(j)=='>') {
						x = j;
						y = i;
					}
				}
			}
		
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			
			String str = br.readLine();
			for(int i =0;i<N;i++) {							
				move(str.charAt(i));				
			}		
			
			//출력
			System.out.print("#"+t+" ");			
			for(int i =0;i<H;i++) {
				for(int j =0;j<W;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}			
		}
	}
	static void move(char command) {
		int nx,ny;
		switch (command) {
		case 'U':
			nx= x+dx[0];
			ny= y+dy[0];
			map[y][x] = '^';
			if(isBound(nx, ny, H, W) && map[ny][nx] =='.') {
				map[ny][nx] = '^';
				map[y][x] = '.';
				x=nx; y=ny;
			}
			break;
		case 'D':
			nx= x+dx[1];
			ny= y+dy[1];
			map[y][x] = 'v';			
			if(isBound(nx,ny,H,W) && map[ny][nx] =='.') {
				map[ny][nx] = 'v';
				map[y][x] = '.';
				x=nx; y=ny;
			}
			break;
		case 'L':
			nx= x+dx[2];
			ny= y+dy[2];
			map[y][x] = '<';
			if(isBound(nx, ny, H, W) && map[ny][nx] =='.') {
				map[ny][nx] = '<';
				map[y][x] = '.';
				x=nx; y=ny;
			}
			break;
		case 'R':
			nx= x+dx[3];
			ny= y+dy[3];
			map[y][x] = '>';
			if(isBound(nx, ny, H, W) && map[ny][nx] =='.') {
				map[ny][nx] = '>';
				map[y][x] = '.';
				x=nx; y=ny;
			}
			break;
		case 'S':
			int dist = isDist(map[y][x]);
			nx = x;
			ny = y;
			while(true) {				
				nx = nx+dx[dist];
				ny = ny+dy[dist];				
				if(!isBound(nx, ny, H, W)) {
					break;
				}
				if(map[ny][nx] =='*') {
					map[ny][nx] ='.';
					break;
				}
				if(map[ny][nx] =='#') {
					break;
				}
			}
			break;

		}
	}
	static Boolean isBound(int x, int y, int H, int W) {
		if(x>=W || x<0 || y>=H || y<0) {
			return false;
		}
		return true;
	}
	static int isDist(char ch) {
		int d = 0;
		switch(ch) {
		case '^':
			d = 0;
			break;
		case 'v':
			d = 1;
			break;
		case '<':
			d = 2;
			break;
		case '>':
			d = 3;
			break;
		}
		return d;
	}
	
}
