package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek1697 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		boolean[] check = new boolean[1000001];
		int[] map = new int[1000001];
		int size = map.length;
		check[n] = true;
		map[n] = 0;
		 Queue<Integer> q = new LinkedList<Integer>();
	        q.add(n);
	        while (!q.isEmpty()) {
	            int now = q.remove();
	            if (now-1 >= 0) {
	                if (check[now-1] == false) {
	                    q.add(now-1);
	                    check[now-1] = true;
	                    map[now-1] = map[now] + 1;
	                }
	            }
	            if (now+1 < size-1) {
	                if (check[now+1] == false) {
	                    q.add(now+1);
	                    check[now+1] = true;
	                    map[now+1] = map[now] + 1;
	                }
	            }
	            if (now*2 < size-1) {
	                if (check[now*2] == false) {
	                    q.add(now*2);
	                    check[now*2] = true;
	                    map[now*2] = map[now] + 1;
	                }
	            }
	        }
	        System.out.println(map[k]);
	}	
}
