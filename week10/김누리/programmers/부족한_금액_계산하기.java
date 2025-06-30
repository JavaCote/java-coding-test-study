package week10.김누리.programmers;

/**
 * PackageName : week10.김누리.programmers
 * FileName    : 부족한_금액_계산하기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-30
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 30.     김누리(NRKim)               Initial creation
 */

public class 부족한_금액_계산하기 {
	public long solution(int price, int money, int count) {
		long answer = 0;
		long up = 0; //  인상요금 저장용 변수

		//  반복하면서 인상 요금 완성
		for(int i = 0 ; i < count; i++) {
			up += (price * (i+1));
		}

		answer = up - money < 0? 0 : up - money;

		return answer;
	}
}
