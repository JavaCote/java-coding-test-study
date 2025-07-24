/**
 * PackageName : week13.이상억.progarmmers;
 * FileName    : 후보키
 * Author      : sangeok
 * Date        : 2025. 07. 24.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 24.     sangeok               Initial creation
 */


// 값을 hash로 등록해서 중복 되는지 확인
// 백트래킹 이용해서 모든 조합 검사

import java.util.*;

class Solution {
    List<Set<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        int colSize = relation[0].length;

        // 1~colSize 길이의 조합 모두 확인
        for (int r = 1; r <= colSize; r++) {
            combine(new HashSet<>(), 0, r, colSize, relation);
        }

        return candidateKeys.size();
    }

    // 조합 생성 및 후보키 판별
    private void combine(Set<Integer> current, int start, int r, int colSize, String[][] relation) {
        if (current.size() == r) {
            // 최소성 검사
            for (Set<Integer> key : candidateKeys) {
                if (current.containsAll(key)) return; // 최소성 위배
            }

            // 유일성 검사
            if (isUnique(current, relation)) {
                candidateKeys.add(new HashSet<>(current)); // 후보키 등록
            }
            return;
        }

        for (int i = start; i < colSize; i++) {
            current.add(i);
            combine(current, i + 1, r, colSize, relation);
            current.remove(i);
        }
    }

    // 유일성 검사
    private boolean isUnique(Set<Integer> keySet, String[][] relation) {
        Set<String> seen = new HashSet<>();

        for (String[] row : relation) {
            StringBuilder key = new StringBuilder();
            for (int col : keySet) {
                key.append(row[col]).append("|");
            }
            if (!seen.add(key.toString())) {
                return false; // 중복 있음
            }
        }

        return true; // 모든 row가 유일
    }
}
