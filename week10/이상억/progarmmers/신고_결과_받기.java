/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 신고_결과_받기
 * Author      : sangeok
 * Date        : 2025. 6. 27.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 27.     sangeok               Initial creation
 */

// 문제 요구사항 :    각 유저는 한번에 한명의 유저 신고 -> 신고 횟수 제한 x , 동일한 유저 신고 횟수는 1회로 처리
//                  k 번 이상 신고된 유저는 게시판 이용이 정지 -> 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 정지메일 발송
//              정지시키면 신고한 사용자에게 메일 보냄
//

// 접근 방식 : (1) hashmap + hashset 조합 사용

// Hash 에 대한 공부를 하기 좋았던 문제였던 것 같다.. 근데 좀 코드가 길게 작성되어서 귀찮기는 했다.
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
        int[] answer = new int[len];

        Map<String,Set<String>> map = new HashMap<>(); // 누가 누구 신고 했는지 등록

        for(String s : report) {

            String[] parts = s.split(" ");
            String reporter = parts[0];
            String reported = parts[1];

            if (!map.containsKey(reporter)) map.put(reporter, new HashSet<>());

            map.get(reporter).add(reported);
        }

        Map<String,Integer> countmap = new HashMap<>(); // 신고당한 사람이 몇번 당했는지 세기 위해
        for(Set<String> edlist : map.values()){
            for(String ed : edlist){
                countmap.put(ed, countmap.getOrDefault(ed,0) + 1);
            }
        }

        Map<String,Integer> mailmap = new HashMap<>(); // 메일 보내기 위해 등록
        for(String er : map.keySet()){
            for(String ed : map.get(er)){
                if(countmap.getOrDefault(ed,0) >= k) {
                    mailmap.put(er,mailmap.getOrDefault(er,0)+1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailmap.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}