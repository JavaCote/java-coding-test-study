/**
 * PackageName : week14.이상억.progarmmers;
 * FileName    : 124_나라의_숫자
 * Author      : sangeok
 * Date        : 2025. 07. 30.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 30.     sangeok               Initial creation
 */


// 진법의 관점으로 접근하면 안될 것 같음



class Solution {
    public String solution(int n) {
        String[] nums = {"4", "1", "2"};  // 나머지가 0, 1, 2일 때 대응값
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int r = n % 3;
            n = (n - 1) / 3;
            sb.insert(0, nums[r]);
        }

        return sb.toString();
    }
}
