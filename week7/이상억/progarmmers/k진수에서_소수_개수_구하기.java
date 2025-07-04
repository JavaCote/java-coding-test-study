/**
 * PackageName : week7.이상억.progarmmers;
 * FileName    : k진수에서_소수_구하기
 * Author      : sangeok
 * Date        : 2025. 6. 11.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 11.     sangeok               Initial creation
 */


class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String converted = convert(n, k);

        String[] parts = converted.split("0");

        for (String part : parts) {

            if (part.isEmpty()) continue;              // 빈 문자열 제외
            if (part.contains("0")) continue;          // 0 포함된 숫자 제외

            long num = Long.parseLong(part);
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    public String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }
        return sb.toString();
    }

    public boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
