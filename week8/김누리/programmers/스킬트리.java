package week8.김누리.programmers;

/**
 * PackageName : week8.김누리.programmers
 * FileName    : 스킬트리
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-16
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 16.     김누리(NRKim)               Initial creation
 */

/*
skill 을 쪼갬
예 )
case 1 : skill = "CBD"; ==> "C","B","D"
쪼갠 스킬들이 스킬트리에 있는지
있다면 이게 선행 스킬인지 파악하며 스킬트리 판정
*/
public class 스킬트리 {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		// 스킬트리 검사
		for(String tree : skill_trees) {
			String filtered = "";

			// 선행 스킬만 필터링
			for(int i = 0; i < tree.length(); i++) {
				char sk = tree.charAt(i);

				//  스킬 찍음
				if (skill.indexOf(sk) != -1) {
					filtered += sk;
				}
			}

			// 해당 스킬이 선행 스킬인가
			if(skill.startsWith(filtered)) {
				answer++;
			}
		}

		return answer;
	}
}
