import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test5 {
	static int[] dx = {1, 1, 0, -1}; //우,우하,하,좌하
	static int[] dy = {0, 1, 1, 1};
	static int[][] map ;
	static int N = 19;
	static int []d ;
	static int cnt;
	
	//현재 돌 위치에서 검색하려는 방향에 돌이 있는지 체크
	static boolean chk(int x, int y,int user) {
		if(x>N || x<1|| y>N || y<1) {
			return true;
		}
		if(map[y][x] == user ) {
			return false;
		}
		return true;
	}
	
	static void go(int x,int y,int dir, int user) {
		if(x>N || x<1|| y>N || y<1) {
			return ;
		}
		if(map[y][x] != user ) {
			return ;
		}
		cnt++;
		go(x+dx[dir],y+dy[dir],dir,user);		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Test5.txt"));
		Scanner sc = new Scanner(System.in);
		// 구현하세요.
		
		map = new int[N+1][N+1];
		
		for(int i =1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				map[i][j] = sc.nextInt(); //바둑판 입력받기
			}
		}

		for(int i =1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				if(map[i][j]==0) {//바둑판이 0이면 검사할필요없음
					continue;
				}
				for(int k=0;k<4;k++) {
					cnt = 0;
					if(chk(j-dy[k],i-dx[k], map[i][j])){//좌, 좌상,	상,우상 바둑돌이 없으면	
						go(j,i,k,map[i][j]);//검사
						if(cnt ==5) {//돌이 5개면
							System.out.println(map[i][j]);
							System.out.println(i+" "+j);
							return;
						}						
					}
				}
			}
		}		
		System.out.println("0");	
	}

}
