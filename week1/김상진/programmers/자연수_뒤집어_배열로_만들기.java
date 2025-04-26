package week1.김상진.programmers;

import java.util.ArrayList;

/**
 * PackageName : week1.김상진.programmers
 * FileName    : 자연수_뒤집어_배열로_만들기
 * Author      : sangxxjin
 * Date        : 2025. 4. 27.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 27.     sangxxjin               Initial creation
 */
public class 자연수_뒤집어_배열로_만들기 {
	public ArrayList<Integer> solution(long n) {
		ArrayList<Integer> answer = new ArrayList<>();
		while(n>0){
			answer.add((int)(n%10));
			n/=10;
		}
		return answer;
	}
}
