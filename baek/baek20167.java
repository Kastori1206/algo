package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 꿈틀꿈틀 호석 애벌레 - 기능성
 * https://www.acmicpc.net/problem/20167
 */
public class baek20167 {
	static int N, K, answer;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer =0;
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,0);
		System.out.println(answer);
	
	}
	private static void dfs(int index, int eat, int sum) {
		if(index==N) {
			answer = Math.max(answer, eat);
			return;
		}
		
		dfs(index+1,eat,0);
		if(sum+arr[index]>=K) {
			dfs(index+1,eat+sum+arr[index]-K,0);
		}else {
			dfs(index+1,eat,sum+arr[index]);
		}
	}
}
