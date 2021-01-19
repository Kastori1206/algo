package baek;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * DSLR
 * https://www.acmicpc.net/problem/9019
 */
public class baek9019 {	
	static boolean[] visited;
	static class DSLR{
		int num;
		String answer;
		
		public DSLR(int num, String answer) {
			super();
			this.num = num;
			this.answer = answer;
		}

		@Override
		public String toString() {
			return "DSLR [num=" + num + ", answer=" + answer + "]";
		}		
	}
	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
					
			visited = new boolean[10000];
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			bfs(new DSLR(A,""), B);
		}
	}
	private static void bfs(DSLR A,int B) {
		Queue<DSLR> q = new LinkedList<>();
		q.add(A);
		visited[A.num] = true;
		while(!q.isEmpty()) {
			DSLR dslr = q.poll();	

			if(dslr.num == B) {
				System.out.println(dslr.answer);
				return;
			}
		
			for(int c=0;c<4;c++) {			
				DSLR temp = command(c,dslr);
				if(visited[temp.num]) {
					continue;					 
				}
				visited[temp.num] = true;
				q.add(new DSLR(temp.num, temp.answer));
			}
			
		}
	}
	private static DSLR command(int c, DSLR dslr) {
		int num = dslr.num;
		String answer = dslr.answer;
		switch(c) {
			//D
			case 0:				
				num = (num*2) %10000;
				answer+= "D";
				break;
			//S
			case 1:	
				num = num ==0 ? 9999: num-1;
				answer+= "S";
				break;
			//L
			case 2:
				num = num/1000 + ((num%1000) *10);
				
				answer+= "L";
				break;
			//R
			case 3:
				num = (num %10)* 1000 + (num/10);
				answer+= "R";
				break;
		}
		
		DSLR result = new DSLR(num,answer);
		return result;
		
	}
}
