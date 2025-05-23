package week4.강성욱.programmers;

import java.util.*;

public class 가장_큰_수 {
    //순열을 만들면?
    //O(n!) 인데, 너무 큼
    //음
    //가장 큰 수만 구하면 되는거
    //맨앞에 오는게, 가장 큰수이면 됨.
    //근데, 11 과 12를 어떻게 구별할것인가? 111, 114 이런것도.

    //해결되지 않아서 검색으로 해결함.
    // [30, 3] 의 우선순위는, 3 부터 나와야함.
    // 정렬 조건을, [a, b] 일 때, 303 vs 330 으로 정렬을 해서 결정
    // 다음으로 하나씩 builder 로 붙이면 됨.

    class Solution {
        public String solution(int[] numbers) {
            // 1. 문자열 배열로 변환
            String[] strs = new String[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                strs[i] = String.valueOf(numbers[i]);
            }

            // 2. 정렬: (b + a)가 큰 순서로
            Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

            // 3. "0000..." 예외 처리
            if (strs[0].equals("0")) return "0";

            // 4. 결과 이어붙이기
            StringBuilder sb = new StringBuilder();
            for (String s : strs) sb.append(s);

            return sb.toString();
        }
    }
}
