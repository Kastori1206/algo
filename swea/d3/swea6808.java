package swea.d3;

import java.util.ArrayList;
import java.util.Scanner;

public class swea6808 {
	static int win;
	static int lose;
	static int[] a;
	public static void main(String args[]) throws Exception	{		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();		
		
		for(int test_case = 1; test_case <= T; test_case++)	{
			ArrayList<Integer> list1 = new ArrayList<>(); //규영
			ArrayList<Integer> list2 = new ArrayList<>(); //인영
			
			boolean[] v = new boolean[9];
			win = 0;
			lose = 0;
			
			for(int i =0;i<9;i++) {
				list1.add(sc.nextInt());
			}
		
			for(int i = 1; i < 19; i++) {
				if(!list1.contains(i)) {
					list2.add(i);
				}
			}
			
			dfs(v,list1,list2,0,0,0);
			System.out.println(String.format("#%d %d %d", test_case, win, lose));
		}
	}
	static void dfs(boolean[] v,ArrayList<Integer> list1, ArrayList<Integer> list2, int idx, int sum1,int sum2) {
		if(idx == 9) {
			if(sum1 < sum2) {
				lose++;
			}else if(sum1>sum2) {
				win++;
			}
			return;
		}
		
		for(int i =0;i<9;i++) {
			if(v[i]) {
				continue;
			}
			int num1 = list1.get(idx);
			int num2 = list2.get(i);
			if(num1>num2) {
				sum1 += num1+num2;
			}else if(num1 < num2) {
				sum2 += (num1+num2);
			}
			v[i] = true;
			a[idx]= i;
			dfs(v,list1, list2, idx+1,sum1,sum2);
			if(num1>num2) {
				sum1 -= num1+num2;
			}else if(num1 < num2) {
				sum2 -= (num1+num2);
			}			
			v[i] = false;
		}
	}
}
