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
public class swea7793 {
	//출력을 모아서!!
	static StringBuffer sb = new StringBuffer();
	//사방탐색
	static int[][] dirs = { {-1,0},{1,0},{0,-1},{0,1}};
	
	static int T,N,M;
	static char[][] map;
	static Queue<Point> devil, player;
	static class Point{
		int y, x,depth; //행, 렬, 깊이(단계)
		Point(int y, int x, int depth){
			this.y = y;
			this.x = x;
			this.depth = depth;
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
			devil = new LinkedList<>();
			player = new LinkedList<>();
			for(int i =0;i<N;i++) {
				map[i] = br.readLine().toCharArray();
				for(int j =0;j<M;j++) {
					if(map[i][j] =='*') {
						devil.offer(new Point(i,j,0));
					}else if(map[i][j] =='S') {
						player.offer(new Point(i,j,0));
					}
				}
				
				//탐험시작
				//끝나는 시점: 모든 수연이 소멸할때까지 or 수연이가 여신에게 도달할때까지.
				while(true) {
					//1.만약 player가 없다면 --> game over
					if(player.size()==0) {
						sb.append("Game OVER");
						break;
					}
					//2. devil이 1초 동작 --> ., S를 만나면 오염시킨다.
					bfsDevil();
					//3. player가 동작 --> .으로 이동, D를 만나면 종료
					int result = bfsPlayer();
					if(result != -1) {
						sb.append(result);
						break;
					}					
				}
			}			
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	static int bfsPlayer() {
		int size = player.size();
		
		while(size-- > 0) {
			Point front = player.poll();
			
			//자식 탐색 - 사방 탐색
			for(int i =0;i<dirs.length; i++) {
				int nx = front.x  + dirs[i][0];
				int ny = front.y + dirs[i][1];
				
				if(isBound(ny, nx)) {//범위에 있다면 수연이는 . 으로 이동, D를 만나면 끝
					if(map[ny][nx] == 'D') {
						return front.depth;						
					}else if(map[ny][nx] == '.') {
						map[ny][nx] = 'S';
						player.offer(new Point(ny,nx,front.depth+1));
					}
				}
			}
		}		
		return -1;
	}
	//현재 Queue에 있는 놈까지만 돈다. !! 새로운 녀석은 그냥 담아 둘 뿐..
	// size()
	private static void bfsDevil() {
		int size = devil.size();
		
		while(size-- > 0) {
			Point front = devil.poll();
			
			//자식 탐색 - 사방 탐색
			for(int i =0;i<dirs.length; i++) {
				int nx = front.x  + dirs[i][0];
				int ny = front.y + dirs[i][1];
				
				if(isBound(ny, nx)) {//범위에 있다면 악마는 ., S를 대상으로 이동
					if(map[ny][nx] == '.' || map[ny][nx] == 'S') {
						// 지도의 상태를 변경한 것 자체가 방문처리.
						map[ny][nx] = '*';
						//큐에 새로 들어가긴 하지만 빠지지 않는다.
						devil.offer(new Point(ny,nx,front.depth+1));
					}
				}
			}
		}
	}
	static boolean isBound(int y, int x) {
		return 0 <= y && 0<= x && y<N && x<M;
	}
}
