package week11.김상진.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class 오픈채팅방 {
import java.util.*;

    class Solution {
        public List<String> solution(String[] record) {
            Map<String, String> userNicknames = new HashMap<>();

            for (String rec : record) {
                String[] parts = rec.split(" ");
                String command = parts[0];
                String userId = parts[1];

                if (command.equals("Enter") || command.equals("Change")) {
                    String nickname = parts[2];
                    userNicknames.put(userId, nickname);
                }
            }


            List<String> messageList = new ArrayList<>();
            for (String rec : record) {
                String[] parts = rec.split(" ");
                String command = parts[0];
                String userId = parts[1];


                String finalNickname = userNicknames.get(userId);

                if (command.equals("Enter")) {
                    messageList.add(finalNickname + "님이 들어왔습니다.");
                } else if (command.equals("Leave")) {
                    messageList.add(finalNickname + "님이 나갔습니다.");
                }

            }
            return messageList;
        }
    }
}
