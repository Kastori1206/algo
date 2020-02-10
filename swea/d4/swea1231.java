package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1231 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
	
		for(int t = 1 ;t<=10;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			char[] tree = new char[N+1];
			
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
			}
			
			//답 출력
			System.out.print("#"+t+" ");
			inOrder(tree, 1);
			System.out.println();
		}
		
	}
	static void inOrder(char[] tree, int index) {
		if(index>=tree.length) {
			return;
		}
		inOrder(tree,index*2);
		System.out.print(tree[index]);
		inOrder(tree,index*2+1);
	}
}
