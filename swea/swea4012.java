package swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 4012.[모의 sw 역량테스트] 요리사
 */
public class swea4012 {
	static int[][] map;
	static boolean[] v;
	static int N, result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1;t<=T;t++) {
			N = sc.nextInt();
			map = new int[N][N];
			v = new boolean[N];
			result = Integer.MAX_VALUE;			
			for(int i =0;i<N;i++) {
				for(int j =0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			combination(N,N/2);
			
			System.out.printf("#%d %d\n",t,result);
		}
	}
	static void combination(int n, int r) {
		if(n<r) {
			return;
		}
		if(r ==0) {
			int sum1 = 0;
			int sum2 = 0;
			List<Integer>list1 = new ArrayList<>();
			List<Integer>list2 = new ArrayList<>();

			for(int i=0;i<N;i++) {				
				if(v[i]) {
					list1.add(i);
				}else {
					list2.add(i);
				}
			}
			for(int i =0;i<list1.size();i++) {
				for(int j=i+1;j<list1.size();j++) {
					sum1 += map[list1.get(i)][list1.get(j)];
					sum2 += map[list2.get(i)][list2.get(j)];
					sum1 += map[list1.get(j)][list1.get(i)];
					sum2 += map[list2.get(j)][list2.get(i)];
				}
			}
			result = Math.min(result, Math.abs(sum1-sum2));
			return;
		}
		v[n-1] = true;
		combination(n-1, r-1);		
		v[n-1 ] = false; 
		//비선택
		combination(n-1, r);
		
	}
	
}
