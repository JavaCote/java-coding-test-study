package week6.강성욱.programmers;

import java.util.*;
public class 추억_점수 {
    //단순한 Map 활용 문제
    //주의할점은 예시에는 없지만, 문제 내용중에 그리움 점수가 없을 경우도 있다는 점.

    class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            Map<String, Integer> map = new HashMap<>();
            int[] result = new int[photo.length];

            for(int index=0; index < name.length; index++) {
                String nowName = name[index];
                int nowYearning = yearning[index];
                map.put(nowName, nowYearning);
            }

            for(int index=0; index<photo.length; index++) {
                int sum = 0;

                for(String now : photo[index]) {
                    sum += map.getOrDefault(now, 0);
                }
                result[index] = sum;
            }

            return result;
        }
    }
}
