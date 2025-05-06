package week2.이상억.progarmmers;

/**
 * PackageName : week2.이상억.programmers
 * FileName    : 올바른_괄호
 * Author      : sangeok
 * Date        : 2025. 5. 6.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 6.     sangeok               Initial creation
 */


class Solution {
    boolean solution(String s) {
        int x = 0;
        for (char a : s.toCharArray()) {
            x += (a == '(') ? 1 : -1;
            if (x < 0) return false;
        }
        return (x==0) ? true : false ;
    }
}
