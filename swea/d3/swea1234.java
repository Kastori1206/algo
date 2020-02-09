package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea1234 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		for(int t = 1;t<=10;t++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			Stack<Integer> stack = new Stack<>();
			String num = st.nextToken();
			for(int i=0;i<N;i++) {
				int temp = num.charAt(i)-'0';
				if(stack.isEmpty()) {
					stack.push(temp);
					continue;
				}
				if(stack.peek() == temp) {
					stack.pop();
				}else {
					stack.push(temp);
				}				
			}
			StringBuffer sb = new StringBuffer();
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			sb.reverse();
			System.out.println(String.format("#%d %s", t,sb.toString()));
		}
	}	
}
