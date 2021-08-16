package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 오큰수
 * https://www.acmicpc.net/problem/17298
 */
public class baek17298 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer[N-1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[N - 1]);
        for (int i = N - 2; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int num = stack.peek();
                if (num > arr[i]) {
                    answer[i] = num;
                    stack.push(arr[i]);
                    break;
                }else{
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                answer[i] = -1;
                stack.push(arr[i]);
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i + " ");
        }
        System.out.println(sb.toString());
    }
}
