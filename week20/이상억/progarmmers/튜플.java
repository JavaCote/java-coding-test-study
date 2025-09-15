/**
 * PackageName : week20.이상억.progarmmers;
 * FileName    : 튜플
 * Author      : sangeok
 * Date        : 2025. 09. 09.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 09.     sangeok               Initial creation
 */


import java.util.*;

class Solution {
    public int[] solution(String s) {

        List<List<Integer>> list = parse_tuple(s);

        int[] answer = new int[list.size()];

        list.sort((a, b) -> a.size() - b.size());

        Set<Integer> set = new HashSet<>();
        int i = 0;
        for (List<Integer> a : list) {
            for (int num : a) {
                if (!set.contains(num)) {
                    set.add(num);
                    answer[i] = num;
                    i++;
                }
            }
        }

        return answer;
    }

    public List<List<Integer>> parse_tuple(String s) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = null;
        StringBuilder num = null;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{') {
                current = new ArrayList<>();
            } else if (Character.isDigit(c)) {
                if (num == null) num = new StringBuilder();
                num.append(c);
            } else if (c == ',' || c == '}') {
                if (num != null) {
                    current.add(Integer.parseInt(num.toString()));
                    num = null;
                }
                if (c == '}' && current != null) {
                    result.add(current);
                    current = null;
                }
            }
        }

        return result;
    }

}
