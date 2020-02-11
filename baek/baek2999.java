package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baek2999 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine(); 
		int size = str.length();
		int r = 0; int c = 0;
		for(int i =10; i>=1;i--) {
			if(size%i==0) {
				r= i ;
				c = size/i;				
				if(r<=c) {
					break;
				}
			}
		}
		int k = 0;
		char[][] arr  = new char[r][c];
		for(int i =0;i<c;i++) {
			for(int j =0;j<r;j++){
				arr[j][i] =  str.charAt(k++);
			}
		}
		
		for(int i =0;i<r;i++) {
			for(int j =0;j<c;j++){
				System.out.print(arr[i][j]);
			}
		}
		System.out.println();
	}
}
