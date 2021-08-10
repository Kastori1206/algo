package programmers;

/**
 * 상호평가
 * https://programmers.co.kr/learn/courses/30/lessons/83201
 */
public class 상호평가 {
    public static void main(String[] args) {
        int[][] scores = {
                {100, 90, 98, 88, 65},
                {50, 45, 99, 85, 77},
                {47, 88, 95, 80, 67},
                {61, 57, 100, 80, 65},
                {24, 90, 94, 75, 65},
        };
        System.out.println(solution(scores));
    }

    public static String solution(int[][] scores) {
        String answer = "";
        int len = scores.length;
        for (int i = 0; i < len; i++) {
            double avg = getAvg(i, scores);
            answer += grade(avg);
        }
        return answer;
    }

    public static double getAvg(int student, int[][] scores) {
        int min = 101;
        int max = -1;
        //점수가 몇개 나왔는지 체크
        int[] count = new int[101];
        int sum = 0;
        double avg = 0;

        for (int i = 0; i < scores.length; i++) {
            count[scores[i][student]]++;
            sum += scores[i][student];
            min = Math.min(min, scores[i][student]);
            max = Math.max(max, scores[i][student]);
        }

        //자기자신을 평가한 점수
        int self = scores[student][student];
        //학생들이 자기 자신을 평가한 점수가 유일한 최고점 또는 유일한 최저점이라면 그 점수는 제외
        if ((min == self && count[min] == 1) || (max == self && count[max] == 1)) {
            sum -= self;
            avg = (double) sum / (double) (scores.length - 1);
        } else {
            avg = (double) sum / (double) scores.length;
        }
        return avg;
    }

    public static String grade(double avg) {
        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        } else if (avg >= 70) {
            return "C";
        } else if (avg >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

}
