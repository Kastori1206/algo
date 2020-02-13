package jungol;

import java.util.Arrays;
import java.util.Scanner;

class C implements Comparable<C>{
	int x;
	int y;
	
	public int compareTo(C other) {
		return this.y - other.y;
	}
}
public class jungol1828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		C[] c = new C[N];
		for(int i=0;i<N;i++) {
			C temp = new C();
			temp.x= sc.nextInt();
			temp.y = sc.nextInt();
			c[i] = temp;
		}

		Arrays.sort(c);
		
		int cnt= 1;
		C temp = c[0];
		for(int i =1;i<N;i++) {
			if(temp.y < c[i].x) {
				temp = c[i];
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
