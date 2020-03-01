package baek;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 연결 요소의 개수
 * https://www.acmicpc.net/problem/11724
 */
public class baek11724 {
	static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
	static boolean v[];
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		v = new boolean[n];
		for(int i=0;i<n;i++) {
			map.add(new ArrayList<>());
		}
		for(int i=0;i<m;i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			map.get(x).add(y);
			map.get(y).add(x);
		}
		
		for(int i =0;i<n;i++) {
			if(v[i]) {
				continue;
			}
			dfs(i);
			cnt++;
		}
		
		System.out.println(cnt);
	}
	static void dfs(int i) {
		v[i] = true;
		for(int temp : map.get(i)) {
			if(v[temp]) {
				continue;
			}
			dfs(temp);
		}
	}
}
