package week7.김나은.programmers;

import java.util.Arrays;

/**
 * PackageName : week7.김나은.programmers FileName    : 정수_내림차순으로_배치하기 Author      : hellonaeunkim Date
 * : 2025-06-05 Description :
 * =====================================================================================================================
 * DATE              AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-05      hellonaeunkim      Initial creation
 */
public class 정수_내림차순으로_배치하기 {

    class Solution {

        public long solution(long n) {

            // 내림차순 정렬을 위해 주어진 long 타입의 n을 char 타입의 문자 배열로 변환
            char[] ch = String.valueOf(n).toCharArray();

            // 우선 오름차순 정렬
            Arrays.sort(ch);

            // 배열을 하나의 문자열로 합치기
            StringBuilder sb = new StringBuilder();
            for (char c : ch) {
                sb.append(c);
            }

            // 문자열을 long 타입으로 변환, 내림차순 정렬
            return Long.parseLong(sb.reverse().toString());
        }
    }
}
