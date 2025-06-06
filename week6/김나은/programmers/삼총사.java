package week6.김나은.programmers;

public class 삼총사 {

    class Solution {

        public int solution(int[] number) {
            int answer = 0;

            for (int i = 0; i < number.length - 2; i++) {
                for (int j = i + 1; j < number.length - 1; j++) {
                    for (int k = j + 1; k < number.length; k++) {
                        if (number[i] + number[j] + number[k] == 0) {
                            answer++;
                        }
                    }
                }
            }

            return answer;
        }
    }
}

// for문을 여러번 사용해야할 것 같아서 다른 방법을 시도해보고 싶었는데, 일단 구글링 없이 풀 수 있는 방법으로 시도해봤다.
