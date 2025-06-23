package week8.강성욱.programmers;

/**
 * PackageName : week8.강성욱.programmers
 * FileName    : 기사단원의_무기
 * Author      : Baekgwa
 * Date        : 2025-06-17
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-17     Baekgwa               Initial creation
 */
public class 기사단원의_무기 {
	//약수 구해야됨.
	//number = 5 면, 1의약수, 2의약수 ... 5의약수의 개수 구해야됨.
	//약수 개수를 구하는 메서드를 하나 만들자.

	class Solution {
		public int solution(int number, int limit, int power) {
			int result = 0;

			//1부터 공격력 제한 확인
			for (int i = 1; i <= number; i++) {
				int count = dividedNumber(i);
				if (count > limit) {
					result += power;
				} else {
					result += count;
				}
			}

			return result;
		}

		private int dividedNumber(int number) {
			// 루트 number 까지 반복해서 % 나머지가 있는지 확인?
			// 10 => [1, 2, 5, 10] = 4개
			// 10 => 3까지 반복, 1(o), 2(o), 3(x) 2개 * 2개 = 4개
			// 근데 16 같은경우는, [1, 2, 4];
			// 4까지 반복 할때, 4는 약수가 중복이니깐 이거 처리 해줘야함. *2 무작정 하면 안됨.
			int count = 0;
			for (int i = 1; i * i <= number; i++) {
				if (number % i == 0) {
					count += (i * i == number) ? 1 : 2;
				}
			}
			return count;
		}
	}
}
