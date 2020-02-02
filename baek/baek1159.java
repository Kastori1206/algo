package baek;

import java.util.Scanner;

public class baek1159 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); 
		String[] a = new String[n];
		for(int i =0;i<n;i++) {
			a[i] = sc.next();
		}
		int[] b = new int[26];
		
		boolean flag = false;
		for(int i=0;i<n;i++) {
			b[a[i].charAt(0)-'a']++;
		}
		
		for(int i =0;i<26;i++) {
			if(b[i] >=5) {
				System.out.print((char)(i+'a'));
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("PREDAJA");
		}
	}
}
