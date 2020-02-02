package baek;

import java.util.Scanner;

public class baek15650 {
	static boolean[] c;
	static int[] a;
	static void go(int start, int index, int n, int m) {//start 중복된수를 제거하기위해
		if (index == m) {
			for (int i=0; i<m; i++) {
				System.out.print(a[i]);
				if (i != m-1){
					System.out.print(' ');  
				} 
			}
			System.out.println();
			return;
		}
   		for (int i=start; i<=n; i++) {
			if (c[i]) {
				continue;
			}
			c[i] = true;
			a[index] = i;
			go(i+1,index+1, n, m); 
			c[i] = false;
		}
	}
	static void go2(int index, int selected, int n, int m) {
		if(index == m) {
			for(int i =0;i<m;i++) {
				System.out.print(a[i]);
				if(i!=m-1) {
					System.out.print(' ');
				}
			}
			System.out.println();
			return;
		}
		if(index >n) {
			return;
		}
		a[selected] = index;
		go2(index+1,selected+1,n,m);
		a[selected] = 0;
		go2(index+1,selected,n,m);		
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		c = new boolean[n+1];
		a = new int[n+1];

		go(1,0,n,m);
	}
}
