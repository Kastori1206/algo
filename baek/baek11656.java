package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 접미사 배열
 * https://www.acmicpc.net/problem/11656
 */
public class baek11656 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int N = S.length();
        StringBuilder sb = new StringBuilder();
        String[] answer = new String[N];
        for(int i =N-1; i>=0;i--){
            sb.insert(0,S.charAt(i));
            answer[i] = sb.toString();
        }

        Arrays.sort(answer);
        sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
