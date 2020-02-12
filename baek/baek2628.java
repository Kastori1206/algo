package baek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class baek2628 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int t = sc.nextInt();
		ArrayList<Integer> row = new ArrayList<Integer>();
		ArrayList<Integer> col = new ArrayList<Integer>();
		row.add(0);
		col.add(0);
		for(int i=0;i<t;i++) {
			int c = sc.nextInt();			
			int num = sc.nextInt();
			if(c==1) {
				row.add(num);
			}else {
				col.add(num);
			}
		}
		row.add(N);
		col.add(M);
		Collections.sort(row);
		Collections.sort(col);
		int max = Integer.MIN_VALUE;
		int x=0,y=0;
		for(int i=1;i<col.size();i++) {			
			y = col.get(i)-col.get(i-1);
			
			for(int j=1;j<row.size();j++) {		
				x = row.get(j)-row.get(j-1);
				
				if(x*y >max) {
					max = x*y;
				}
			}
		}
	
		System.out.println(max);
	}
}
