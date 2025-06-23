package week8_a.김상진.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * PackageName : week8_a.김상진.programmers FileName    : 롤케이크_자르기 Author      : sangxxjin Date : 2025.
 * 6. 23. Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 23.     sangxxjin               Initial creation
 */
public class 롤케이크_자르기 {
    // 잘랐을떄 종류의 개수가 같아야함
    // topping의 길이 1,000,000 -> 2중 for문 x
    // set사용 -> 앞에서부터 set넣고 짜르고 뒤에꺼 계산? -> 시간초과 -> 1차 구현
    // 전부 set에 넣고 앞에서부터 추가하면서 전체set의 절반이 되면 통과 -> 구현이 안됌 -> 2차 구현
    // 음..
    // 전체를 map(종류 갯수)를 담고 배열 순서대로 돌면서 map의 개수를 하나씩 줄이면서 set에 담기 -> 3차 구현
import java.util .*;

    class Solution {

        public int solution(int[] topping) {

            int answer = 0;
            Set<Integer> first = new HashSet<>();
            for (int i = 0; i < topping.length; i++) {
                Set<Integer> second = new HashSet<>();
                first.add(topping[i]);
                for (int j = i + 1; j < topping.length; j++) {
                    second.add(topping[j]);
                }
                if (first.size() == second.size()) {
                    answer++;
                }
            }
            return answer;
        }
    }
import java.util .*;

    class Solution {

        public int solution(int[] topping) {
            int answer = 0;
            Set<Integer> all = new HashSet<>();
            Set<Integer> set = new HashSet<>();
            for (int i : topping) {
                all.add(i);
            }
            for (int i : topping) {
                set.add(i);
                if ((double) set.size() == (double) all.size() / 2) {
                    answer++;
                }
            }

            return answer;
        }
    }
import java.util .*;

    class Solution {

        public int solution(int[] topping) {
            int answer = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : topping) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < topping.length; i++) {
                int t = topping[i];
                set.add(t);
                map.put(t, map.get(t) - 1);
                if (map.get(t) == 0) {
                    map.remove(t);
                }
                if (set.size() == map.size()) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
