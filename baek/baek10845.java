package baek;

import java.io.*;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/10845

//push X: 정수 X를 큐에 넣는 연산이다.
//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 큐에 들어있는 정수의 개수를 출력한다.
//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
public class baek10845 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int front = 0, back = 0;

        int[] queue = new int[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    queue[back++] = Integer.parseInt(st.nextToken());
                    break;
                case "pop":
                    if(queue[front] == 0){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue[front]).append("\n");
                        queue[front++] = 0;//초기화
                    }
                    break;
                case "size":
                    int size = back == front ? 0 : back - front;
                    sb.append(size).append("\n");
                    break;
                case "empty":
                    sb.append(front == back ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue[front] == 0 ? -1 : queue[front]).append("\n");
                    break;
                case "back":
                    if(back == 0){
                        sb.append(queue[0] == 0 ? -1 : queue[0]).append("\n");
                    }else{
                        sb.append(queue[back - 1] == 0 ? -1 : queue[back -1]).append("\n");
                    }
                    break;
            }
        }
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
