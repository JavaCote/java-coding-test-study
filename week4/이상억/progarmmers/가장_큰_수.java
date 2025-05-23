/**
 * PackageName : week4.이상억.progarmmers;
 * FileName    : 가장_큰_수
 * Author      : sangeok
 * Date        : 2025. 5. 23.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 23.     sangeok               Initial creation
 */

// 문제 요구사항 : 배열 안 숫자들을 조합 해 가장 큰 수 만들기

// 접근 방법 : 	(1) 숫자를 붙여 if문으로 비교하려고 했는데 문제 조건에 정답이 넘 클 수도 있어 문자열로 반환한다고 하는 멘트와 제한 조건을 보니 무조건 오버플로우가 날 거같아 문자열로 비교해야할 거 같음
//        (2) 이중 for 문을 사용해 비교해서 덧붙여서 접근 해봤는데 시간초과가 남
//        (3) Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b)) 사용

// 회고 : 라이브러리를 사용안하려고 하였지만 결국에 사용했다..

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String s : str) sb.append(s);

        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}

// 이 풀이 방식 시간 초과 남


//import java.util.*;
//
//class Solution {
//    public String solution(int[] numbers) {
//        String[] str = new String[numbers.length];
//
//        for (int i = 0; i < numbers.length; i++) {
//            str[i] = String.valueOf(numbers[i]);
//        }
//
//        for(int i = 0 ; i < str.length - 1; i++){
//            for(int j = 0; j < str.length -1 - i ; j++ ){
//                String ab = str[j] + str[j + 1];
//                String ba = str[j + 1] + str[j];
//
//                if (ab.compareTo(ba) < 0) {
//                    String temp = str[j];
//                    str[j] = str[j + 1];
//                    str[j + 1] = temp;
//                }
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//
//        for(String s : str) sb.append(s);
//
//        return sb.toString();
//    }
//}
