package week1.이상억.progarmmers;

/**
 * PackageName : week1.이상억.programmers
 * FileName    : 나머지가_1이_되는_수_찾기
 * Author      : sangeok
 * Date        : 2025. 4. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 29.     sangeok               Initial creation
 */
class Solution {
    public int solution(int n) {
        int i = 0;
        while (true) {
            i++;
            if (n % i == 1) {
                return i;
            }
        }
    }
}
