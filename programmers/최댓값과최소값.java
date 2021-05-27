package programmers;

import java.util.StringTokenizer;

/*
 * 최댓값과 최솟값
 * https://programmers.co.kr/learn/courses/30/lessons/12939
 */
public class 최댓값과최소값 {
	public static void main(String[] args) {
		System.out.print(solution("1 2 3 4"));
	}
    public static String solution(String s) {
    	String answer = "";
    	StringTokenizer st = new StringTokenizer(s);
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	
    	while(st.hasMoreTokens()) {
    		int num = Integer.parseInt(st.nextToken());
    		min = Math.min(min, num);
    		max = Math.max(max,num);
    	}
    	answer = min + " " + max;
    	return answer;
    }
}
