/**
 * PackageName : week14.이상억.progarmmers;
 * FileName    : JadenCase_문자열_만들기
 * Author      : sangeok
 * Date        : 2025. 07. 28.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 28.     sangeok               Initial creation
 */

// 처음에 문제에서 주는 방식으로 split 사용하려다 공백 처리에 대해 번거로움을 느껴서 아래와 같은 방식으로 풀음

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean start = true;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                start = true;
            } else {
                if (start) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                start = false;
            }
        }

        return sb.toString();
    }
}
