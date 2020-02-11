package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2804 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		int M = str1.length();
		int N = str2.length();
		char[][] crr = new char[N][M];
		
		int x = 0,y = 0;
		loop:for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					x = i;
					y = j;
					break loop;
				}
			}
		}
		for(int i=0;i<N;i++) {			
			for(int j=0;j<M;j++) {
				if(j==x) {
					crr[i][j]= str2.charAt(i);
					continue;
				}
				if(i==y) {
					crr[i][j] = str1.charAt(j);
					continue;
				}
				crr[i][j] ='.';				
			}
		}
		
		for(int i =0;i<N;i++) {
			for(int j=0; j<M;j++) {
				System.out.print(crr[i][j]);
			}
			System.out.println();
		}
	}
}
