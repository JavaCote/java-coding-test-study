package week5.김나은.programmers;

import java.util.Arrays;

public class 구명보트 {

    class Solution {

        public int solution(int[] people, int limit) {
            int answer = 0;

            // 사람들의 몸무게를 오름차순으로 정렬
            Arrays.sort(people);
            // 가장 가벼운 사람의 인덱스
            int min = 0;

            // max는 가장 무거운 사람의 인덱스부터 시작해서 점점 앞으로 이동
            for (int max = people.length - 1; min <= max; max--) {
                // 가장 가벼운 사람(min)과 가장 무거운 사람(max)을 같이 태울 수 있는 경우
                if (people[min] + people[max] <= limit) {
                    min++; // 가벼운 사람도 태웠으니 다음으로 이동
                }
                answer++; // 무거운 사람은 무조건 태우기 때문에 보트 1대 추가
            }

            return answer; // 총 필요한 보트 수 반환
        }
    }
}