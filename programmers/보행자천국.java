package programmers;

/*
 * 보행자 천국
 * https://programmers.co.kr/learn/courses/30/lessons/1832?language=java
 */
public class 보행자천국 {
	public static void main(String[] args) {
		System.out.println(solution(3, 3, new int[][]{
			{0,0,0},
			{0,0,0},
			{0,0,0}
		}));
	}
	static int MOD = 20170805;
    public static int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2];
        
        for(int r =0;r<m;r++) {
        	if(cityMap[r][0] ==1) {
        		break;
        	}
        	dp[r][0][0] = 1;
        }
        for(int c =0;c<n;c++) {
        	if(cityMap[0][c] ==1) {
        		break;
        	}
        	dp[0][c][1] =1;
        }
        
        for(int r = 1;r<m;r++) {
        	for(int c =1;c<n;c++) {
        		
        		if(cityMap[r][c]==1) {
        			continue; 
        	
        		}
        		if(cityMap[r][c] ==1) {
        			continue;
        		}else if(cityMap[r-1][c] ==0) {
        			dp[r][c][0] = (dp[r][c][0] + dp[r-1][c][0] + dp[r-1][c][1]) %MOD;
        		}else {
        			dp[r][c][0] = (dp[r][c][0] + dp[r-1][c][0]) %MOD;
        		}
        		
        		if(cityMap[r][c-1] ==1) {
        			continue;
        		}else if(cityMap[r][c-1] == 0) {
        			dp[r][c][1] = (dp[r][c][1] + dp[r][c-1][0] + dp[r][c-1][1]) %MOD;
        		}else {
        			dp[r][c][1] = (dp[r][c][1] + dp[r][c-1][1]) %MOD;
        		}
        	}
        }
        return (dp[m-1][n-1][0] + dp[m-1][n-1][1])%MOD;
    }
}
