package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 번호
 * https://www.acmicpc.net/problem/1039
 */
public class baek1039 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String num = st.nextToken();
		int N = Integer.parseInt(num);
		int K = Integer.parseInt(st.nextToken());
		
		boolean[][] visited = new boolean[1000001][11];
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {N,0});
		visited[N][0] = true;
		
		while(!q.isEmpty()) {
			if(q.peek()[1] == K) {
				break;
			}
			int[] temp = q.poll();
			for(int i =0;i<num.length()-1;i++) {
				for(int j=i+1;j<num.length();j++) {
					int next = swap(temp[0], i, j);
					if(next != -1 && !visited[next][temp[1]+1]) {
						visited[next][temp[1]+1] = true;
						q.offer(new int[] {next, temp[1]+1});
					}
				}
			}
		}
		int answer = -1;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			answer = Math.max(answer, temp[0]);
		}
		
		System.out.println(answer);
	}
	public static int swap(int n, int i, int j) {
		StringBuilder sb = new StringBuilder();
		sb.append(n);
		if(i==0 && sb.charAt(j) =='0') {
			return -1;
		}
		
		//swap
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
		return Integer.parseInt(sb.toString());
	}
}
