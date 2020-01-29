package swea.d2;

import java.util.Scanner;

public class swea1946 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();		

		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int[] a = new int[N];
			String [] b = new String[N];
			
			StringBuffer sb = new StringBuffer();
			
			//입력
			for(int i=0;i<N;i++) {
				b[i] = sc.next();
				a[i] = sc.nextInt();
			}
			
			//압축풀기
			sb.append("#"+test_case+"\n");
			int cnt =1;
			for(int i=0;i<N;i++) {
				for(int j=0;j<a[i];j++) {
					if(cnt%10==0) {
						sb.append(b[i]+"\n");
					}else {
						sb.append(b[i]);						
					}
					cnt++;
				}
			}			
			//출력
			System.out.println(sb);		
		}
	}

}
