package codeforces.div2.round699;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * A. Space Navigation
 */
public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int[] dist = new int[4];
			String command = br.readLine();
			
			for(int i =0;i<command.length();i++) {
				char ch = command.charAt(i);
				switch (ch) {
				case 'U':
					dist[0]++;
					break;
				case 'D':
					dist[1]++;
					break;
				case 'R':
					dist[2]++;
					break;
				case 'L':
					dist[3]++;
					break;
				}				
			}
			boolean answer = false;
			if(X>0&& dist[2] >= X) {
				if(Y>0 && dist[0]>=Y) {
					answer = true;
				}else if(Y<=0 && dist[1]>= Math.abs(Y)){
					answer = true;
				}
			}else if(X<=0&& dist[3] >= Math.abs(X)){
				if(Y>0 && dist[0]>= Y) {
					answer = true;
				}else if(Y<=0 && dist[1]>= Math.abs(Y)){
					answer = true;
				}
			}
			
			if(answer) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
