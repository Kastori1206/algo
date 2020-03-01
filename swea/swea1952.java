package swea;

import java.util.Scanner;

/*
 * 1952.[모의 sw역량테스트] 수영장
 * 
 */
public class swea1952 {
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1;t<=T;t++) {
			int[] free = new int[4];
			for(int i =0;i<4;i++) {
				free[i] = sc.nextInt();
			}
			min = free[3];
			int[] days = new int[12];
			
			for(int i=0;i<12;i++) {
				days[i] = sc.nextInt();				
			}
			
			dfs(free,days,0,0);
			System.out.println(String.format("#%d %d", t,min));			
			
		}//test_case
	}//main
	static void dfs(int[] free, int[] days, int day, int sum) {
		if(day >=12) {
			min = Math.min(min, sum);
			return;
		}
		
		if(days[day] ==0) {
			dfs(free,days,day+1,sum);
		}else {
			dfs(free,days,day+1,sum+(days[day]*free[0]));
			dfs(free,days,day+1,sum+free[1]);
			dfs(free,days,day+3,sum+free[2]);			
		}
	}
}
