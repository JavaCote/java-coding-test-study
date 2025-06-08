package week7.김나은.programmers;

/**
 * PackageName : week7.김나은.programmers FileName    : 음양_더하기 Author      : hellonaeunkim Date :
 * 2025-06-08 Description :
 * =====================================================================================================================
 * DATE             AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-08    hellonaeunkim       Initial creation
 */
public class 음양_더하기 {

    class Solution {

        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;

            // signs가 false인 경우, signs 인덱스와 같은 absolutes 배열 값을 뺌
            for (int i = 0; i < absolutes.length; i++) {
                if (signs[i] == false) {
                    answer -= absolutes[i];
                } else {
                    answer += absolutes[i];
                }
            }
            return answer;
        }
    }
}