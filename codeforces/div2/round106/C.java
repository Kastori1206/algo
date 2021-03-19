package codeforces.div2.round106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * C. Minimum Grid Path
 * https://codeforces.com/contest/1499/problem/C
 */
public class C {
	static final long INF = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t =0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			long a1 = 0l;
			long b1 = 0l;
			
			long ans = INF;
			long minA = INF, minB = INF;
			int ai = 0, bi = 0;
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++){
				long k = Long.parseLong(st.nextToken());
				if(i%2==0){
					ai ++;
					a1 += k;
					minA = Math.min(minA, k);
				}else{
					bi ++;
					b1 += k;
					minB = Math.min(minB, k);
				}
				if(i > 0){
					long v1 = a1 + minA * (N-ai);
					long v2 = b1 + minB * (N-bi);
					ans = Math.min(ans, v1+v2);
				}
			}
 
			System.out.println(ans);
		}
	}
}
