/**
 * PackageName : week14.이상억.progarmmers;
 * FileName    : 최대공약수와_최소공배수
 * Author      : sangeok
 * Date        : 2025. 07. 28.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 28.     sangeok               Initial creation
 */

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = rhddirtn(n, m);  // 최대공약수
        answer[1] = rhdqotn(n, m);  // 최소공배수
        return answer;
    }

    public int rhddirtn(int a, int b) {
        int result = 1;
        int min = Math.min(a, b);
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    public int rhdqotn(int a, int b) {
        int max = Math.max(a, b);
        int result = max;
        while (true) {
            if (result % a == 0 && result % b == 0) {
                break;
            }
            result++;
        }
        return result;
    }
}
