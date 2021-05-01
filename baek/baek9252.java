package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * LCS 2
 * https://www.acmicpc.net/problem/9252
 */
public class baek9252 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int r = a.length();
        int c = b.length();
        int[][] dp =  new int[r+1][c+1];
        dp[0][0] = 0;
        for(int i =1;i<=r;i++){
            for(int j =1;j<=c;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[r][c]);
        String answer = "";
        while(dp[r][c] >0){
            if(dp[r-1][c] == dp[r][c]){
                r--;
            }else if(dp[r][c-1] == dp[r][c]){
                c--;
            }else{
                answer = a.charAt(r-1) + answer;
                r--;
                c--;
            }

        }

        System.out.println(answer);
    }

}
