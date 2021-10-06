package programmers;
import java.util.*;

/**
 * 전력망을 둘로 나누기
 * https://programmers.co.kr/learn/courses/30/lessons/86971
 */
public class 전력망을둘로나누기 {
	static int[][] map;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = 100;
        map = new int[n+1][n+1];
        
        for(int i =0 ; i< wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            map[a][b] = 1;
            map[b][a] = 1;            
        }
        for(int i =0 ; i< wires.length;i++){
        	//전선을 하나 끊음
            int a = wires[i][0];
            int b = wires[i][1];
            map[a][b] = 0;
            map[b][a] = 0;
            visited = new boolean[n+1];
            
            for(int j = 1; j<=n;j++){
                if(visited[j]){
                    break;
                }
                int temp1 = bfs(j);
                int temp2 = n - temp1;
                answer = Math.min(answer, Math.abs(temp1-temp2));
            }
            //전선 복구
            map[a][b] = 1;
            map[b][a] = 1;  
        }
        
        return answer;
    }
    static int bfs(int start){
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            res++;            
            for(int i = 1; i< map.length;i++){
                if(visited[i]){
                    continue;
                }
                if(map[cur][i] == 0){
                    continue;
                }
                visited[i] = true;
                q.offer(i);
            }
        }
        return res;
    }
}

