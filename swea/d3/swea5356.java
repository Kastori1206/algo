package swea.d3;

import java.util.Scanner;

public class swea5356 {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			String result = "#" + test_case + " ";
			char[][] chars = new char[5][15];			
			int max = 0;
			for(int i =0;i<5;i++) {
				String data = sc.next();
				for(int j = 0;j<data.length();j++) {
					chars[i][j] = data.charAt(j);					
				}
				max = Math.max(max, data.length());			

			}
			for(int i =0;i<max;i++) {
				for(int j =0;j<5;j++) {
					if(chars[j][i] !='\u0000') {
						result += chars[j][i];
					}
				}
			}
			System.out.println(result);

		}
	}
}
