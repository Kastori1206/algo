package swea;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea13501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                if (cmd.equals("I")) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    list.add(a, b);
                } else if (cmd.equals("D")) {
                    int a = Integer.parseInt(st.nextToken());
                    list.remove(a);
                } else {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    list.set(a, b);

                }
            }
            if (list.size() <= L) {
                sb.append(String.format("#%d -1\n", t));
            } else {
                sb.append(String.format("#%d %d\n", t, list.get(L)));

            }


        }
        System.out.println(sb);
    }
}
