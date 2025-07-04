package week2.강성욱.programmers;

import java.time.LocalDate;

public class 문제_2016년 {
    class Solution {
        public String solution(int a, int b) {
            //enum 은 1부터 시작.
            // date.getDayOfWeek().getValue() 로 꺼내온 값은 Monday 부터 1로 시작.
            // https://docs.oracle.com/javase/8/docs/api/
            String[] days = {"", "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
            LocalDate date = LocalDate.of(2016, a, b);
            return days[date.getDayOfWeek().getValue()];
        }
    }
}
