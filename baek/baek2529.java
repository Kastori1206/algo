package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek2529 {
	static int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int[] pnums;
	static char[] arr;
	static int K;
	static String MIN, MAX;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		MIN = ""+Long.MAX_VALUE;
		MAX = ""+Long.MIN_VALUE;
		arr = new char[K];
		pnums = new int[K+1];
		visited = new boolean[10];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		dfs(0,K+1);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	private static void dfs(int index, int r) {
		if(index == r) {
			if(check()) {
				String n = "";
				for(int i=0;i<r;i++) {
					n += pnums[i];					
				}
				System.out.println(n);
				long min = Long.parseLong(MIN);
				long max = Long.parseLong(MAX);
				long num = Long.parseLong(n);
				MIN = min > num? n : MIN;
				MAX = max < num? n : MAX;
			}
			return;
		}
		for(int i =0;i<10;i++) {
			if(visited[i]) {
				continue;
			}
			visited[i]= true;
			pnums[index] = nums[i];
			dfs(index+1, r);
			visited[i]= false;
		}
		
	}
	private static boolean check() {
		for(int i = 0;i<K;i++) {
			switch (arr[i]) {
			case '<':
				if(pnums[i] > pnums[i+1]) {
					return false;
				}
				break;
			case '>':
				if(pnums[i] < pnums[i+1]) {
					return false;
				}
				break;
			}
		}
		return true;		
	}
}
