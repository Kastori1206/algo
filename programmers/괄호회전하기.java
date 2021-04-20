package programmers;

import java.util.Stack;

/*
 * 괄호 회전하기
 * https://programmers.co.kr/learn/courses/30/lessons/76502#
 */
public class 괄호회전하기 {
	public static void main(String[] args) {
		System.out.println(solution("[](){}"));
	}

	public static int solution(String s) {
		int answer = 0;
		int len = s.length();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < len; i++) {
			s = s.substring(1,len)+ s.substring(0,1);
			stack.clear();			
			for(char c : s.toCharArray()) {
				if (stack.isEmpty()) {
					stack.push(c);
				}else {					
					char temp = stack.peek();
					if (c == ')' && temp == '(') {
						stack.pop();
					} else if (c == ']' && temp == '[') {
						stack.pop();						
					} else if (c == '}' && temp == '{') {
						stack.pop();						
					}else {
						stack.push(c);
					}					
				}				
			}
			if(stack.isEmpty()) {
				answer++;
			}
		}
		return answer;
	}
}
