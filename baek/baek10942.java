package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 팰린드롬?
 * https://www.acmicpc.net/problem/10942
 */
public class baek10942 {
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      StringBuilder answer = new StringBuilder();
      int N = Integer.parseInt(br.readLine());
      boolean[][] dp = new boolean[N+1][N+1];
      int[] arr = new int[N+1];
      
      st = new StringTokenizer(br.readLine());
      for(int i =1;i<=N;i++) {
         arr[i] = Integer.parseInt(st.nextToken());         
      }
      
      for(int i =1;i<=N;i++) {
    	  dp[i][i] = true;
    	  if(arr[i] == arr[i-1]) {
    		  dp[i-1][i] = true;
    	  }
      }
      
      for(int i=2;i<=N-1;i++) {
    	  for(int j=1;j<=N-i;j++) {
    		  if(arr[j]==arr[j+i] && dp[j+1][j+i-1]) {
    			  dp[j][j+i] = true;
    		  }
    	  }
      }
      
      int M = Integer.parseInt(br.readLine());
      for(int i =0;i<M;i++) {
         st = new StringTokenizer(br.readLine());
         int start = Integer.parseInt(st.nextToken());
         int end = Integer.parseInt(st.nextToken());
                  
         if(dp[start][end]) {
        	 answer.append(1);
         }else {
        	 answer.append(0);
         }
         answer.append("\n");
      }
      System.out.println(answer.toString());
   }
}