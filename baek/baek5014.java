package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 스타트링크
 * https://www.acmicpc.net/problem/5014
 */
public class baek5014 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] command = new int[5];
		for (int i = 0; i < 5; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}
		int F = command[0];
		int S = command[1];
		int G = command[2];
		int U = command[3];
		int D = command[4];
		
		//몇 번 눌렀는지 기록하는 배열
		int[] visited = new int[F + 1];
		//-1로 초기화
		Arrays.fill(visited, -1);
		
		//BFS
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S);
		visited[S] = 0;
		while (!q.isEmpty()) {
			int len = q.size();
			int stair = q.poll();
			//G에 도착 할 경우
			if (stair == G) {
				break;
			}
			for (int i = 0; i < len; i++) {
				//올라갈 경우
				if (stair + U <= F && visited[stair + U] == -1) {
					visited[stair + U] = visited[stair] + 1;
					q.offer(stair + U);
				}
				//내려갈 경우
				if (stair - D >= 1 && visited[stair - D] == -1) {
					visited[stair - D] = visited[stair] + 1;
					q.offer(stair - D);
				}
			}
		}
		
		//-1이면 못감, 아니면 갈수있음 
		int answer = visited[G];
		if (answer == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(answer);
		}
	}
}
