package codeforces.round101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_BuildingaFence {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
		}
	}
}
