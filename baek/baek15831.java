package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 준표의 조약돌
 * https://www.acmicpc.net/problem/15831
 */
public class baek15831 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        int l = 0, r = 0, b = 0, w = 0;
        int answer = 0;

        while (l < N) {
            if (r < N && arr[r++] == 'W') {
                w++;
            } else {
                b++;
            }

            if (b <= B && w >= W) {
                answer = Math.max(answer, r - l);
            } else if (b > B) {
                if (arr[l++] == 'W') {
                    w--;
                } else {
                    b--;
                }
            }
        }
        System.out.println(answer);
    }
}
