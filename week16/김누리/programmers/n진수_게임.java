package week16.김누리.programmers;

/**
 * PackageName : week16.김누리.programmers
 * FileName    : n진수_게임
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-10
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 10.     김누리(NRKim)               Initial creation
 */

/*
n 진법
t 미리 구할 숫자 갯수
m 총원
p 순번

case 1
n = 2
t = 4
m = 2
p = 1

2진수 미리 구해야 할 숫자 4개 총원 2명 1번째
(0)   0    (1)   1
(10)  2    (11)  3
(100) 4    (101) 5
(110) 6    (111) 7

0111       1101

case 2

n = 16
t = 16
m = 2
p = 1

(0) 0  (1)1
(2) 2  (3)3
(4) 4  (5)5
(6) 6  (7)7
(8) 8  (9)9
(A)10  (B)11
(C)12  (D)13
(E)14  (F)15
(1)16  (0)16
(1)17  (1)17
(1)18  (2)18

이런 패턴으로 가게 될 거임

*/

public class n진수_게임 {
	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		int num = 0;

		//  진수 변환 다 이어 붙이기
		while(sb.length() < t*m) {
			sb.append(Integer.toString(num++, n).toUpperCase());
		}


		//  진수 변환 후 내 앞에 몇개가 있는지 계산
		StringBuilder sb2 = new StringBuilder();
		int idx = p-1;

		for(int i = 0; i < t; i++) {
			sb2.append(sb.charAt(idx));
			idx += m;
		}

		return sb2.toString();
	}
}
