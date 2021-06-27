package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 별찍기 - 11
 * https://www.acmicpc.net/problem/2448
 */
public class baek2448 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] answer = new String[N];
		answer[0] = "  *  ";
        answer[1] = " * * ";
        answer[2] = "*****";
         
        for (int k = 1; 3 * (int)Math.pow(2, k) <= N; ++k) {
            go(k, answer);
        }
         
        for (int i = 0; i < N; ++i) {
            System.out.println(answer[i]);
        }
	}

	public static void go(int k, String[] answer) {
		int bottom = 3*(int)Math.pow(2, k);
		int mid = bottom / 2;
		
		for(int i =mid; i<bottom; i++) {
			answer[i] = answer[i- mid] + " " + answer[i-mid];
		}
		
		String space = "";
		for(int i =0;i<mid;i++) {
			space+=" ";
		}
		for(int i =0;i<mid;i++) {
			answer[i] = space + answer[i] + space;
		}
	}
}
