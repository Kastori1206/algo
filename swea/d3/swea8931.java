package swea.d3;

import java.util.Scanner;
import java.util.Stack;

public class swea8931 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1;test_case<=T;test_case++) {
			int K = sc.nextInt();
			int sum =0;
			Stack<Integer> st = new Stack<Integer>();
			for(int i =0;i<K;i++) {
				int n= sc.nextInt();
				if(n == 0) {
					st.pop();
					continue;
				}
				st.push(n);
			}
			while(!st.isEmpty()) {
				sum +=st.pop();
			}
			System.out.println(String.format("#%d %d", test_case,sum));
		}
	}

}
