package swea.d2;

import java.util.Scanner;

public class swea1284 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1 ; test_case<=T;test_case++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int a = P*W;
			int b ;
			if(R<W) {
				b = (W-R)*S +Q;
			}else {
				b = Q;
			}		
			
			System.out.println(String.format("#%d %d", test_case, Math.min(a,b)));
		}
	}

}
