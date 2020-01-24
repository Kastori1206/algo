package swea.d2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class swea1983 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();		
		
		String[] g = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int K = sc.nextInt();
			ArrayList<Double> a = new ArrayList<Double>();
			double find=0;
			for(int i=1;i<=N;i++) {
				double sum =0;
				for(int j=0;j<3;j++) {
					double score = sc.nextDouble();
					if(j==0) {						
						sum+=(score*0.35);
					}else if(j==1) {
						sum+=(score*0.45);
					}else {
						sum+=(score*0.2);
					}
				}
				if(i==K) {
					find = sum;
				}
				a.add(sum);
			}	
			a.sort(Collections.reverseOrder());
			int idx = a.indexOf(find);
			idx = idx/(N/10);
			System.out.println("#"+test_case+" "+g[idx]);
		}
	}

}
