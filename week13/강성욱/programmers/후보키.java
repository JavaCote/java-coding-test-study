package week13.강성욱.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * PackageName : week13.강성욱.programmers
 * FileName    : 후보키
 * Author      : Baekgwa
 * Date        : 2025-07-23
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-23     Baekgwa               Initial creation
 */
public class 후보키 {
	// 헷갈리네?
	// String 으로 묶어서 set으로 저장시켜서 확인해본다?
	// 그럼 조합을 만들어야 겟네?
	// 확인 해봐야 하는 조합은, (학번), (이름), (전공), (학년), (학번, 이름), (학번, 전공), ... (학번, 이름, 전공, 학년)
	// 그럼 인덱스를 활용해서, arrayList 에 조합을 하나씩 저걸 만들어둘까? ㅇㅇ 그러고 하나씩 뽑아쓰면 될듯
	// 최소성 만족을 어떻게 해야하나...?
	// 위에서 유일성을 만족하는 슈퍼키 조합을 만들어두고, contains 로 검사?

	class Solution {
		public int solution(String[][] relation) {
			int row = relation.length;
			int col = relation[0].length;

			List<List<Integer>> combiList = new ArrayList<>();
			List<List<Integer>> candidateKeyList = new ArrayList<>();

			for (int size = 1; size <= col; size++) {
				combine(col, size, 0, new ArrayList<>(), combiList);
			}
			// System.out.println(combiList);

			for(List<Integer> combi : combiList) {
				//최소성 확인
				//현재 키 조합이, 이미 모두 들어있는 조합이라면
				if (candidateKeyList.stream().anyMatch(candidateKey -> combi.containsAll(candidateKey))) {
					continue;
				}

				//유일성 확인을 위한 set
				Set<String> checkSet = new HashSet<>();

				for(String[] cols : relation) {
					StringBuilder sb = new StringBuilder();
					for(int index : combi) {
						sb.append(cols[index]);
					}
					checkSet.add(sb.toString());
				}

				if(checkSet.size() == row) {
					candidateKeyList.add(combi); //해당 조합은 유일성, 최소성 만족
				}
			}
			System.out.println(candidateKeyList);

			return candidateKeyList.size();
		}

		private void combine(int n, int r, int start, List<Integer> temp, List<List<Integer>> result) {
			if (temp.size() == r) {
				result.add(new ArrayList<>(temp));
				return;
			}
			for (int i = start; i < n; i++) {
				temp.add(i);
				combine(n, r, i + 1, temp, result);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
