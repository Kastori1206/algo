package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1592 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());		
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		
		go(arr,1,N,M,L,0);
		
	}
	
	static void go(int[]arr, int index, int N, int M, int L,int cnt) {
		arr[index] ++;
		if(arr[index] == M) {
			System.out.println(cnt);
			return;
		}		
		if(arr[index]%2 ==1) {
			index += L;
			if(index >N) {
				index -= N;
			}
			go(arr,index,N,M,L,cnt+1);
		}else {
			index -= L;
			if(index <1) {
				index += N;
			}
			go(arr,index,N,M,L,cnt+1);
		}
	}
}
