package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2798 {
	static int[] arr ;
	static int max;
	static boolean[] c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		c = new boolean[N];
		max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		go(0,0,0,M);
	
		System.out.println(max);
		
	}
	static void go(int start, int index, int sum, int m) {
		if(sum>m) {
			return;
		}
		if (index == 3) {				
			if(max < sum) {
				max = sum;
			}			
			return;
		}	
		
   		for (int i=start; i<arr.length; i++) {
			if (c[i]) {
				continue;
			}
			c[i] = true;
			sum+= arr[i];			
			go(i+1,index+1, sum, m);
			sum -= arr[i];
			c[i] = false;
		}
	}

}
