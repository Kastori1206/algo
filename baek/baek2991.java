package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2991 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[4];
		int[] brr = new int[3];
		//개
		for(int i =0;i<4;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int n1 = arr[0]+arr[1];
		int n2 = arr[2]+arr[3];
		
		//사람
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<3;i++) {
			brr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i =0;i<3;i++) {
			int cnt =0;
			if(brr[i]%n1!=0) {
				if(brr[i]%n1<=arr[0]) {
					cnt++;
				}
			}
			if(brr[i]%n2!=0) {
				if(brr[i]%n2<=arr[2]) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		
		
		
	}
}
