package programmers;

import java.util.*;
/*
 * 후보키
 * * https://programmers.co.kr/learn/courses/30/lessons/42890
 */
public class 후보키 {
    public static void main(String[] args) {
        String[][] relation = new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(1&2);
        System.out.println(solution(relation));
    }
    static public int solution(String[][] relation) {
        int answer = 0;
        List<Integer> temp = new ArrayList<>();

        int col = relation[0].length;
        int row = relation.length;

        //컬럼의 부분집합 구하기
        for(int i = 0 ; i<1<<col; i++){
            //키 유일성 검사 Set
            Set<String> set = new HashSet<>();

            boolean flag = true;

            for(int r = 0 ;r<row;r++){
                StringBuilder key = new StringBuilder();
                for(int c=0;c<col;c++){
                    if((i &(1<<c)) !=0){
                        key.append(relation[r][c]);
                    }
                }
                if(set.contains(key.toString())){
                    flag = false;
                    break;
                }else{
                    set.add(key.toString());
                }
            }
            //유일성 검사
            if(flag){
                //최소성 검사
                boolean chk = true;
                for(Integer a : temp){
                    if((a&i)==a){
                        chk= false;
                        break;
                    }
                }
                if(chk){
                    temp.add(i);
                }
            }
        }


        return temp.size();

    }
}

