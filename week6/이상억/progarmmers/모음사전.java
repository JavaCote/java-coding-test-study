/**
 * PackageName : week6.이상억.progarmmers;
 * FileName    : 모음사전
 * Author      : sangeok
 * Date        : 2025. 6. 4.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 4.     sangeok               Initial creation
 */

// 문제 요구사항 :	A, E , I, O , U 만을 사용하여 만들 수 있는길이 5이하의 단어가 수록
// 첫번째 단어가 A, 마지막 UUUUU
// word 가 주어질 때 몇 번째 단어인지

// 접근 방식 : (1) 문제를 읽고 느낀게 수의 진법으로 나타내는 형식이라고 생각하였음
//            (2) 그래도 탐색문제라 dfs 로 접근

// 회고 : 어떻게 해야할지 감이 좀 오긴한다만 그 중간에 코드로 어떻게 해야할지 부분 부분 끊겨 있는 느낌이다.
//          이 과정이 좀 제자리 걸음인 것 같다. 맥빠지긴 하는데 그냥 열심히 하자.

class Solution {
    static char[] di = {'A','E','I','O','U'};
    static String target;
    static int count = 0;
    static int answer = 0;

    public int solution(String word) {
        target = word;
        dfs("");
        return answer;
    }

    public static void dfs(String current) {
        if (current.equals(target)) {
            answer = count;
            return;
        }

        if (current.length() == 5) return;

        for (char c : di) {
            count++;
            dfs(current + c);
        }
    }
}
