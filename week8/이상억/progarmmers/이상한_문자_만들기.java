/**
 * PackageName : week8.이상억.progarmmers;
 * FileName    : 이상한_문자_만들기
 * Author      : sangeok
 * Date        : 2025. 6. 18.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 18.     sangeok               Initial creation
 */

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                index = 0;
                answer.append(c);
            } else {
                if (index % 2 == 1) {
                    answer.append(Character.toLowerCase(c));
                } else {
                    answer.append(Character.toUpperCase(c));
                }
                index++;
            }
        }

        return answer.toString();
    }
}
