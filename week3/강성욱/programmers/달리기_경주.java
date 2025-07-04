package week3.강성욱.programmers;

import java.util.*;

public class 달리기_경주 {
    class Solution {

        public String[] solution(String[] players, String[] callings) {
            Map<String, Integer> mp = new HashMap<>();

            int i = 0;
            for(String a : players){
                //현재 등수를 map으로 저장.
                mp.put(a, i);
                i++;
            }

            //불린 횟수만큼 반복할꺼임.
            for(String called : callings){
                int calledGrade = mp.get(called);
                if(calledGrade == 0){
                    continue;
                    //이미 1등이면 아무것도 할 필요 없음.
                }
                int nextGrade = calledGrade - 1;

                //map 에도 swap된 데이터로 value 최신화 필요
                mp.put(players[calledGrade], nextGrade);
                mp.put(players[nextGrade], calledGrade);

                //이제 둘이 swap 시킬것.
                String temp = null;
                temp = players[calledGrade];
                players[calledGrade] = players[nextGrade];
                players[nextGrade] = temp;
            }

            return players;
        }
    }
}
