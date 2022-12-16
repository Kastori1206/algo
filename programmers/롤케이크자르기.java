package programmers;

import java.util.*;

public class 롤케이크자르기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
        System.out.println(solution(new int[]{1, 2, 3, 1, 4}));
    }
    public static int solution(int[] topping) {
        int answer = 0;
        int[] cnts = new int[10001];

        int r = 0;

        for(int i =0;i<topping.length;i++){
            if(cnts[topping[i]] ==0){
                r++;
            }
            cnts[topping[i]]++;
        }

        Set<Integer> set = new HashSet<>();

        for(int i =0;i<topping.length;i++){
            int a = topping[i];
            set.add(a);
            if(--cnts[topping[i]]==0){
                r--;
            }

            if(set.size() == r){
                answer++;
            }
        }
        return answer;
    }
}
