/**
 * PackageName : week17.이상억.progarmmers;
 * FileName    : 숫자_카드_나누기
 * Author      : sangeok
 * Date        : 2025. 08. 21.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 21.     sangeok               Initial creation
 */

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int gcdA = gcd(arrayA);

        int gcdB = gcd(arrayB);

        if (is_valid(gcdA, arrayB)) {
            answer = Math.max(answer, gcdA);
        }

        if (is_valid(gcdB, arrayA)) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    public int gcd(int[] array){
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = gcd(result, array[i]);
        }
        return result;
    }

    public int gcd(int a, int b){
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public boolean is_valid(int gcd_number, int[] array) {
        for (int num : array) {
            if (num % gcd_number == 0) {
                return false;
            }
        }
        return true;
    }
}
