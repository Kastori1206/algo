package programmers;

import java.util.*;

/*
 * 프린터
 * https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
 */

public class 프린터 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities,location));
    }
    static class Printer{
        int num, priority;

        public Printer(int num, int priority){
            this.num = num;
            this.priority = priority;
        }
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Printer> q = new LinkedList<>();

        for(int i =0;i<priorities.length;i++){
            q.add(new Printer(i,priorities[i]));
        }

        Arrays.sort(priorities);

        int index = priorities.length -1;
        while(!q.isEmpty()){
            Printer p = q.poll();
            //우선순위가 가장 높은 값과 큐에서 나온 우선순위값 비교
            if(p.priority == priorities[index]){
                index--;
                answer++;
                //찾고자 하는 번호랑 같으면 리턴
                if(p.num== location){
                    return answer;
                }
            }
            //우선순위 값 보다 낮으면 큐에 추가
            else{
                q.add(p);
            }
        }
        return answer;
    }
}
