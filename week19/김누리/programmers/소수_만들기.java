package week19.김누리.programmers;

/**
 * PackageName : week19.김누리.programmers
 * FileName    : 소수_만들기
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-01
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 01.     김누리(NRKim)               Initial creation
 */

/*

간단하게 생각할것
3중 for문 돌려서 (배열의 크기도 50, 1~1000 이하의 값이므로 최대 반복수는 5만건이라 가능)
더한 값을 소수판단

*/

public class 소수_만들기 {
	public int solution(int[] nums) {
		int answer = 0;

		for(int i = 0; i < nums.length-2; i++) {
			int sum = 0;

			for(int j = i+1 ; j < nums.length-1; j++) {
				for(int k = j+1; k < nums.length; k++) {
					sum = nums[i] + nums[j] + nums[k];

					if(isPrime(sum)) answer++;
				}
			}


		}

		return answer;
	}

	public boolean isPrime(int val) {
		//  소수 : 2 3 5 7 11 같이 1과 자기 자신으로만 나눠짐.
		//  고로 2보다 작으면 소수 판정 불가
		if(val < 2) return false;

		for(int i = 2; i <= Math.sqrt(val); i++) {
			if(val % i == 0) return false;
		}

		return true;
	}
}
