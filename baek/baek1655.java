package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 가운데를 말해요
 * https://www.acmicpc.net/problem/1655
 */
public class baek1655 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(min);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(max);
		
	
		for(int i =0;i<N;i++) {			
			int num = Integer.parseInt(br.readLine());
			
			if(minHeap.size() == maxHeap.size()) {
				maxHeap.offer(num);
			}else {
				minHeap.offer(num);
			}
			
			if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
				if(minHeap.peek() < maxHeap.peek()) {
					int temp = minHeap.poll();
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(temp);
				}
			}
			sb.append(maxHeap.peek()).append("\n");
		}		
		System.out.println(sb.toString());
	}
	private static Comparator<Integer> max = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			
			return -Integer.compare(o1, o2);
		}
	};
	private static Comparator<Integer> min = new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			
			return Integer.compare(o1, o2);
		}
	};
}
