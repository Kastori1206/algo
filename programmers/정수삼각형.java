package programmers;

/**
 * 정수 삼각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
public class 정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(solution(triangle));
    }

    static public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] arr = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                arr[i][j] = Math.max(arr[i + 1][j], arr[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return arr[0][0];
    }
}
