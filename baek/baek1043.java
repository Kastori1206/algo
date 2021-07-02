package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 거짓말
 * https://www.acmicpc.net/problem/1043
 */
public class baek1043 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            list = new ArrayList<>();
        }
        Set<Integer> factPerson = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            factPerson.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < K; j++) {
                temp.add(Integer.parseInt(st.nextToken()));
            }
            list.add(temp);
        }

        while (true) {
            boolean flag = true;
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    if (factPerson.contains(list.get(i).get(j))) {
                        factPerson.addAll(list.get(i));
                        list.remove(i);
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                break;
            }
        }

        System.out.println(list.size());
    }
}
