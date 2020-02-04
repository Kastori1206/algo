package swea.d3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class swea6808_2 {
	static int win, lose;
	static int[] numbers1, numbers2;
	static int N=9;
	public static void main(String[] args) throws Exception{
		Scanner sc  = new Scanner(System.in);
		int T = sc.nextInt();
		numbers1 = new int[N]; 
		numbers2 = new int[N]; 
		int[] card = new int[19];
		int data;
		for (int testcase = 1; testcase <= T; testcase++) {
			
			for (int i = 0; i <N; i++) {
				data = sc.nextInt();
				card[data] = 1;
				numbers1[i] = data;
			}
			data=0;
			for (int i = 1, size = card.length; i <size; i++) {
				if(card[i]==0) {
					numbers2[data++]= i;
				}
			}
			dfs(0, 0, 0, 0);
			System.out.println("#"+testcase+" "+win+" "+lose);
			//초기화
			win=0;
			lose=0;
			Arrays.fill(card, 0);
		}
	}
	public static void dfs(int cnt, long flag, int guSum, int inSum) {
		if(cnt == N) {
			if(guSum>inSum) {
				win++;
			}else {
				lose++;
			}
			return;
		}
		int guCard, inCard;
		for (int i = 1; i <= N; i++) {
			if( (flag &(long)1<<i) == 0) {
			 guCard = numbers1[cnt];
			 inCard = numbers2[i-1];
			 if(guCard>inCard) {
				 dfs(cnt+1, flag | (long)1<<i, guSum+inCard+guCard, inSum);
			 }else {
				 dfs(cnt+1, flag | (long)1<<i, guSum, inSum+inCard+guCard);
			 }
			}
		}
	}
}
