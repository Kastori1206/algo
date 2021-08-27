package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * 1244.[S/W 문제해결 응용] 2일차 - 최대 상금
 * https://swexpertacademy.com/main/code/problem/problemSolver.do?contestProbId=AV15Khn6AN0CFAYD
 */
public class swea1244 {
    static int res, N , size;
    static int[] arr;
    static Set<String> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            size = num.length();
            arr = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = num.charAt(i)-'0';
            }
            N = Integer.parseInt(st.nextToken());
            set = new HashSet<>();

            res = 0;
            go(N);

            answer.append("#" + t + " " + res + "\n");
        }//test_case
        System.out.println(answer.toString());
        br.close();
    }//main

    static void go(int cnt) {
        int num = getNum();

        String temp = "" + num + cnt;

        if (set.contains(temp)) {
            return;
        }
        set.add(temp);

        if (cnt == 0) {
            res = Math.max(res, num);
            return;
        }

        for (int i = 0; i < size-1; i++) {
            for (int j = i + 1; j < size; j++) {
                swap(i, j);
                go(cnt -1);
                swap(i, j);
            }
        }
    }

    private static int getNum() {
        int res = 0;
        for (int i = 0; i < size; i++) {
            res = res * 10 + arr[i];
        }
        return res;
    }


    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

