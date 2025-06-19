/**
 * PackageName : week8.이상억.progarmmers;
 * FileName    : 가장_가까운_같은_글자
 * Author      : sangeok
 * Date        : 2025. 6. 18.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 18.     sangeok               Initial creation
 */


class Solution {
    public int[] solution(String s) {
        char[] chararray = s.toCharArray();
        int[] answer = new int[chararray.length];

        for (int i = 0; i < chararray.length; i++) {
            answer[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (chararray[i] == chararray[j]) {
                    answer[i] = i - j;
                    break;
                }
            }
        }
        return answer;
    }
}
