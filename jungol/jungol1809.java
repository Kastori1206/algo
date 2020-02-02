package jungol;

import java.util.Scanner;
import java.util.Stack;

//http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1082&sca=3020
class pair{
	int high;
	int idx;
	pair(int h, int i){
		high = h;
		idx = i;
	}
}

public class jungol1809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		
		
		Stack<pair> st = new Stack<pair>();
		int [] a = new int[N+1];
		for(int i =1;i<=N;i++) {
			int h = sc.nextInt();
			
			if(st.isEmpty()) {
				a[i] =0;

			}else {
				while(!st.empty()) {
					if(st.peek().high<h) {
						st.pop();
						if(st.isEmpty()) {
							a[i]=0;

						}
					}else {
						a[i] = st.peek().idx;

						break;
					}
				}
			}
			st.push(new pair(h,i));
		}

		for(int i =1;i<=N;i++) {
			System.out.print(a[i]+" ");
		}
		
	}
}
