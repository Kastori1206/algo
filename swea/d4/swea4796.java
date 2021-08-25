package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4796. 의석이의 우뚝 선 산
 * https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
 */
public class swea4796 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int l=0, r =0, result = 0;
            boolean flag = true;

            for(int i =0;i<N-1;i++){
                if (flag && arr[i + 1] > arr[i]) {
                    l++;
                } else if (!flag && arr[i + 1] > arr[i]) {
                    flag = true;
                    result += l * r;
                    l = 1; r = 0;
                    continue;
                } else if (flag && arr[i + 1] < arr[i]) {
                    flag = false;
                    r++;
                } else if (!flag && arr[i + 1] < arr[i]) {
                    r++;
                }
            }
            result += l * r;
            System.out.println("#" + t + " " + result);
        }
    }
}




