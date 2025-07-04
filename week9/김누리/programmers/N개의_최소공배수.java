package week9.김누리.programmers;

/**
 * PackageName : week9.김누리.programmers
 * FileName    : N개의_최소공배수
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-24
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 24.     김누리(NRKim)               Initial creation
 */


/*
    유클리드 호제법 이용

    유클리드 호제법: 큰 수를 작은 수로 나눈 나머지로 계속 나누다가 나머지가 0이 되는 순간의 나누는
                     수가 최대공약수


*/

public class N개의_최소공배수 {
	public int solution(int[] arr) {
		int answer = 0;

		//  arr의 길이가 1인 경우
		if(arr.length == 1) return arr[0];

		//  초기 최소 공약수 셋팅
		int g = gcd(arr[0],arr[1]);

		//  초기 answer 값 셋팅
		answer = (arr[0] * arr[1]) / g;


		if(arr.length > 1) {
			for(int i = 2; i < arr.length; i++) {
				g = gcd(arr[i],answer);
				answer = (answer* arr[i])/g;
			}
		}

		return answer;
	}


	//  유클리드 호제법 공식
	public int gcd(int a, int b) {
		if (a%b == 0) return b;

		return gcd(b, a%b);
	}
}
