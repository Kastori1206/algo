package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 카드2
 * https://www.acmicpc.net/problem/2164
 */
public class baek2164 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int index = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i =1;i<=N;i++) {
			q.add(i);
		}
		
		while(true) {
			if(q.size()==1) {
				System.out.println(q.poll());
				return;
			}
			if(index%2==0) {
				q.poll();
			}else {
				q.add(q.poll());
			}
			index++;
		}
	}
}
