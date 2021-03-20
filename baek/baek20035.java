package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek20035 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        long sum = 0;
        for(int i =1;i<=N;i++){
            int A = Integer.parseInt(st.nextToken())*1_000_000_000;
            for(int j =1;j<=M;j++){
                int B = Integer.parseInt(st1.nextToken());
                map[i][j] = A+B;
            }

        }


    }

}
