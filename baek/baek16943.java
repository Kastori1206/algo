package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 숫자 재배치
 * https://www.acmicpc.net/problem/16943
 */
public class baek16943 {
    static int answer;
    static int[] A;
    static int B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String inputA = st.nextToken();
        B = Integer.parseInt(st.nextToken());
        A = new int[inputA.length()];

        for (int i = 0; i < inputA.length(); i++) {
            A[i] = inputA.charAt(i) - '0';
        }

        Arrays.sort(A);
        answer = -1;

        permu(0, A.length, A.length);

        System.out.println(answer);
    }

    static void permu(int depth, int n, int r) {
        if (depth == r) {
            int a = getNum();
            System.out.println(a);
            if (A[0] !=0 && a <= B) {
                answer = Math.max(answer, a);
            }
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(i, depth);
            permu(depth + 1, n, r);
            swap(i,depth);
        }
    }

    static void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static int getNum() {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res = res * 10 + A[i];
        }
        return res;
    }
}
