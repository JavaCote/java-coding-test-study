/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 부족한_금액_계산하기
 * Author      : sangeok
 * Date        : 2025. 6. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 29.     sangeok               Initial creation
 */

class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for(int i = 1; i <= count; i++){
            sum += price * i;
        }

        return sum > money ? sum - money : 0;
    }
}