package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 메뉴 리뉴얼
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 */
public class 메뉴리뉴얼 {
   public static void main(String[] args) {
//      String[] orders = new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
      String[] orders = new String[] {"XYZ", "XWY", "WXA"};
//      int[] course = new int[] {2,3,4};
      int[] course = new int[] {2,3,4};
      System.out.println(Arrays.toString(solution(orders, course)));
   }

   static public String[] solution(String[] orders, int[] course) {
      List<String> temp = new ArrayList<>();
      int[] max = new int[10+1];
      Map<String, Integer> map = new HashMap<>();
      for(int i =0;i<orders.length;i++) {
         int n = orders[i].length();
         for(int j=0;j<course.length;j++) {
            if(course[j] <=n) {
               char[] order = orders[i].toCharArray();
               //AB, BA 같은 경우의 수 정렬해서 조합
               Arrays.sort(order);
               //코스요리로 만들수있는 경우의수 구하기(조합)
               combi(0,n,course[j], new boolean[n],order, map, max, course[j]);
            }
         }
      }
      
      //hashmap에 값들 중 최대값이고 2이상인 코스요리 리스트에 저장
      map.forEach((key,value)->{
         if(value>=2 && max[key.length()] == value) {
            temp.add(key);            
         }
      });
            
      String[] answer = new String[temp.size()];
      //오름 차순으로 정렬
      Collections.sort(temp);
      //배열에 저장
      for(int i =0;i<temp.size();i++) {
         answer[i] = temp.get(i);
      }
      return answer;
   }
   
   static public void combi(int start, int n,int r, boolean[] visited, char[] str, Map<String, Integer> map,int[] max, int index) {
      if(r==0) {
         StringBuilder key = new StringBuilder();
         for(int i =0;i<str.length;i++) {
            if(visited[i]) {
               key.append(str[i]);
            }
         }
         
         //hashmap에 키가 있다면 그 값에서 +1 없으면 1을 넣음
         map.merge(key.toString(), 1, (existValue, initValue) -> existValue + initValue);
         
         //코스요리중 가장 많이 나온 수 저장
         int value = map.get(key.toString());
         max[index] = Math.max(max[index], value);
         
         return;
      }
      for(int i =start; i<n;i++) {
         visited[i] = true;
         combi(i+1,n,r-1,visited,str, map, max, index);
         visited[i] = false;
      }
   }
}