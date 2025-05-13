package week3.김누리.programmers;

/**
 * PackageName : week3.김누리.programmers
 * FileName    : 지폐_접기
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-13
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 13.     김누리(NRKim)               Initial creation
 */

public class 지폐_접기 {
	public int solution(int[] wallet, int[] bill) {
		int answer = 0;
		int bill_w = bill[0]; // 지폐의 가로
		int bill_h = bill[1]; // 지폐의 세로
		int wallet_w = wallet[0]; // 지갑의 가로
		int wallet_h = wallet[1]; // 지갑의 세로

		while(
			!(
				//  지폐의 가로가 지갑의 가로 보다 작을 때 충족  &&  지폐의 세로가 지갑의 세로 이하일때 충족
				(bill_w <= wallet_w && bill_h <= wallet_h) ||
					//  또는 지폐의 세로가 지갑의 가로 보다 작을 때 충족  &&  지폐의 가로가 지갑의 세로 이하일때 충족
					(bill_h <= wallet_w && bill_w <= wallet_h)
			)
		) {
			//  지폐의 가로가 세로보다 크면 가로를 반으로 접는다
			if(bill_w >= bill_h) {
				bill_w = bill_w/2;
			} else {
				bill_h = bill_h/2;
			}

			answer++;
		}

		return answer;
	}
}
