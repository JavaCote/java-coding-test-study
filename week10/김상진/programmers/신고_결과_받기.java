package week10.김상진.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 신고_결과_받기 {
    import java.util.*;

    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            Map<String, Set<String>> reportedMap = new HashMap<>();
            Map<String, Integer> mailCountMap = new HashMap<>();

            for (String id : id_list) {
                reportedMap.put(id, new HashSet<>());
                mailCountMap.put(id, 0);
            }

            for (String rep : report) {
                String[] parts = rep.split(" ");
                String reporter = parts[0];
                String reported = parts[1];
                // get으로 map의 key를 찾고 set에 reporter 추가
                reportedMap.get(reported).add(reporter);
            }

            for (String reported : reportedMap.keySet()) {
                // set 꺼내기
                Set<String> reporters = reportedMap.get(reported);
                if (reporters.size() >= k) {
                    for (String reporter : reporters) {
                        mailCountMap.put(reporter, mailCountMap.get(reporter) + 1);
                    }
                }
            }

            int[] answer = new int[id_list.length];
            for (int i = 0; i < id_list.length; i++) {
                answer[i] = mailCountMap.get(id_list[i]);
            }

            return answer;
        }
    }


}
