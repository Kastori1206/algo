package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1233 {
	static char[] result;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t =1;t<=10;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char[] tree = new char[N+1];
			result = new char[N+1];
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
			}
			cnt = 1;
			postOrder(tree, 1);
			for(int i=1;i<=N;i++) {				
				System.out.print(result[i] +" ");
			}
			System.out.println();
			
			
		}
	}
	
	static void postOrder(char[] tree,int index) {
		if(index >=tree.length) {
			return;
		}
		postOrder(tree, index*2);
		result[cnt++] = tree[index]; 
		postOrder(tree, index*2+1);
	}
	static int calc(char a, char b, char c) {
		if(Character.isDigit(a) && Character.isDigit(b) && !Character.isDigit(c)) {
			return 1;
		}else {
			return 2;
		}	
	}
}
