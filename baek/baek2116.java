package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2116 {
	static boolean[][] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result =0;	
		
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][6];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int temp;
		for(int i=0;i<6;i++) {
			v= new boolean[N][6];
			temp = findIndex(arr, arr[0][i], 0);
			for(int j=1;j<N;j++) {
				temp = findIndex(arr, arr[j-1][temp], j);
				//System.out.println(temp);
			}		
			int sum = 0;
			for(int k =0;k<N;k++) {
				int max = Integer.MIN_VALUE;
				for(int l=0;l<6;l++) {
					if(v[k][l]) {
						continue;
					}
					if(max<arr[k][l]) {
						max =arr[k][l]; 
					}
					
				}				
				sum+=max;
			}
			if(sum>result) {
				result = sum;
			}
		}
		
		
		System.out.println(result);
		
	}
	static int findIndex(int[][]arr,int x,int i) {
		for(int j=0;j<6;j++) {
			if(x == arr[i][j]) {
				int temp = rIndex(j);
				v[i][j] = true;
				v[i][temp] = true;
				return temp;
			}
		}		
		return -1;
	}
	static int rIndex(int i) {
		if(i==0) {
			return 5;
		}
		if(i==1) {
			return 3;
		}
		if(i==2) {
			return 4;
		}
		if(i==3) {
			return 1;
		}
		if(i==4) {
			return 2;
		}
		if(i==5) {
			return 0;
		}
		return -1;
	}
	
	static void print(int N) {
		for(int i =0;i<N;i++) {
			for(int j =0;j<6;j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
	}
}
