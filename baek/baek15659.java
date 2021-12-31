package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 연산자 끼워넣기 (3)
 * https://www.acmicpc.net/problem/15659
 */
public class baek15659 {
    static int N, max, min;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        arr = new int[N];
        int[] opCnt = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            opCnt[i] = Integer.parseInt(st.nextToken());
        }
        combi(0, new int[N - 1], opCnt[0], opCnt[1], opCnt[2], opCnt[3]);
        System.out.println(max);
        System.out.println(min);
    }

    static void combi(int depth, int[] ops, int plus, int minus, int multi, int div) {
        if (depth == N - 1) {
            calc(ops);
            return;
        }

        if (plus > 0) {
            ops[depth] = 0;
            combi(depth + 1, ops, plus - 1, minus, multi, div);
        }
        if (minus > 0) {
            ops[depth] = 1;
            combi(depth + 1, ops, plus, minus - 1, multi, div);
        }
        if (multi > 0) {
            ops[depth] = 2;
            combi(depth + 1, ops, plus, minus, multi - 1, div);
        }
        if (div > 0) {
            ops[depth] = 3;
            combi(depth + 1, ops, plus, minus, multi, div - 1);
        }
    }

    static void calc(int[] ops) {
        List<Integer> opList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        numList.add(arr[0]);
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case 0:
                case 1:
                    numList.add(arr[i + 1]);
                    opList.add(ops[i]);
                    break;
                case 2:
                    numList.add(numList.remove(numList.size() - 1) * arr[i + 1]);
                    break;
                case 3:
                    numList.add(numList.remove(numList.size() - 1) / arr[i + 1]);
                    break;
            }
        }

        int ret = numList.get(0);
        if (!opList.isEmpty()) {
            for (int i = 0; i < opList.size(); i++) {
                int op = opList.get(i);
                if (op == 0) {
                    ret += numList.get(i + 1);
                } else {
                    ret -= numList.get(i + 1);
                }
            }
        }
        max = Math.max(max, ret);
        min = Math.min(min, ret);
    }
}
