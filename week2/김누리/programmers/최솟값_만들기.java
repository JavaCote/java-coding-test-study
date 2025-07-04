package week2.김누리.programmers;

import java.util.Arrays;

/**
 * PackageName : week2.김누리.programmers
 * FileName    : 최솟값_만들기
 * Author      : 김누리
 * Date        : 2025-05-05
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 05.     김누리               Initial creation
 * 2025. 05. 05.     김누리               초기 풀이 완료
 */
public class 최솟값_만들기 {
	public int solution(int []A, int []B)
	{
		int answer = 0;
		int l = B.length-1;

		//  A랑 B 를 asc
		Arrays.sort(A); //  1 2 4
		Arrays.sort(B); //  4 4 5

		for(int i = 0; i < A.length; i++) {
			answer += A[i] * B[l--]; // A에서는 idx가 0부터 B에서는 맨 마지막 idx 부터 가져와서 곱샘 진행
		}

		return answer;
	}
}
