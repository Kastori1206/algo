package programmers;

import java.util.PriorityQueue;

/*
 * 더 맵게
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class 더맵게 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
	}
	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i =0;i<scoville.length;i++) {
			pq.add(scoville[i]);
		}
		
		while(pq.size() >1) {
			int temp = pq.poll();
			if(temp>=K) {
				break;
			}
            
			pq.add(temp+(pq.poll()*2));
			answer++;			
		}
        answer = pq.peek() >=K ? answer: -1;
		
		return answer;
	}
}
