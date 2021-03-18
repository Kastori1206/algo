package codeforces.div2.round106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * B. Binary Removals
 * https://codeforces.com/contest/1499/problem/B
 */
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t =0;t<T;t++) {
			String s = br.readLine();
			int len = s.length();
			String answer ="YES";
			boolean[] visited = new boolean[len+1];
			if(len<4) {
				System.out.println("YES");
			}else {
				int now = 0;
				for(int i=0;i<len;i++) {
					if(s.charAt(i)-'0'==now) {
						continue;
					}
					if(!visited[i] ) {
						visited[i+1] = true;
					}else {
						now++;
						if(now>1) {
							answer = "NO";
							break;
						}
					}
				}
				System.out.println(answer);
			}
		}
	}
}
