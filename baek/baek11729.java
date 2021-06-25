package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 하노이 탑 이동순서
 * https://acmicpc.net/problem/11729
 */
public class baek11729 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        answer.append((1<<N)-1).append("\n");
        dfs(N,1,3,answer);

        System.out.println(answer.toString());
    }


    public static void dfs(int n, int from, int to, StringBuilder sb) {
        if(n==0){
            return;
        }
        dfs(n-1,from,6-from-to,sb);
        sb.append(from+ " "+ to+ "\n");
        dfs(n-1,6-from-to,to,sb);
    }
}
