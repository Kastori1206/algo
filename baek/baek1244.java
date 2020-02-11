package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1244 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[]arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i =1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(st.nextToken());
		
		//1: 남학생 2: 여학생
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			
			if(c==1) {
				
			}else {
				
			}
		}
		
		
		for(int i =1 ;i<=N;i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
}
