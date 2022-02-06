package programmers;

import java.util.Arrays;

/**
 * 양궁대회
 * https://programmers.co.kr/learn/courses/30/lessons/92342
 */
public class 양궁대회 {
   public static void main(String[] args) {
        int n = 5;        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
//        int n = 1	; int[] info ={1,0,0,0,0,0,0,0,0,0,0};
//        int n = 9	; int[] info ={0,0,1,2,0,1,1,1,1,1,1};
//        int n = 10; int[] info ={[0,0,0,0,0,0,0,0,3,4,3};
       System.out.println(Arrays.toString(solution(n, info)));

    }
    static int max;
    static int[] answer;
    public static int[] solution(int n, int[] info) {
        answer = new int[11];

        dfs(0, n, 0, new int[n], info);
        return max==0? new int[]{-1} : answer;
    }

    public static void dfs(int start, int r, int idx, int[] result, int[] info) {
        if (idx == r) {
            int[] info2 = new int[11];
            for (int score : result) {
                info2[10 - score]++;
            }

            int ryan = 0;
            int apeach = 0;

            for (int i = 0; i < 11; i++) {
                int score = 10 - i;
                if (info2[i] > info[i]) {
                    ryan += score;
                } else if (info2[i] < info[i]) {
                    apeach += score;
                } else if (info[i] != 0 && info2[i] == info[i]) {
                    apeach += score;
                }
            }

            if (ryan - apeach > max) {
                max = ryan -apeach;
                answer = info2;
            }
            return;
        }

        for (int i = start; i < 11; i++) {
            result[idx] = i;
            dfs(i, r ,idx+1, result, info);
        }
    }
}
