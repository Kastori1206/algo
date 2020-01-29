package swea.d2;

import java.util.Scanner;

public class swea1945 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();	
		
		int[] n = {2, 3, 5, 7, 11};
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			
			int[] a = new int[5];
			
			//소인수구하기
			for(int i =0;i<5;i++) {
				int cnt =0;
				while(true) {
					if(N%n[i]==0) {
						N/=n[i];
						cnt++;
					}else {
						break;
					}
				}
				a[i] = cnt;
			}
			
			//출력
			System.out.print("#"+test_case+" ");
			for(int i=0;i<5;i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();			
		}
	}
}
