package baek;

import java.util.ArrayList;
import java.util.Scanner;
class Enemy{
	int r,c;
	Enemy(int r, int c){
		this.r = r;
		this.c = c;
	}
}
public class baek17135 {
	static int[][] map;			//적위치 표시
	static boolean[][] chk;		//적을 죽였는지 안죽였는지 표시
	static boolean[] v;			//궁수위치 뽑을때 사용
	static int[] a;				//궁수위치 저장
	static int max;				//가장큰수
	static int d;				//거리
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		int m = sc.nextInt();
		d = sc.nextInt();
		
		map = new int[n+1][m];		//n자리에 궁수 위치
		v = new boolean[m];
		a = new int[3];
		max = Integer.MIN_VALUE;
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}		

		go(0,0,3,n,m);
		System.out.println(max);
		
	}	
	static int getDist(int x1, int y1, int x2, int y2) {
		int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
		if(dist<=d) {
			return dist;
		}
		return -1;
	}
	static Enemy findNear(int turn, int n, int m, int x) {
		Enemy res = null;
		int dist = Integer.MAX_VALUE;
		for(int i =0;i<n-turn;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] ==1 && !chk[i][j] ) {
					int temp = getDist(j,i,x,n-turn);
					if(temp==-1) {
						continue;
					}
					if(dist >temp) {
						dist = temp;									
						res = new Enemy(i, j);
					}else if(dist== temp) {
						if(res.c > j) {
							res.r = i;
							res.c = j;							
						}
					}
					
				}
			}			
		}		
		return res;
	}
	
	static void go(int index, int start, int target,int n,int m) {
		if(index == target) {
			int result= 0;
			ArrayList<Enemy> list = new ArrayList<>();
			chk= new boolean[n][m];
			for(int i=0;i<n;i++) {
				for(int k=0;k<3;k++) {
					Enemy temp = findNear(i,n,m,a[k]);
					if(temp!=null) {
						list.add(temp);
					}
				}		
				for(Enemy e : list) {					
					if(!chk[e.r][e.c]) {
						chk[e.r][e.c]= true; 
						result++;
					}
				}					
			}			
			if(result>max) {
				max =result;
			}
			return;
		}
		for(int i=0;i<m;i++) {
			if(v[i]) {
				continue;
			}
			v[i] = true;
			a[index] = i;
			go(index+1,i+1,target,n,m);
			v[i]= false;				
		}
	}
	static void print(int n, int m) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(chk[i][j] +" ");
			}
			System.out.println();
		}
	}

}
