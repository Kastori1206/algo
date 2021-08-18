package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 교수님 계산기가 고장났어요!
 * https://www.acmicpc.net/problem/22937
 */
public class baek22937 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t<T;t++){
            st = new StringTokenizer(br.readLine());
            char[] A = st.nextToken().toCharArray();
            char[] B = st.nextToken().toCharArray();

            boolean aFlag = A[0]== '-' ? true : false;
            boolean bFlag = B[0]== '-' ? true : false;


            int[][] pow = new int[9][20];
            int r = 0;
            for (int i = A.length - 1; i >= 0; i--) {
                if (check(A[i])) {
                    continue;
                }
                int c = 19-r;
                int round = 0;
                for (int j = B.length - 1; j >= 0; j--) {
                    if (check(B[i])) {
                        continue;
                    }
                    int aa = A[i] - '0';
                    int bb = B[i] - '0';

                    pow[r][c--] = (aa*bb)%10 + round;
                    round = (aa*bb)/10;

                }
                r++;
            }

            if(!(aFlag &bFlag)){
                answer.insert(0,'-');
            }
        }
        System.out.println(answer);

    }

    public static boolean check(char c) {
        return c == '.' || c == '-';
    }
}
