package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea1233 {	
	static Queue<Character> q ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t =1;t<=10;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char[] tree = new char[N+1];			
			q = new LinkedList<Character>();
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
			}
			
			postOrder(tree, 1);
			
			char a = q.poll();
			char b = q.poll();
			char c = q.poll();
			boolean flag = true;
			if(calc(a,b,c)==1) {
				while(!q.isEmpty()) {
					b = q.poll();
					c =q.poll();
					if(calc(a,b,c)==0) {
						flag =false;
						break;
					}
				}
			}
			if(flag) {
				System.out.println(String.format("#%d 1",t));
			}else {
				System.out.println(String.format("#%d 0",t));
			}			
		}
	}
	
	static void postOrder(char[] tree,int index) {
		if(index >=tree.length) {
			return;
		}
		postOrder(tree, index*2);
		q.offer(tree[index]);
		postOrder(tree, index*2+1);
	}
	static int calc(char a, char b, char c) {
		if(Character.isDigit(a) && Character.isDigit(c) && !Character.isDigit(b)) {
			return 1;
		}else {
			return 0;
		}	
	}
}
