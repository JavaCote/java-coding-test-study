package week2.강성욱.programmers;

import java.util.*;

public class 기능개발 {
    // 결국, 제일 맨앞에 작업 기준으로, 뒤에꺼가 더 큰거가 나올떄까지 전부 한번에 처리가 가능.
    // 그럼 작업이 끝나는걸 배열로 만들어두면 될듯?
        // 이거 나누기로 계산할때 올림처리 반드시 해야됨.
        // 95펀데, 3퍼씩 작업 가능하면, 2일임. 나누기하면 1.666 나올껀데, 2일 걸리는거임.
    // 그러고, 반복문으로 start-end 로부터 새로운 배열을 copy 떠서, copy 할게 없을때까지 반복하면 될듯?

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> result = new ArrayList<>();

            // 완료 일자 계산.
            int[] days = new int[progresses.length];
            for (int i = 0; i < progresses.length; i++) {
                int remain = 100 - progresses[i];
                int day = (int) Math.ceil((double) remain / speeds[i]);
                days[i] = day;
            }

            // 앞에서 부터 배포 진행.
            int current = days[0];
            int count = 1;

            // 어짜피 0 배열은 무조건이니, 1부터 시작
            for (int i = 1; i < days.length; i++) {
                if (days[i] <= current) {
                    count++;
                } else {
                    result.add(count);
                    current = days[i];
                    count = 1;
                }
            }
            result.add(count);

            return result.stream().mapToInt(i -> i).toArray();
        }
    }
}
