/**
 * PackageName : week18.이상억.progarmmers;
 * FileName    : 마법의_엘리베이터
 * Author      : sangeok
 * Date        : 2025. 08. 27.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 27달.     sangeok               Initial creation
 */


// 절대값이 10의 제곱승 형태인 정수들이 적힌 버튼
// 현재 층과 버튼의 값을 더한 결과가 0 보다 작으면 움직이지 않음
// 0 층이 가장 아래층



class Solution {
    public int solution(int storey) {
        int answer = 0;

        while(storey > 0){

            int cur = storey % 10;
            int next= (storey / 10 ) % 10;

            if(cur > 5 ){
                answer += (10-cur);
                storey = storey / 10 + 1;
            } else if( cur < 5){
                answer += cur;
                storey /= 10;
            } else {
                if(next >= 5){
                    answer += 10 - cur;
                    storey = (storey/10) +1;
                } else {
                    answer += cur;
                    storey /= 10;
                }
            }

        }
        return answer;
    }
}