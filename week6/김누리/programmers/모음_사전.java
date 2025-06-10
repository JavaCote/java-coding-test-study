package week6.김누리.programmers;

/**
 * PackageName : week6.김누리.programmers
 * FileName    : 모음_사전
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-01
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 01.     김누리(NRKim)               Initial creation
 */
/*
모음 배열 = {"A","E","I","O","U"}

모음 배열에서 가져오며 조합. 조합하며 카운트 증가.

*/

public class 모음_사전 {
	int answer = 0;
	int cnt = 0;
	String[] gathers = {"A","E","I","O","U"};

	public int solution(String word) {

		dfs("",word);

		return answer;
	}

	public void dfs (String current, String target) {
		//  현재 문자조합이 target 문자랑 동일하면 재귀 종료
		if(current.equals(target)) {
			answer = cnt;
			return;
		}

		if(current.length() == 5) return; // 문자 최대 길이는 5

		//  모음들을 조합하며 채번
		for(String ch : gathers) {
			cnt++;
			dfs(current + ch, target);
		}
	}
}
