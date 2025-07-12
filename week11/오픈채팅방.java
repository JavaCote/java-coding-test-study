package week11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PackageName : week11
 * FileName    : 오픈채팅방
 * Author      : Baekgwa
 * Date        : 2025-07-07
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-07     Baekgwa               Initial creation
 */
public class 오픈채팅방 {
	//enter 명령어와, leave 명령어는 따로 뽑아둘것.
	//uid 기준으로, 닉네임을 마지막까지 최신화 해둘것

	class Solution {
		public String[] solution(String[] record) {

			List<ChatLog> chatLogList = new ArrayList<>();
			Map<String, String> nicknameMap = new HashMap<>(); // key : uid, name : 닉네임 (최신화 할 것)

			for(String rec : record) {
				String[] orderArray = rec.split(" ");
				String order = orderArray[0];
				String uid = orderArray[1];

				// 새로 들어오거나, 이름을 바꾸었다면, nicknameMap 에 최신화 진행
				if(order.equals("Enter") || order.equals("Change")) {
					nicknameMap.put(uid, orderArray[2]);
				}

				//들어오거나, 나가는 사람 채팅 로그용 저장.
				if(order.equals("Enter") || order.equals("Leave")) {
					chatLogList.add(new ChatLog(order, uid));
				}
			}

			String[] result = new String[chatLogList.size()];

			for(int i=0; i<chatLogList.size(); i++) {
				String str = chatLogList.get(i).getOrder().equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.";
				result[i] = nicknameMap.get(chatLogList.get(i).getUid()) + str;
			}

			return result;
		}

		private static class ChatLog {
			private String order; //Leave, Enter
			private String uid; //회원 고유 uid

			public ChatLog(String order, String uid) {
				this.order = order;
				this.uid = uid;
			}

			public String getOrder() { return this.order; }
			public String getUid() { return this.uid; }
		}
	}
}
