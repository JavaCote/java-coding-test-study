package week3.김상진.programmers;

/**
 * PackageName : week3.김상진.programmers
 * FileName    : 다음_큰_숫자
 * Author      : sangxxjin
 * Date        : 2025. 5. 11.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 11.     sangxxjin               Initial creation
 */
public class 다음_큰_숫자 {
	class Solution {
		public int solution(int n) {
			// 해당 문제 해결 후 더 좋은 방안을 찾아본 결과 Integer.bitCount 라는 함수 발견

			int answer = 0;
			// 기존 n의 1의 숫자를 구하기 위한 작업
			String binary = Integer.toBinaryString(n);
			int count = 0;
			for(char a : binary.toCharArray()){
				if(a=='1')count++;
			}

			//break를 걸기 때문에 while true
			while(true){
				// n+1부터 1을 개수를 계속 계산하면서 문제의 정답을 구함
				String answerBinary = Integer.toBinaryString(++n);
				int answerCount = 0;
				for(char a : answerBinary.toCharArray()){
					if(a=='1')answerCount++;
				}
				if(count==answerCount){
					answer = n;
					break;
				}
			}
			return answer;
		}
	}
}
