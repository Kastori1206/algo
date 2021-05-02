package programmers;

import java.util.*;

/*
 * 불량 사용자
 * https://programmers.co.kr/learn/courses/30/lessons/64064
 */
public class 불량사용자 {
    public static void main(String[] args) {
//        String[] user_id ={"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] banned_id = {"fr*d*", "abc1**"};
//        System.out.println(solution(user_id,banned_id));
//        System.out.println();
//        String[] user_id = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] banned_id = new String[]{"*rodo", "*rodo", "******"};
//        System.out.println(solution(user_id,banned_id));

        String[] user_id = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = new String[]{"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(user_id,banned_id));

    }
    static Set<String>[] set;
    static Set<String> answer;
    public static int solution(String[] user_id, String[] banned_id){
        answer = new HashSet<>();
        int n = user_id.length;
        set = new HashSet[n];
        for(int k = 0;k<n;k++){
            int len = user_id[k].length();
            set[k] = new HashSet<String>();
            for(int i=0; i < 1<<len; i++) {
                String key = "";
                for(int j=0; j<len; j++) {
                    if((i & 1<<j) != 0){
                        key+=user_id[k].charAt(j);
                    }else{
                        key+='*';
                    }
                }
                set[k].add(key);
            }
        }

        per(banned_id, new int[banned_id.length], new boolean[n],0,n, banned_id.length);
        return answer.size();

    }
    public static void per(String[] banned_id, int[] output, boolean[] visited, int depth, int n, int r){
        if(depth == r){

            if(check(banned_id,output)){
                StringBuilder sb = new StringBuilder();
                int[] temp = Arrays.copyOf(output, output.length);
                Arrays.sort(temp);
                for(int i =0;i<temp.length;i++){
                    sb.append(temp[i]);
                }
                answer.add(sb.toString());
            }
            return;
        }

        for(int i = 0; i<n;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            output[depth] = i;
            per(banned_id, output, visited, depth + 1, n, r);
            visited[i] = false;
        }
    }

    public static boolean check( String[] banned_id,int[] output) {
        for(int i =0;i<banned_id.length;i++){
            if(!set[output[i]].contains(banned_id[i])){
                return false;
            }
        }
        return true;
    }

}
