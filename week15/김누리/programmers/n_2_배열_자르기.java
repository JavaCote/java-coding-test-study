package week15.김누리.programmers;

/**
 * PackageName : week15.김누리.programmers
 * FileName    : n_2_배열_자르기
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-05
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 05.     김누리(NRKim)               Initial creation
 */

/*
123
223
333

012 345 678
123 223 333
l = 2 r = 5

i = 2,3,4,5

row = 2/3 == 0
col = 2%3 == 2 ==> 3

row = 3/3 == 1 ==> 2
col = 3%3 == 0

row = 4/3 == 1 ==> 2
col = 4%3 == 1

row = 5/3 == 1
col = 5%3 == 2 ==> 3

*/

public class n_2_배열_자르기 {
	public int[] solution(int n, long left, long right) {
		int[] answer = new int[(int) (right - left + 1)];
		int idx = 0;

		for(long i = left ; i <= right; i++) {
			long row = i/n;
			long col = i%n;

			answer[idx++] = Math.max((int)row, (int)col) + 1;
		}

		return answer;
	}
}
