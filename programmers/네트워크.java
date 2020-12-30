package programmers;

/* 네트워크
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 * DFS/BFS
 */
public class 네트워크 {
	class Solution {
	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	        boolean[] visited = new boolean[n];
	        for(int i =0;i<n;i++){
	            if(visited[i]){
	               continue; 
	            }
	            dfs(n,i,computers,visited);
	            answer++;
	        }
	        return answer;
	    }
	    public void dfs(int n, int start, int[][] computers, boolean[] visited){
	        for(int i=0;i<n;i++){
	            if(visited[i]){
	                continue;
	            }
	            if(computers[start][i]==0){
	                continue;
	            }
	            visited[i] = true;
	            dfs(n,i,computers,visited);
	        }
	    }
	}
}
