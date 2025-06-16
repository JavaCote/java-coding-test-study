/**
 * PackageName : week8.이상억.progarmmers;
 * FileName    : 기사단원의_무기
 * Author      : sangeok
 * Date        : 2025. 6. 16.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 16.     sangeok               Initial creation
 */


public int solution(int number, int limit, int power) {
    int[] divisorCount = new int[number + 1];
    int answer = 0;

    // 약수 개수 미리 계산
    for (int i = 1; i <= number; i++) {
        for (int j = i; j <= number; j += i) {
            divisorCount[j]++;
        }
    }

    for (int i = 1; i <= number; i++) {
        answer += (divisorCount[i] > limit) ? power : divisorCount[i];
    }

    return answer;
}
