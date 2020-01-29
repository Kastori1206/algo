package swea.d2;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class swea1970 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int[]a = {50000,10000,5000,1000,500,100,50,10};

		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			String result ="";
			
			for(int i =0;i<a.length;i++){
				result += (N/a[i])+" ";
				N%=a[i];
			}
			System.out.println("#"+test_case);
			System.out.println(result);		
		}

	}

}
