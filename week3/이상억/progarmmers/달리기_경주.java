package week3.이상억.progarmmers;

/**
 * PackageName : week3.이상억.progarmmers;
 * FileName    : 달리기_경주
 * Author      : sangeok
 * Date        : 2025. 5. 12.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 12.     sangeok               Initial creation
 */


// 문제 요구사항 : 이름이 한번 불리면 앞 사람 추월

// 접근 방식 : (1)
// 1) players의 value : index 저장
// 2) callings 시 앞 players와 인덱스 변경

// 회고 : Hash 관련 메소드 아직 익숙하지 않음

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> players_list = new HashMap<>();

        // 등록
        for (int i = 0; i < players.length; i++) {
            players_list.put(players[i], i);
        }

        // 불린 플레이어와 그 앞 플레이어 이름 및 등수 교환
        for(String calledplayers : callings){
            int current_rank = players_list.get(calledplayers);

            String front_players = players[current_rank-1];
            players[current_rank-1] = calledplayers;
            players[current_rank] = front_players;

            players_list.put(calledplayers,current_rank -1);
            players_list.put(front_players,current_rank);

        }
        return players;
    }
}

