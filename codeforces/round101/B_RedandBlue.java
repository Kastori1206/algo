package codeforces.round101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_RedandBlue {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t =0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] red = new int[N];
			int ans1 = 0;
			int ans2 = 0;
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int i =0;i<N;i++) {
				red[i] = Integer.parseInt(st.nextToken());
				sum += red[i];
				ans1 = Math.max(sum,ans1);
			}
	
			int M = Integer.parseInt(br.readLine());
			int[] blue = new int[M];
			
			sum = 0;
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<M;i++) {
				blue[i] = Integer.parseInt(st.nextToken());
				sum += blue[i];
				ans2= Math.max(sum, ans2);
			}
			
			System.out.println(ans1+ans2);
		}//테스트 케이스 끝
	}
}
