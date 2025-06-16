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

// 문제 요구사항 :	자신의 기사 번호의 약수 개수에 해당하는 공격력을 가진 무기 구매
//제한 수치 넘을 경우 제한된 공격력을 가진 무기
//무기 공격력 1당 1kg 의 철
//ex -> 15번 지정된 기사단원 1,3,5,15 약수 4개 이므로 4인 공격력 이지만 제한 수치가 3 초과한 제약은 2라서 2를 구매
//기사단원의 수 : number	/ 공격력의 제한 수치 : limit / 제한 수치를 초과한 기사 사용할 무기의 공격력 : power

// 회고 : 처음에 별 생각 없이 이중 for 문 썻다가 n^2 떠서 터졌다 .. 그래서 i * i < j 방식을 사용해서 반복횟수를 줄이는 방법을 하려했으나
// 다른 방법이 있을 것 같아 찾아 봤는데 DP 방법이 있어 그 방법을 채택해서 문제 해결하였다.


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
