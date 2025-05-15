package week3.이상억.progarmmers;

/**
 * PackageName : week3.이상억.progarmmers;
 * FileName    : 멀리_뛰기
 * Author      : sangeok
 * Date        : 2025. 5. 15.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 15.     sangeok               Initial creation
 */



class Solution {
    public long solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] a = new long[n];
        a[0] = 1;
        a[1] = 2;

        for (int i = 2; i < n; i++) {
            a[i] = (a[i - 1] + a[i - 2]) % 1234567;
        }

        return a[n - 1];
    }
}
