package programmers;

import java.util.*;

/**
 * 주차 요금 계산
 * https://programmers.co.kr/learn/courses/30/lessons/92341
 */

public class 주차요금계산 {
    public static void main(String[] args) {
        int[] frees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(solution(frees, records));

    }

    static class Car {
        int time;
        String number;
        boolean flag;

        public Car(String record) {
            String[] str = record.split(" ");
            String[] times = str[0].split(":");
            time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            number = str[1];
            flag = str[2].equals("IN");
        }
    }

    public static List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        TreeMap<String, Integer> result = new TreeMap<>();

        int last = 23 * 60 + 59;
        for (int i = 0; i < records.length; i++) {
            Car car = new Car(records[i]);
            if (car.flag) {
                map.put(car.number, car.time);
            } else {
                int time = car.time - map.get(car.number);
                if (result.containsKey(car.number)) {
                    result.put(car.number, result.get(car.number) + time);
                } else {
                    result.put(car.number, time);
                }
                map.remove(car.number);
            }
        }
        for (String number : map.keySet()) {
            int time = last - map.get(number);
            if (result.containsKey(number)) {
                result.put(number, result.get(number) + time);
            } else {
                result.put(number, time);
            }
        }

        for (String s : result.keySet()) {
            answer.add(calc(result.get(s), fees));
        }
        return answer;
    }

    static int calc(int time, int[] fees) {
        if (time - fees[0] <= 0) {
            return fees[1];
        }
        return (int) (fees[1] + Math.ceil((double) (time - fees[0]) / (double) fees[2]) * fees[3]);
    }

}
