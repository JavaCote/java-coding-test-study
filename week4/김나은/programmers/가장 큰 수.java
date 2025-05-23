package week4.김나은.programmers;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] number = new String[numbers.length];

        // 문자열 배열로 변환
        for(int i = 0; i < numbers.length; i++) {
            number[i] = String.valueOf(numbers[i]);
        }

        // 내림차순 정렬
        Arrays.sort(number, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        // 배열에 0 만 있는 경우(정렬배열 맨처음이 0) "0" 리턴
        if(number[0].equals("0")) {
            return "0";
        }

        // 문자열 합치기
        for(String n : number) {
            answer += n;
        }

        return answer;
    }
}