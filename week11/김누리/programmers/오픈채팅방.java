package week11.김누리.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PackageName : week11.김누리.programmers
 * FileName    : 오픈채팅방
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-07
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 07.     김누리(NRKim)               Initial creation
 */

/*

record =
    [
        "Enter uid1234 Muzi",
        "Enter uid4567 Prodo",
        "Leave uid1234",
        "Enter uid1234 Prodo",
        "Change uid4567 Ryan"
    ]

    동작 / uuid/ nick

    swithc (동작) :
    case "Enter" :
        nickname = map.getOrDefault(uuid,"");
        System.out.println(nickname + "님이 들어왔습니다.");

    case "Leave" :
        nickname = map.getOrDefault(uuid,"");
        System.out.println(nickname + "님이 나갔습니다.");


*/

public class 오픈채팅방 {
	public String[] solution(String[] record) {

		//  map {uuid = nickname}
		Map<String,String> map = new HashMap<>();
		List<String[]> list = new ArrayList<>();

		for(String r : record) {
			//  시스템 기록 분해
			String[] tmp = r.split(" ");

			String act = tmp[0];       //  동작
			String uuid = tmp[1];      //  고유 ID

			if(tmp.length > 2) {
				//  act가 Leave인 경우 act, uuid 만 들어오기 때문에, Leave 이외의 경우에만 uuid, nickname 셋팅 해야함
				String nickname = tmp[2]; // 닉네임
				map.put(uuid,nickname);
			}

			switch(act) {
				case "Enter" :
					//  uuid 별 닉네임 셋팅
					list.add(new String[] {uuid,"님이 들어왔습니다."});
					break;

				case "Leave" :
					list.add(new String[] {uuid,"님이 나갔습니다."});
					break;
			}
		}


		int idx = 0;
		String[] answer = new String[list.size()];

		for(String[] s : list) {
			String nickname = map.get(s[0]);
			answer[idx++] = nickname + s[1];
		}

		return answer;
	}
}
