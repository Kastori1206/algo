package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 숨바꼭질4
 * https://www.acmicpc.net/problem/13913
 * BFS
 */
public class baek13913 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//도착 시간 배열
		int[] dist = new int[100001];
		//어디서 왔는지 저장하는 배열
		int[] v = new int[100001];
		
		int size = dist.length;
		boolean[] check = new boolean[100001];
		//어떻게 이동한지 저장하는 리스트
		List<Integer> ans = new ArrayList<Integer>();
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		check[N] = true;
		
		//BFS
		while(!q.isEmpty()) {
			int temp = q.poll();
			if(temp *2 <size ) {
				if(!check[temp*2]) {
					q.add(temp*2);
					check[temp*2] = true;
					dist[temp*2] = dist[temp] +1;
					v[temp*2] = temp;
				}
			}
			if(temp -1 >= 0 ) {
				if(!check[temp-1]) {
					q.add(temp-1);
					check[temp-1] = true;
					dist[temp-1] = dist[temp] +1;
					v[temp-1] = temp;
				}
			}			
			if(temp +1 <size ) {
				if(!check[temp+1]) {
					q.add(temp+1);
					check[temp+1] = true;
					dist[temp+1] = dist[temp] +1;
					v[temp+1] = temp;
				}
			}
		
		}
		
		System.out.println(dist[K]);
		//도착지점
		ans.add(K);
		
		while(K!=N) {			
			ans.add(v[K]);
			K = v[K];
		}
		
		//거꾸로 출력
		for(int i = ans.size()-1; i>=0;i--) {
			System.out.print(ans.get(i)+" ");
		}
		
	}
}
