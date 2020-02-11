package baek;

import java.util.Scanner;

public class beak2851 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int[] arr = new int[10];
		
		for(int i =0;i<10;i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = arr[0];
		
		for(int i = 1;i<10;i++) {			
			if(Math.abs(sum-100) > Math.abs(arr[i]+sum -100)) {
				sum +=arr[i];
			}else {
				break;
			}
		}
		System.out.println(sum);
	}
}
