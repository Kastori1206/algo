package programmers;

import java.util.Arrays;

/*
 * 단속카메라
 * https://programmers.co.kr/learn/courses/30/lessons/42884
 */
public class 단속카메라 {
	public static void main(String[] args) {
		int[][] routes = new int[][] {
			{-20,15},
			{-14,5},
			{-18,-13},
			{-5,-3}									
		};
		System.out.println(solution(routes));
	}

	static public int solution(int[][] routes) {
		int answer = 0;
		int index = -30001; //카메라 위치
		
		//먼저 나간 차량으로 정렬
		Arrays.sort(routes, (x,y)->Integer.compare(x[1], y[1]));
		
		for(int[] route : routes) {
			//설치한 카메라에 걸리는지 체크
			if(index< route[0]) {
				index = route[1];
				answer++;
			}
		}
		return answer;
	}
}
