/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 다트_게임
 * Author      : sangeok
 * Date        : 2025. 6. 28.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 28.     sangeok               Initial creation
 */


// 문제 요구사항 :    S -> x^1 / D -> x^2 / T -> x^3
//                  * -> a x b / # -> a - b
//                  * 당첨 시 해당 점수와 바로 전에 얻은 점수 2배 // # 당첨시 해당 점수 마이너스
//                  * 첫번째 나올 시 해당 점수만 두배

// 회고 : 푸는데 문제 조건이 많아서 귀찮았다. 그리고 각 문자열을 split 해서 박은 다음 배열로 돌면 쉽겠다 했는데
// 1 / 10 을 처리하는 과정 이 부분을 신경쓰지 못해 좀 헤맸었다. 그냥 바로바로 생각나는 코드를 마구잡이로 작성해서 코드가 지저분 했다.
// 다른 사람 풀이를 보니까 정규식으로 쉽게 나누던데 그 부분도 한번 공부해봐야겠다.

import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<Integer> scores = new ArrayList<>();
        int point = 0;

        char[] arr = dartResult.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '1' && i + 1 < arr.length && arr[i + 1] == '0') {
                point = 10;
                i++; // '0'은 건너뜀
            }
            else if (Character.isDigit(c)) {
                point = c - '0';
            }
            else if (c == 'S' || c == 'D' || c == 'T') {
                point = dartoption(point, String.valueOf(c));
                scores.add(point);
            }
            else if (c == '*') {
                int size = scores.size();
                if (size >= 1) scores.set(size - 1, scores.get(size - 1) * 2);
                if (size >= 2) scores.set(size - 2, scores.get(size - 2) * 2);
            }
            else if (c == '#') {
                int size = scores.size();
                scores.set(size - 1, scores.get(size - 1) * -1);
            }
        }

        for (int s : scores) answer += s;
        return answer;
    }

    public int dartoption(int point, String op) {
        switch (op) {
            case "S": break;
            case "D": point = (int) Math.pow(point, 2); break;
            case "T": point = (int) Math.pow(point, 3); break;
            default: break;
        }
        return point;
    }
}

