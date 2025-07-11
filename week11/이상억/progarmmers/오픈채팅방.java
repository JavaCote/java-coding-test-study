/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 오픈채팅방
 * Author      : sangeok
 * Date        : 2025. 07. 05.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 05.     sangeok               Initial creation
 */


// Enter [유저 아이디] [닉네임]
// 첫 단어 Enter, Leave, Change

// Hashmap으로 아이디, 닉네임 등록

// 문제를 대충 읽어 추후 변경 되면 다 기존의 message 가 다 변경 되는지 모르고 풀었다.
// 문제를 읽고서 바로 든 생각은 hashmap을 둬서 id 와 nickname을 관리하면 되겠다 라는 생각이 바로 들었다.
// 이 문제도 조건을 잘 파악하고 지문만 읽어도 어떠한 방향으로 풀어야할지 감이 잘 와서 할만했던 것 같다.
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> usermap = new HashMap<>();
        List<String[]> list = new ArrayList<>();

        for (String s : record) {
            String[] parts = s.split(" ");
            String command = parts[0];
            String id = parts[1];

            if (command.equals("Enter")) {
                String nickname = parts[2];
                usermap.put(id, nickname);
                list.add(new String[]{id, "Enter"});
            } else if (command.equals("Leave")) {
                list.add(new String[]{id, "Leave"});
            } else if (command.equals("Change")) {
                String nickname = parts[2];
                usermap.put(id, nickname);
            }
        }

        String[] answer = new String[list.size()];
        int idx = 0;
        for (String[] action : list) {
            String id = action[0];
            String command = action[1];
            String nickname = usermap.get(id);

            if (command.equals("Enter")) {
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else if (command.equals("Leave")) {
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
