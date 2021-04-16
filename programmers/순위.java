package programmers;

import java.util.*;

/*
 * 순위
 * https://programmers.co.kr/learn/courses/30/lessons/49191
 */
public class 순위 {
	public static void main(String[] args) {
		
	}
	public int solution(int n, int[][] results) {
		int answer = 0;
		int len = results.length;
		List<Integer> adj[] = new ArrayList[len+1];
		int[] indegree = new int[len];
		
		for(int i =0;i<len+1;i++) {
			adj[i] = new ArrayList<Integer>();
		}
				
		for(int i =0;i<len;i++) {
			int win = results[i][0];
			int lose = results[i][1];
			
			adj[lose].add(win);
			indegree[win] ++;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i =0;i<len;i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i =0;i<adj[temp].size();i++) {
				int next = adj[temp].get(i);
				indegree[next]--;
				if(indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		return answer;
	}
}
