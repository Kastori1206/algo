package swea.d2;

import java.util.Scanner;

public class swea1984 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)	{
			double[] a = new double[10];
			double min = 10001;
			double max = -1;
			double sum = 0;
			double avg = 0;
			
			for(int i =0;i<10;i++) {
				a[i] = sc.nextDouble();
			}
			
			for(int i=0;i<10;i++) {
				if(min>a[i]) {
					min=a[i];
				}
				if(max<a[i]) {
					max = a[i];
				}
				sum += a[i];
			}
			
			sum = sum - max - min;
			avg = sum/8;
			System.out.println("#"+ test_case+" "+Math.round(avg));


		}
	}

}
