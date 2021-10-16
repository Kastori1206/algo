package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

/**
 * 게리맨더링 2
 * https://www.acmicpc.net/problem/17779
 */
public class baek17779 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];
        int answer = Integer.MAX_VALUE;

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        //기준점
        for (int x = 1; x < N; x++) {
            for (int y = 1; y < N; y++) {
                //d1 , d2
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if (x + d1 + d2 > N || y - d1 < 1 || y + d2 > N) {

                            continue;
                        }
                        int[][] arr = new int[N+1][N+1];
                        int[] res = new int[5];

                        for (int r = 1; r <= N; r++) {
                            for (int c = 1; c <= N; c++) {
                                //1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
                                if (r < x + d1 && c <= y) {
                                    arr[r][c] = 1;
                                }
                                //2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
                                else if (r <= x + d2 && y < c) {
                                    arr[r][c] = 2;
                                }
                                //3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
                                else if (x + d1 <= r && c < y - d1 + d2) {
                                    arr[r][c] =3;
                                }
                                //4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
                                else if (x + d2 < r && y - d1 + d2 <= c) {
                                    arr[r][c] = 4;
                                }
                            }
                        }

                        //5번 선거구
                        for (int i = 0; i <= d1; i++) {
                            arr[x+i][y-i] = 5;
                            arr[x+d2+i][y+d2-i] = 5;
                        }
                        for (int i = 0; i <= d2; i++) {
                            arr[x+i][y+i] = 5;
                            arr[x+d1+i][y-d1+i] = 5;
                        }

                        for (int i = 0; i < d2; i++) {
                            int cnt = 1;
                            while (arr[x + i + cnt][y + i] != 5) {
                                arr[x + i + cnt][y + i] = 5;
                                cnt++;
                            }
                        }
                        for (int i = 0; i < d1; i++) {
                            int cnt = 1;
                            while (arr[x + i + cnt][y - i] != 5) {
                                arr[x + i + cnt][y - i] = 5;
                                cnt++;
                            }
                        }

                        //구역의 합
                        for (int r = 1; r <= N; r++) {
                            for (int c = 1; c <= N; c++) {
                                int area = arr[r][c];
                                int num = map[r][c];
                                res[area -1] += num;
                            }
                        }

                        Arrays.sort(res);
                        answer = Math.min(answer, res[4] - res[0]);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+ " ");
            }
            System.out.println();
        }
    }
}
