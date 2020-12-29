package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 카잉달력
 * https://www.acmicpc.net/problem/6064
 */

public class baek6064 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int a =x % N;
			if(a==0) {
				a=N;
			}
			int cnt = 0;
			boolean flag = false;
			while (cnt<=N) {
				if (a == y) {
					flag = true;
					break;
				}
				a = (a + M) % N;
				if (a == 0) {
					a = N;
				}
				cnt++;
			}
			
			System.out.println(flag ? cnt * M + x : -1);
		}
	}
}
