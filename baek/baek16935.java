package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열 돌리기 3
 * https://www.acmicpc.net/problem/16935
 */
public class baek16935 {
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            cmd(Integer.parseInt(st.nextToken()));
        }

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                answer.append(arr[r][c]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);

    }

    static void cmd(int value) {
        switch (value) {
            case 1:
                upDown();
                break;
            case 2:
                leftRigth();
                break;
            case 3:
                right();
                break;
            case 4:
                left();
                break;
            case 5:
                five();
                break;
            case 6:
                six();
                break;
        }
    }

    static void upDown() {
        int n = arr.length;
        int m = arr[0].length;
        for (int r = 0; r < n / 2; r++) {
            for (int c = 0; c < m; c++) {
                int temp = arr[r][c];
                arr[r][c] = arr[n - 1 - r][c];
                arr[n - 1 - r][c] = temp;
            }
        }
    }

    static void leftRigth() {
        int n = arr.length;
        int m = arr[0].length;
        for (int c = 0; c < m / 2; c++) {
            for (int r = 0; r < n; r++) {
                int temp = arr[r][c];
                arr[r][c] = arr[r][m - 1 - c];
                arr[r][m - 1 - c] = temp;
            }
        }
    }

    static void right() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] tempArr = new int[m][n];
        for (int r = 0; r < tempArr.length; r++) {
            for (int c = 0; c < tempArr[r].length; c++) {
                tempArr[r][c] = arr[n - 1 - c][r];
            }
        }

        arr = tempArr;
    }

    static void left() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] tempArr = new int[m][n];
        for (int r = 0; r < tempArr.length; r++) {
            for (int c = 0; c < tempArr[r].length; c++) {

                tempArr[r][c] = arr[c][m - 1 - r];

            }
        }

        arr = tempArr;
    }

    static void five() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] tempArr = new int[n][m];
        int rr = n / 2;
        int cc = m / 2;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                //1그룹
                if (r < rr && c < cc) {
                    tempArr[r][c] = arr[rr + r][c];
                }
                //2그룹
                else if (r < rr && c >= cc) {
                    tempArr[r][c] = arr[r][c - cc];
                }
                //3그룹
                else if (r >= rr && c >= cc) {
                    tempArr[r][c] = arr[r - rr][c];
                }
                //4그룹
                else {
                    tempArr[r][c] = arr[r][cc + c];
                }
            }
        }
        arr = tempArr;
    }

    static void six() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] tempArr = new int[n][m];
        int rr = n / 2;
        int cc = m / 2;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                //1그룹
                if (r < rr && c < cc) {
                    tempArr[r][c] = arr[r][cc + c];
                }
                //2그룹
                else if (r < rr && c >= cc) {
                    tempArr[r][c] = arr[rr + r][c];
                }
                //3그룹
                else if (r >= rr && c >= cc) {
                    tempArr[r][c] = arr[r][c - cc];
                }
                //4그룹
                else {
                    tempArr[r][c] = arr[r - rr][c];
                }
            }
        }
        arr = tempArr;
    }
}

