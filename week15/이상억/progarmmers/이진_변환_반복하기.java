/**
 * PackageName : week15.이상억.progarmmers;
 * FileName    : 이진_변환_반복하기
 * Author      : sangeok
 * Date        : 2025. 08. 06.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 06.     sangeok               Initial creation
 */

// x의 모든 0 을 제거
// x의 길이를 c 라 하면 c -> 2진 변환

// s가 1이 될 때 까지 s에 이진 변환을 가했을 때 ,
// 이진 변환의 횟수와 변환 과정에서 제거 된 0의 개수 배열의 담기

import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {

            answer[1] += s.length() - s.replace("0", "").length();
            s = s.replace("0", "");
            s = bit(s.length());
            answer[0]++;

        }
        return answer;

    }

    public String bit(int value) {
        StringBuilder bit = new StringBuilder();

        while (value > 0) {
            bit.insert(0, value % 2);
            value = value / 2;
        }

        return bit.toString();
    }

}

