package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Z
 * https://www.acmicpc.net/problem/1074
 */
public class baek1074 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		//4등분 할 크기
		int size = (int) Math.pow(2, N - 1);
		int rr = size;
		int cc = size;
		while(N-- >0) {
			int temp = (int)Math.pow(2, N-1);
			int skip = (int)Math.pow(4, N);
			
			if(r< rr) {
				//상좌
				if(c<cc) {
					rr -= temp;
					cc -= temp;
				}
				//상우 
				else {
					rr -= temp;
					cc += temp;
					ans += skip;
				}
			}else {
				//하좌
				if(c<cc) {
					rr += temp;
					cc -= temp;
					ans += skip * 2;
				}
				//하우
				else {
					rr += temp;
					cc += temp;
					ans += skip*3;
				}
			}
		}
		System.out.println(ans);
	}
}
