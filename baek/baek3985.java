package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek3985 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[L +1];
		int N = Integer.parseInt(st.nextToken());
		int[] a = new int[N+1];// 실제 케이크 조각수 
		int max = Integer.MIN_VALUE;
		int result = 0;
		int rMax = Integer.MIN_VALUE;
		for(int i =1;i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int Pi =  Integer.parseInt(st.nextToken());
			int Pk =  Integer.parseInt(st.nextToken());
			
			if(Pk-Pi > max) {
				max = Pk-Pi;
				result=i;
			}
			
			int cnt =0;
			for(int j = Pi ;j<=Pk;j++) {				
				if(arr[j]==0) {			
					cnt++;
					arr[j]=i;
				}
			}
			if(cnt>rMax) {
				rMax=cnt;
			}
			a[i] = cnt;
		}
	
		System.out.println(result);
		for(int i =1;i<=N;i++) {
			if(rMax==a[i]){
				System.out.println(i);
				break;
			}
		}		
	}
}
