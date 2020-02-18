package swea.d5;

import java.util.Arrays;
import java.util.Scanner;
class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		
		return String.format("[%d, %d]", x,y);
	}
}
public class swea1247 {
	static boolean[] v;
	static Pair[] map;
	static int N;
	static int min;
	static Pair start;
	static Pair end;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t =1 ;t<=T;t++) {
			N =sc.nextInt();
			min =Integer.MAX_VALUE;
			v = new boolean[N+2];
			map = new Pair[N+2];
			
			for(int i =0;i<N+2;i++) {
				map[i] = new Pair(sc.nextInt(),sc.nextInt());
			}
			
			dfs(0,0,0);
		
			System.out.println(String.format("#%d %d", t,min));
		}
	}
	static void dfs(int n,int index,int sum) {
		
		if(index==N) {
			sum += dist(map[n],map[1]);			
			if(min>sum) {
				min = sum;
			}			
			return;
		}		
		for(int i =2;i<N+2;i++) {
			if(v[i]) {
				continue;
			}					 
			Pair p = map[n];
			Pair temp = map[i];
			int d = dist(p,temp);
			sum = sum+ d;
			v[i] = true;
			dfs(i,index+1,sum);
			sum =sum - d;
			v[i] =false;
		}
		
	}
	static int dist(Pair p1, Pair p2) {		
		return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
	}
}
