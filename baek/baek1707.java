package baek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 이분그래프
 * https://www.acmicpc.net/problem/1707
 */
public class baek1707 {
	static ArrayList<ArrayList<Integer>> map;
	static int[] colors;
	static boolean flag =true;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0;t<T;t++) {
			int v = sc.nextInt();
			int e = sc.nextInt();			
			map = new ArrayList<>();
			colors = new int[v];
			flag = true;
			for(int i =0;i<v;i++) {
				map.add(new ArrayList<>());
				colors[i] = 0;
			}
			for(int i = 0;i<e;i++) {
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				map.get(x).add(y);
				map.get(y).add(x);
			}
			
			for(int i=0;i<v;i++) {
				if(!flag) {
					break;
				}
				if(colors[i]==0) {
					bfs(i,1);
				}
			}
			System.out.println(flag ? "YES":"NO");
			
		}
	}//main
	static void bfs(int vertex, int color) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(vertex);
		colors[vertex] = color;
		
		while(!q.isEmpty() && flag) {
			int v  = q.poll();
			
			for(int temp : map.get(v)) {
				if(colors[temp] ==0) {
					q.offer(temp);
					colors[temp] = colors[v] * -1;
				}else if( colors[v] + colors[temp] !=0) {
					flag=false;
					return;
				}
				
			}
		}
	}
}
