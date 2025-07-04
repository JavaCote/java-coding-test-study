package week8.강성욱.programmers;

/**
 * PackageName : week8.강성욱.programmers
 * FileName    : 스킬트리
 * Author      : Baekgwa
 * Date        : 2025-06-16
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-16     Baekgwa               Initial creation
 */
public class 스킬트리 {
	// 스킬 트리 순서대로, 체크표시를 하면됨.
	// 즉, skill[] 이 = "CBD" 이고, "BACDE" 일때
	// "CBD"만 남긴 문자열로 변환하고
	// "BCD"
	// 이거 순서를 반복돌면서 맞는지 확인하면 될듯?
	// 이거 startWith 인지 확인하면 될듯?
	// "CBD" 일때, "BD" = x, "C" = O, "CB" = O, "B" = x
	// ㅇㅇ 가능할듯

	class Solution {
		public int solution(String skill, String[] skill_trees) {
			int result = 0;

			for (String tree : skill_trees) {
				StringBuilder filtered = new StringBuilder();

				for (char c : tree.toCharArray()) {
					if (skill.contains(String.valueOf(c))) {
						filtered.append(c);
					}
				}

				if (skill.startsWith(filtered.toString())) {
					result++;
				}
			}

			return result;
		}
	}
}
