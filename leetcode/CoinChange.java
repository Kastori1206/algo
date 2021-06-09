package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {
	public static void main(String[] args) {
		System.out.println(coinChange(new int[] {1, 2,5},11));
		System.out.println(coinChange(new int[] {2},3));
		System.out.println(coinChange(new int[] {1,2147483647},2));
	}
	public static int coinChange(int[] coins, int amount) {
		int answer = 0;
		if(amount==0) {
			return 0;
		}
		int[] dp = new int[10000+1];
		Queue<Integer> q = new LinkedList<>();
		List<Integer> newCoins = new ArrayList<>();
		for(int i =0;i<coins.length;i++) {
			int coin = coins[i];
            if(coin <=amount){
                dp[coin] = 1;
                newCoins.add(coin);
                q.add(coin);    
            }
		}
		
		while(!q.isEmpty()) {
			int coin = q.poll();			
			for(int i =0 ;i <newCoins.size();i++) {
				int next = coin + newCoins.get(i);
				
				if(next <= amount && dp[next] ==0) {
					dp[next] = dp[coin]+1;
					q.add(next);
				}				
			}
		}
		answer = dp[amount] == 0 ? -1 : dp[amount];
		return answer;
	}
}
