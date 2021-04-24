package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 기능개발
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 */
public class 기능개발 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {93, 30, 55}, new int[] {1, 30, 5})));
		System.out.println(Arrays.toString(solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1})));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		List<Integer> list = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < progresses.length; i++) {
			//기능이 완료되는 일수 구하기
			int day = 	(100-progresses[i]) % speeds[i]==0? 
						(100-progresses[i])/speeds[i] : 
						(100-progresses[i]) / speeds[i] +1;			
			q.offer(day);
		}
		int cnt = 1;
		int preday = q.poll();
		while (!q.isEmpty()) {
			int curday = q.poll();
			if (preday < curday) {
				list.add(cnt);
				cnt = 1;
				preday = curday;
			} else {				
				cnt++;
			}
		}
		//마지막 걸린 일수
		list.add(cnt);
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
