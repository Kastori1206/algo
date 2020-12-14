package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15686
 * 
 */
public class baek15686 {
	public static class Point{
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}		
	}
	static int N, M, MIN;
	static List<Point> Houses, Chicken;	
	
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MIN = Integer.MAX_VALUE;
		
		Houses = new ArrayList<>();
		Chicken = new ArrayList<>();
		for(int r = 0 ; r< N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ;c< N; c++) {
				String str = st.nextToken();
				if(str.equals("1")) {
					Houses.add(new Point(r,c));
				}else if(str.equals("2")) {
					Chicken.add(new Point(r,c));
				}
			}
		}
		visited = new boolean[Chicken.size()];
		
		combi(0,0);
		System.out.println(MIN);
	}
	
	//전체 치킨집에서 M개를 뽑는다.
	static void combi(int index, int start) {
		if(index == M) {
			calc();
			return;
		}
		for(int i =start; i<Chicken.size();i++) {
			visited[i] = true;
			combi(index+1,i+1);
			visited[i] = false;
		}
	}
	private static void calc() {
		int sum = 0;
		//집에서 각 치킨집 까지의 거리를 구해 최소값을 더한다.
		for(int i =0; i<Houses.size();i++) {
			int min = Integer.MAX_VALUE;
			Point house = Houses.get(i); 
			for(int j = 0 ;j<Chicken.size();j++) {
				if(visited[j]) {
					Point chicken = Chicken.get(j);
					int dist  = Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c);
					min = min > dist ? dist : min;
				}
			}
			sum += min;
		}
		//전체 합이 최소인것을 구한다.
		MIN = MIN > sum ? sum : MIN;		
	}	
}
