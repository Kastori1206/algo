package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 종이의 개수
 * https://www.acmicpc.net/problem/1780
 */
public class baek1780 {
    static int N;
    static int[] answer;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        answer = new int[3];
        arr = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, N);
        for (int i = 0; i < 3; i++) {
            bw.write(answer[i]+"\n");
        }
        bw.close();
        br.close();
    }

    public static void dfs(int r, int c, int size) {
        if (check(r, c, size)) {
            answer[arr[r][c] + 1]++;
            return;
        }
        int nSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dfs(r + nSize * i, c + nSize * j, nSize);
            }
        }

    }

    public static boolean check(int r, int c, int size) {
        int init = arr[r][c];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[r + i][c + j] != init) {
                    return false;
                }
            }
        }
        return true;
    }
}


/*
9
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
0 1 -1 0 1 -1 0 1 -1
0 -1 1 0 1 -1 0 1 -1
0 1 -1 1 0 -1 0 1 -1


 */