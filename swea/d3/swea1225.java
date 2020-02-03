package swea.d3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea1225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int T;
		int N = 8;
		for(int test_case = 1; test_case <= 10; test_case++){
			T=sc.nextInt();
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int i =0;i<N;i++) {
				q.offer(sc.nextInt());
			}
			
			int i =1;
			while(true) {
				if(i>5) { 
					i = 1;
				}
				int num = q.poll();				
				if(num-i<=0) {
					q.offer(0);
					break;
				}				
				q.offer(num-i);			
				i++;
			}
			
			//큐에 있는 값 출력
			Iterator<Integer> it = q.iterator();
			System.out.print("#"+T +" ");
			while(it.hasNext()) {
				System.out.print(it.next()+" ");
			}
			System.out.println();
		}
	}
}
