package week1.이상억.progarmmers;

/**
 * PackageName : week1.이상억.programmers
 * FileName    : 문자열_내_p와_y의_개수
 * Author      : sangeok
 * Date        : 2025. 4. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 29.     sangeok               Initial creation
 */
class Solution {
    boolean solution(String s) {
        String a = s.toLowerCase();
        int p_count = 0;
        int y_count = 0;

        for (char x : a.toCharArray()) {
            p_count += (x == 'p') ? 1 : 0;
            y_count += (x == 'y') ? 1 : 0;
        }

        return p_count == y_count;
    }
}
