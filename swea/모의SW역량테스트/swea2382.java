package swea.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 미생물 격리
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV597vbqAH0DFAVl
 */
public class swea2382 {
    static class Microbe {
        int r, c, cnt, d;
        int max, tempDir, sum;
        public Microbe(int r, int c, int cnt, int d, int max, int tempDir, int sum) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.d = d;
            this.max = max;
            this.tempDir = tempDir;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Microbe{" +
                    "r=" + r +
                    ", c=" + c +
                    ", cnt=" + cnt +
                    ", d=" + d +
                    ", max=" + max +
                    ", tempDir=" + tempDir +
                    ", sum=" + sum +
                    '}';
        }
    }
    static int N,M,K;
    static Microbe[][] map;
    static List<Microbe> microbes;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            long res = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            microbes = new ArrayList<>();
            for(int i = 0; i<K;i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                microbes.add(new Microbe(r, c, cnt, d-1,cnt,d-1,cnt));
            }

            for(int i =0;i<M;i++){

                move();
//                System.out.println(microbes.size());
//                for (Microbe m : microbes) {
//                    System.out.println(m.r + " " + m.c + " " + m.sum);
//                }
                System.out.println("===================================");
            }

            for (Microbe microbe : microbes) {
                res += microbe.cnt;
            }
            answer.append("#"+t+ " "+ res+"\n");
        }
        System.out.println(answer);


    }

    private static void move() {
        map = new Microbe[N][N];
        for (Microbe m : microbes) {
            m.r += dr[m.d];
            m.c += dc[m.d];

            if (isEdge(m.r, m.c, N)) {
                m.cnt /=2;
                m.sum = m.cnt;
                m.max = m.cnt;
                m.d = changeDir(m.d);
                m.tempDir = m.d;
            }
//            System.out.println(m);
            if (map[m.r][m.c] != null) {
                if(map[m.r][m.c].max<m.cnt){
                    m.tempDir = m.d;
                    map[m.r][m.c].max = m.cnt;
                }
                map[m.r][m.c].sum += m.cnt;
            }else{
                map[m.r][m.r] = new Microbe(m.r, m.c, m.cnt, m.d, m.max, m.tempDir, m.sum);
            }
        }
        check();

    }

    public static void check() {
        microbes = new ArrayList<>();
        for(int r = 0 ;r<N;r++){
            for(int c  = 0 ;c<N;c++){
                Microbe m = map[r][c];
                if (m == null) {
                    continue;
                }
                System.out.println(m);
                microbes.add(new Microbe(m.r, m.c, m.sum, m.tempDir, m.sum, m.tempDir, m.sum));
            }
        }
    }

    public static int changeDir(int d) {
        int res = d;
        switch (d) {
            case 0:
                res = 1;
                break;
            case 1:
                res = 0;
                break;
            case 2:
                res = 3;
                break;
            case 3:
                res =  2;
                break;
        }
        return res;
    }

    public static boolean isEdge(int r, int c, int N) {
        return r == 0 || c == 0 || r == N - 1 || c == N - 1;
    }
}
