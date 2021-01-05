package codeforecs.div3.round693;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t =0; t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[2];

			st = new StringTokenizer(br.readLine());
			for(int i =0;i<n;i++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp ==1) {
					arr[0]++;
				}else {
					arr[1]++;
				}
			}
			
			if(arr[0]%2 != 0 && arr[1]%2 != 0) {
				System.out.println("NO");
			}else if(arr[0]%2 != 0 && arr[1] %2 ==0) {
				System.out.println("NO");
			}else if(arr[0] == 0 && arr[1]%2 != 0){
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
			
		}
		
	}
}
