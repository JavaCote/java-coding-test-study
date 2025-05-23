/**
 * PackageName : week4.이상억.progarmmers;
 * FileName    : 구명보트
 * Author      : sangeok
 * Date        : 2025. 5. 23.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 23.     sangeok               Initial creation
 */

// 문제 요구사항 : 	한번에 최대 2명
//                  구명보트를 최대한 적게 사용하여 많은 사람을 구하려고 함
//                  사람의 무게를 담은 배열 people / 구명 보트의 무게 제한 limit
//                  사람, 구명 보트 무게 40~240kg

//        접근 방식 : (1)	배열 정렬하고
//                          왼쪽과 오른쪽을 비교해서 limit 안넘으면 둘다 타는거고 넘으면 오른쪽 한사람만 타는거고

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int leftpeople = 0;
        int rightpeople = people.length - 1;

        while( leftpeople <= rightpeople ){
            int sum = people[leftpeople] + people[rightpeople];

            if (people[leftpeople] + people[rightpeople] <= limit) {
                leftpeople++;
                rightpeople--;
            } else {
                rightpeople--;
            }
            answer++;
        }

        return answer;
    }
}