package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 낚시왕
 * https://www.acmicpc.net/problem/17143
 */
public class baek17143 {
    static class Shark{
        int r, c, s, d, z;
        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", s=" + s +
                    ", d=" + d +
                    ", z=" + z +
                    '}';
        }
    }
    //방향 상(1),하(2),우(3),좌(4)
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};

    static int R, C,M, answer;
    static List<Shark> sharks;
    static Shark[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R+1][C+1];
        sharks = new ArrayList<>();

        for(int i = 0 ;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            Shark shark = new Shark(r,c,s,d,z);
            map[r][c] = shark;
            sharks.add(shark);
        }
        int person = 0;
        for(int i = 1 ;i<=C;i++){
            //낚시왕이 오른쪽으로 한 칸 이동한다.
            //낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
            Shark target = null;
            for (int j = 1; j <= R; j++) {
                if (map[j][i] != null) {
                    target = map[j][i];
                    break;
                }
            }
            if (target != null) {
                map[target.r][target.c] = null;
                answer += target.z;
                sharks.remove(target);
            }

            //상어가 이동한다.
            for(Shark shark : sharks){

            }
            map = new Shark[R+1][C+1];
            int size = sharks.size();
            for(int j= size-1;j>=0;j--){
                Shark shark = sharks.get(i);
                if(map[shark.r][shark.c] ==null){
                }
            }



        }
        System.out.println(answer);
    }
}
