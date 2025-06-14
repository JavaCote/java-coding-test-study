package week7.김누리.programmers;

/**
 * PackageName : week7.김누리.programmers
 * FileName    : k진수에서_소수_개수_구하기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-10
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 10.     김누리(NRKim)               Initial creation
 */

/*
1.  m = n을 k진수로 변환 ex : 437674 >> 211020101011
2.  m을 0단위로 쪼개서 list에 저장(배열, stack, queue 편한대로 ㄱㄱ) ex : 211/0/2/0/1/0/1/0/11
3.  쪼갠 값들이 각각 소수인지 10진수화 해서 판정
  211 > 2*(3^2) + 1*(3^1) + 1*(3^0) > 18 + 3 + 1 > 22 >> 1 2 11 22 > 소수 아님
  002 > 2 * (3^0) > 2 >> 1 2 >> 소수
  001 > 1 * (3^0) > 3 >> 소수
  011 > 1 * (3^1) + 1 + (3^0) > 5 >> 소수
*/

public class k진수에서_소수_개수_구하기 {
	public int solution(int n, int k) {
		int answer = 0;
		String m = Integer.toString(n,k);
		String[] mArr = m.split("0+");

		for(String ms : mArr) {
			if(ms.isEmpty()) continue;

			long a = Long.parseLong(ms);
			if(isPrime(a)) answer++;
		}

		return answer;
	}

	public boolean isPrime(long a) {
		if ( a <= 1 ) return false; //  1은 소수아님, 0은 판명 불가

		for(long i = 2; i * i <= a; i++) {
			if(a % i == 0) return false;
		}

		return true;
	}
}
