package swea.d4;

import java.util.Stack;
import java.util.Scanner;

public class swea1124{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	

		for(int test_case = 1; test_case <= 10; test_case++){
			int N = sc.nextInt();
			String str = sc.next();
			String result = doPostOrder(str);
			System.out.println("#"+test_case+" "+doCalc(result));
		}

	}
	
	static int doCalc(String str) {
		char[] c =str.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(char ch : c) {
			if(ch>= '0' && ch<='9') {//Character.isDigit(ch)
				int n = ch-'0';//Integer.parseInt(ch+"");
				stack.push(n);
			}else {
				int b = stack.pop();
				int a = stack.pop();
				
				if(ch=='+') {
					stack.push(a+b);						
				}else if(ch=='*') {
					stack.push(a*b);
				}
			}
		}		
		
		return stack.pop();
	}
	
	static String doPostOrder(String s) {
		String result = "";
		char[] crr = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(char ch : crr) {
			if(ch=='(') {
				stack.push(ch);
			}else if(ch>='0' && ch<='9') {
				result+=ch;
			}else if(ch==')') {
				char temp;
				while(!stack.isEmpty()) {
					temp = stack.pop();
					if(temp=='(') {
						break;
					}
					result += temp;
				}
			}else {
				while(!stack.isEmpty()) {
					if(getPriority(ch) <= getPriority(stack.peek())) {
						result += stack.pop();
					}else {
						break;
					}
				}
				stack.push(ch);
			}
		}
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
	}

	static int getPriority(char ch) {
		int result = 0;
		switch(ch) {
		case '+':   
			result = 1;
			break;		
		case '*':   
			result = 2;
			break;
		}
		return result;
	}
}