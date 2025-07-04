package week4.김누리.programmers;

/**
 * PackageName : week4.김누리.programmers
 * FileName    : n_X_2_타일링
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-21
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 21.     김누리(NRKim)               Initial creation
 */

/*
  n : 우리가 채워야 하는 타일의 가로 길이

  우리가 쓸수 있는 타일의 가로는 2, 세로는 1
  이하 가로는 w =2, 세로는 h =1

  if n = 1 인 경우 가능한 조합
  h
  1개의 조합

  if n = 2 인 경우
  hh
  w
  2개의 조합

  if n = 3 인 경우
  hhh
  hw
  wh
  3개의 조합

  if n = 4 인 경우
  hhhh
  hhw
  hwh
  whh
  ww
  5개의 조합

  if n = 5인 경우
  hhhhh
  hhhw
  hhwh
  hwhh
  whhh
  wwh
  whw
  hww
  8개의 조합

  피보나치 수열로 풀면 OK
*/

public class n_X_2_타일링 {
	public int solution(int n) {
		int answer = 0;
		int x = 1000000007;
		int a = 1; // n == 1 일때 결과 값
		int b = 2; // n == 2 일때 결과 값

		if(n == 1) answer = a%x;
		if(n == 2) answer = b%x;

		for(int i = 3; i <= n; i++) {
			answer = (a+b) % x;
			a = b;
			b = answer;
		}

		return answer;
	}
}
