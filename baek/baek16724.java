package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 피리 부는 사나이 
 * https://www.acmicpc.net/problem/16724
 */
public class baek16724 {
	static class Node{
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Node) {
				Node node = (Node) obj;
				if(node.r == r && node.c == c) {
					return true;
				}
			}
			return false;
		}

		//set에서 Node들의 중복체크
		@Override
		public int hashCode() {
			return Objects.hash(r, c);
		}

	}
	static Set<Node> set;
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static boolean cycle;
	//상하좌우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int r = 0 ;r<R;r++) {
			String str = br.readLine();
			for(int c =0;c<C;c++) {
				map[r][c] = str.charAt(c);
			}
		}
		int answer = 0 ;
		for(int r = 0 ;r<R;r++) {
			for(int c =0;c<C;c++) {
				if(visited[r][c]) {
					continue;
				}
				//한번 dfs돌때 좌표들을 저장
				set = new HashSet<>();
				//시작점에서 dfs돌고 cycle이 생겼으면 true, 아니면 false
				cycle = false;
				dfs(new Node(r,c));
				
				if(cycle) {
					answer ++;					
				}
			}
		}
		System.out.println(answer);
	}
	static void dfs(Node node) {
		set.add(node);
		int r = node.r;
		int c = node.c;
		//시작점에서 dfs를 돌 때 방문한 곳이 아니라 그전에 방문한 곳이라면
		if(visited[r][c]) {
			return;
		}
		
		visited[r][c] = true;
		int d  = getDir(map[r][c]);
		int nr = r + dr[d];
		int nc = c + dc[d];
		
		Node next = new Node(nr, nc);
		//시작점에서 dfs 돌 때 방문한 곳이면 cycle == true;
		if(set.contains(next)) {
			cycle = true;
			return;
		}
		dfs(next);
	}
	
	static int getDir(char ch) {		
		switch (ch) {
		case 'U':			
			return 0;
		case 'D':
			return 1;
		case 'L':
			return 2;		
		}
		return 3;
	}
}
