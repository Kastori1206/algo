package baek;

import java.io.*;
import java.util.*;

// 통계학
// https://www.acmicpc.net/problem/2108

public class baek2108 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int mode = 0;
        double sum = 0;

        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);

        }
        Collections.sort(list);
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        int min = entryList.get(0).getValue();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < entryList.size(); i++){
            if(entryList.get(i).getValue() < min){
                break;
            }
            temp.add(entryList.get(i).getKey());
        }
        Collections.sort(temp);
        mode = temp.size() == 1 ? temp.get(0) : temp.get(1);

        //산술평균
        sb.append(Math.round(sum/N)).append("\n");
        //중앙값
        sb.append(list.get(N/2)).append("\n");
        //최빈값
        sb.append(mode).append("\n");
        //범위
        sb.append(list.get(N - 1) - list.get(0)).append("\n");
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
