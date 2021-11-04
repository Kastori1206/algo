package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 괄호 추가하기 2
 * https://www.acmicpc.net/problem/16638
 */
public class baek16638 {
	static class Expression{
		char ch;
		int priority; //숫자 0, +- 3 , * 2, 괄호 1
		protected Expression(char ch, int priority) {
			super();
			this.ch = ch;
			this.priority = priority;
		}
	}
	static Expression[] exp;
	static boolean[] brackets;
	static int N, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		exp = new Expression[N];
		brackets = new boolean[N];
		String str = br.readLine();
		for(int i = 0;i<N;i++) {
			char c = str.charAt(i);
			if(c=='+' || c=='-') {
				exp[i] = new Expression(c,3); 
			}else if(c=='*') {
				exp[i] = new Expression(c,2);
			}else {
				exp[i] = new Expression(c, 0);
			}
		}
		
		
		answer = Integer.MIN_VALUE;
		dfs(1);		
		
		System.out.println(answer);
	}

	public static int calc(int a, int b, char op) {
		int result = a;
		switch (op) {
		case '+':
			result += b;
			break;
		case '-':
			result -= b;
			break;
		case '*':
			result *= b;
			break;
		}
		return result;
	}

	public static void dfs(int idx) {
		if(idx >=N) {
			int res = getResult(getPostfix());
			answer = Math.max(answer, res);
			return;
		}
		
		if(idx == 1) {
			brackets[idx] = true;
			dfs(idx+2);
			brackets[idx] = false;
		}else if(!brackets[idx-2]) {
			brackets[idx] = true;
			dfs(idx +2);
			brackets[idx] = false;
		}
		dfs(idx+2);
	}
	
	//중위-> 후위표현식으로 변경
	static List<Expression> getPostfix(){
		List<Expression> postfix = new ArrayList<>();
		Stack<Expression> stack = new Stack<>();
		
		for(int i =0;i<N;i++) {
			if(exp[i].priority==0) {
				postfix.add(exp[i]);
			}else {
				int priority = exp[i].priority;
				if(brackets[i]) {
					priority = 1;
				}
				while(!stack.isEmpty() && stack.peek().priority <= priority) {
					postfix.add(stack.pop());
				}
				
				stack.push(new Expression(exp[i].ch, priority));
			}
		}
		while(!stack.isEmpty()) {
			postfix.add(stack.pop());
		}
		return postfix;
	}
	
	static int getResult(List<Expression> postfix) {
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i =0;i<N;i++) {
			if(postfix.get(i).priority==0) {
				stack.push(postfix.get(i).ch - '0');
			}else {
				int a = stack.pop();
				int b = stack.pop();
				res= calc(b, a, postfix.get(i).ch);
				stack.push(res);
			}
		}
		
		return stack.pop();
	}
}
