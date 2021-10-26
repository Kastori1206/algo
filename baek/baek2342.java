package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Dance Dance Revolution
 * https://www.acmicpc.net/problem/2342
 */
public class baek2342 {
	static List<Integer> list;
	static int[][][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		
		while(true) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 0) {
				break;
			}
			list.add(num);
		}
		dp = new int[list.size()][5][5];
		
		System.out.println(dfs(0,0,0));
		
	}
	static int dfs(int idx, int left, int right) {
		if(idx == list.size()) {
			return 0;
		}
		if(dp[idx][left][right] != 0) {
			return dp[idx][left][right];
		}
		
		int l = dfs(idx+1, list.get(idx), right) + getDist(left, list.get(idx));
		int r = dfs(idx+1, left, list.get(idx)) + getDist(right, list.get(idx));
		dp[idx][left][right] = Math.min(l, r);
		return dp[idx][left][right];
	}
	static int getDist(int pre, int cur) {
		int temp = Math.abs(pre - cur);
		if(pre ==0) {
			return 2;
		}else if(temp ==0) {
			return 1;
		}else if(temp == 1) {
			return 3;
		}else {
			return 4;
		}		
	}
}
