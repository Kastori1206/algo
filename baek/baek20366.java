package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 같이 눈사람 만들래?
 * https://www.acmicpc.net/problem/20366
 */
public class baek20366 {
    public static class SnowMan{
        int a;
        int b;
        int h;

        public SnowMan(int a, int b, int h) {
            this.a = a;
            this.b = b;
            this.h = h;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        List<SnowMan> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                list.add(new SnowMan(i, j, arr[i] + arr[j]));
            }
        }

        int answer = Integer.MAX_VALUE;
        Collections.sort(list, Comparator.comparingInt(o -> o.h));

        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                SnowMan a = list.get(i);
                SnowMan b = list.get(j);
                if (a.a == b.a || a.a == b.b) {
                    continue;
                }

                if (b.a == a.b || b.b == a.b) {
                    continue;
                }

                answer = Math.min(answer, b.h - a.h);
                break;
            }
        }
        System.out.print(answer);
    }
}
