package week17.김누리.programmers;

/**
 * PackageName : week17.김누리.programmers
 * FileName    : 숫자_카드_나누기
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-17
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 17.     김누리(NRKim)               Initial creation
 */

/*

그럼 대상값 a의 경우
arrayA 에 있는 값을 나눌 때

arrayA[0] ==> 나눌 수 있다 arrayA[1] ==> 나눌 수 있다

arrayB 에 있는 값을 나눌 때

arrayB[0] ==> 나눌 수 있다 arrayB[1] ==> 나눌 수 있다

그러나

a는 arrayA의 모든값이 나눌 수 있으면, arrayB의 값은 다 나눌 수 없다.

case 1 :

arrayA = [10,17]
  >>  A의 요소를 둘 다 나눌 수 있는 자연수 X
  >>  10을 이용하면 B배열의 20만 나눌 수 있으므로 조건 충족 불가

arrayB = [5,20]  >>  5를 이용하면 B의 요소를 다 나눌 수 있음
  >>  5를 이용하면 B배열의 요소를 모두 정리 가능
  >>  그러나 A의 10도 나눌 수 있으므로 조건 충족 불가

case 2 :

arrayA = [10,20]
  >>  10을 이용하면 A의 배열 전부 나눌 수 있음.
  >>  10을 이용하면 B배열값 전부 나눌 수 없음 >> 조건 충족 >>> a = 10

arrayB = [5,17]
  >>  5를 이용하면 B배열의 요소를 모두 정리 불가
  >>  5를 이용하면 A의 배열 모두 정리 가능
  >>  a == 10 이기 때문에 5보다 크므로 a = 10임

case 3 :

arrayA = [14,35,119]
  >>  7을 이용하면 A의 배열 전부 나눌 수 있음.
  >>  7을 이용하면 B배열값 전부 나눌 수 없음 >> 조건 충족 >>> a = 7

arrayB = [18,30,102]
  >>  3를 이용하면 B배열의 요소 정리 가능
  >>  3을 이용하면 A배열의 요소 정리 불가
  >>  6을 이용하는 경우 상동
  >>  a == 7 이기 때문에 3과 6보다 크므로 a = 7임

  그러면 각 배열마다 gcd를 쓰면 될 거 같은데?

  gcd(a,b%a);

*/

public class 숫자_카드_나누기 {
	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;

		int a = gcdArray(arrayA);
		int b = gcdArray(arrayB);

		int resultA = divided(a,arrayB) ? a : 0;
		int resultB = divided(b,arrayA) ? b : 0;

		answer = Math.max(resultA,resultB);

		return answer;
	}

	//  배열을 반복하며 유클리드 호제법 돌리기
	private int gcdArray(int[] array) {

		//  시작 수
		int g = array[0];

		for(int i = 0; i < array.length; i++) {
			//  각 배열값을 순회하며 유클리드 호제법 진행
			g = gcd(g,array[i]);

			if(g == 1) return 1;
		}

		return g;
	}

	private int gcd (int a, int b) {
		while(b != 0) {
			int t = a%b;
			a = b;
			b = t;
		}

		return Math.abs(a);
	}

	private boolean divided(int x, int[] array) {
		if(x == 0) return false; //  0 인경우 나눌수가 없기 때문에

		for(int a : array) {
			// 대상 외 배열값 중 하나라도 나눠지면 거짓
			if(a%x == 0) return false;
		}

		return true;
	}
}
