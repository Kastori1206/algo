package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 문자열 제곱
 * https://www.acmicpc.net/problem/4354
 */
public class baek4354 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        while(true){
            String s = br.readLine();
            if(s.equals(".")){
                break;
            }
            int[] pi = getPi(s);
            if (s.length() % (s.length() - pi[s.length() - 1] )!= 0) {
                answer.append("1\n");
            }else{
                answer.append(s.length()/(s.length() - pi[s.length()-1])+"\n");
            }
        }
        System.out.print(answer.toString());

    }
    public static int[] getPi(String pattern) {
        int m = pattern.length();
        int j = 0;
        char[] p = new char[m];
        int[] pi = new int[m];

        p = pattern.toCharArray();
        for (int i = 1; i < m; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = pi[j - 1];
            }
            if (p[i] == p[j]) {
                pi[i] = ++j;
            }
        }
        return pi;

    }



}
