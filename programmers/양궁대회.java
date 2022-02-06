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
        //max == 0이면 한번도 라이언이 이긴적이 없음
        return max==0? new int[]{-1} : answer;
    }
    //중복조합 사용 11H10 = 184756
    public static void dfs(int start, int r, int idx, int[] result, int[] info) {
        if (idx == r) {
            int[] info2 = new int[11];
            //과녁 점수를 어피치와 같이 과녁점수 맞춘 갯수로 표현
            for (int score : result) {
                info2[10 - score]++;
            }

            int ryan = 0;
            int apeach = 0;

            for (int i = 0; i < 11; i++) {
                //info[0] = 10점 , info[1] = 9점 맞추기위해 score 계산
                int score = 10 - i;
                //라이언이 이긴 경우
                if (info2[i] > info[i]) {
                    ryan += score;
                }
                //어피치가 이긴 경우
                else if (info2[i] < info[i]) {
                    apeach += score;
                }
                //과년에 맞추고 어피치와 라이언이 같은 갯수를 쏜 경우
                else if (info[i] != 0 && info2[i] == info[i]) {
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
            //라이언이 쏜 과녁 점수 저장
            result[idx] = i;
            dfs(i, r ,idx+1, result, info);
        }
    }
}
