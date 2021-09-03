package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 실패율
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class 실패율 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3	};
        for (Integer i : solution(N, stages)) {
            System.out.print(i+" ");
        }
    }
    static class Node implements Comparable<Node>{
        int idx;
        double fail;

        public Node(int idx, double fail) {
            this.idx = idx;
            this.fail = fail;
        }

        @Override
        public int compareTo(Node o) {
            if(fail>o.fail){
                return -1;
            } else if (fail == o.fail) {
                return Integer.compare(idx, o.idx);
            }else{
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", fail=" + fail +
                    '}';
        }
    }
    public static List<Integer> solution(int N, int[] stages) {
        int size = stages.length;
        int[] arr = new int[N+2];
        List<Integer> answer = new ArrayList<>();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr[stages[i]] ++;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i <= N; i++) {
            size -= arr[i];
            list.add(new Node(i, arr[i] == 0 ? 0 : (double) arr[i] / (double) size));
        }

        Collections.sort(list);
        for (Node node : list) {
            System.out.println(node);
            answer.add(node.idx);
        }
        return answer;
    }


}
