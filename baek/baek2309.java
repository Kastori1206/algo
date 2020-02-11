package baek;

import java.util.Arrays;
import java.util.Scanner;

public class baek2309 {
	static boolean[] c;
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[]arr = new int[9];
		c = new boolean[9];
		result = new int[7];
		
		for(int i =0;i<9;i++) {
			arr[i] = sc.nextInt();
		}
		go(arr,0,0,0);
	
		Arrays.sort(result);
		for(int i=0;i<7;i++) {
			System.out.println(result[i]);
		}
		
	}
	static void go(int[] arr, int index,int start,int sum) {
		if(index==7&&sum==100) {	
			
			int k=0;
			for(int i=0;i<9;i++) {
				if(c[i]) {
					result[k] = arr[i];
					k++;
				}
			}
			return;
		}
		
		for(int i=start;i<arr.length;i++) {
			if(c[i]) {
				continue;
			}
			c[i] = true;
			sum +=arr[i];			
			go(arr,index+1,i+1,sum);			
			sum-=arr[i];
			c[i]=false;
		}
	}
}
