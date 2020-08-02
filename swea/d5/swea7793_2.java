package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.IntToDoubleFunction;

import javax.management.Query;

/*
 * 
 * 
 * -안전지역으로 가기 위한최소시간 : BFS
 * - 악마와 수연이가 각각 별도의 Queue에서 동작
 * - 악마의 * : 1초마다 사방으로 퍼져나간다, . , S를 대상으로
 * - 수연 S : 1초마다 사방탐색으로 이동, . 을 대상으로 이동, D를 만나면 종료
 * - 수연이 없어지면 - 종료
 */
public class swea7793_2 {
	//출력을 모아서!!
	static StringBuffer sb = new StringBuffer();
	//사방탐색
	static int[][] dirs = { {-1,0},{1,0},{0,-1},{0,1}};
	
	static int T,N,M,A ;
	static char[][] map;
	static Queue<Point> points;
	static class Point{
		int y, x,depth; //행, 렬, 깊이(단계)
		boolean isDevil;
		
		Point(int y, int x, int depth, boolean isDevil){
			this.y = y;
			this.x = x;
			this.depth = depth;
			this.isDevil = isDevil;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T;t++) {
			sb.append("#").append(t).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  	//N,M(2<= N, M<=50)
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			points = new LinkedList<>();
			A = Integer.MAX_VALUE;
			for(int i =0;i<N;i++) {
				map[i] = br.readLine().toCharArray();
				for(int j =0;j<M;j++) {
					if(map[i][j] =='*') {
						points.offer(new Point(i,j,0,true));
					}else if(map[i][j] =='S') {
						points.offer(new Point(i,j,0,false));
					}
				}
				
				//탐험시작
				//끝나는 시점: 모든 수연이 소멸할때까지 or 수연이가 여신에게 도달할때까지.
				outer :while(!points.isEmpty()) {
					Point front = points.poll();
					
					//자식 탐색 - 사방 탐색
					for(int d =0;d<dirs.length; d++) {
						int ny = front.y + dirs[d][0];
						int nx = front.x + dirs[d][1];
						
						if(isBound(ny, nx)) {//범위에 있다면 수연이는 . 으로 이동, D를 만나면 끝
							if(front.isDevil) {
								if(map[ny][nx] == '.' || map[ny][nx] == 'S') {
									// 지도의 상태를 변경한 것 자체가 방문처리.
									map[ny][nx] = '*';
									//큐에 새로 들어가긴 하지만 빠지지 않는다.
									points.offer(new Point(ny,nx,front.depth+1,true));
								}
							}else {
								if(map[ny][nx] == 'D') {
									A = front.depth+1;
									break outer;								
								}else if(map[ny][nx] == '.') {
									map[ny][nx] = 'S';
									points.offer(new Point(ny,nx,front.depth+1,false));
								}
							}
						}
					}
				}
			}			
			sb.append((A==Integer.MAX_VALUE? "GAME OVER" : A));
			sb.append("\n");
		}
		System.out.println(sb);		
	}
	
	static boolean isBound(int y, int x) {
		return 0 <= y && 0 <= x && y<N && x<M;
	}
}
