package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class swea1970 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int[]a = {50000,10000,5000,1000,500,100,50,10};

		for(int test_case = 1; test_case <= T; test_case++){
			int N = Integer.parseInt(br.readLine());
			StringBuilder result = new StringBuilder();
			
			for(int i =0;i<a.length;i++){
				result.append(N / a[i]).append(" ");
				N%=a[i];
			}

			sb.append(String.format("#%d\n%s\n", test_case, result.toString()));
		}
		System.out.println(sb);
	}

}
