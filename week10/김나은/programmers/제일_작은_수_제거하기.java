package week10.김나은.programmers;

import java.util.ArrayList;

public class 제일_작은_수_제거하기 {

    class Solution {

        public int[] solution(int[] arr) {

            // 빈 배열인 경우 -1 값을 채워서 return
            if (arr.length == 1) {
                return new int[]{-1};
            }

            // 가장 작은 수를 찾기 위해 배열 값들을 순회하며 비교
            int min = arr[0];
            for (int num : arr) {
                if (num < min) {
                    min = num;
                }
            }

            // 가장 작은 값을 제거하기 위해, ArrayList로 새로운 배열 생성
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : arr) {
                if (num != min) {
                    list.add(num);
                }
            }

            //ArrayList를 int 배열로 변환
            int[] answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}