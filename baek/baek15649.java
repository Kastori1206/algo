package baek;

import java.util.Scanner;

public class baek15649 {
	  static boolean[] c;
	  static int[] a;
	  static void go(int index, int n, int m) {
	        if (index == m) {
	            for (int i=0; i<m; i++) {
	                System.out.print(a[i]);
	                if (i != m-1) {
	                	System.out.print(' ');
	                }
	            }
	            System.out.println();
	            return;
	        }
	        for (int i=1; i<=n; i++) {
	            if (c[i]) {
	            	continue;
	            }
	            c[i] = true;
	            a[index] = i;
	            go(index+1, n, m);
	            c[i] = false;
	        }
	    }   
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
        int m = sc.nextInt();
		
		c = new boolean[n+1];
		a = new int[n+1];
		
		go(0,n,m);
		
		
	}
}
