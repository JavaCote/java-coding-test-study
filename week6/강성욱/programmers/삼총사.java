package week6.강성욱.programmers;

public class 삼총사 {
    //만약 3중 반복문으로 구한다면?
    //최대 13개
    //13^3 = 2179개 케이스
    //실제로는 조합을 구해야하기 때문에 케이스는 훨신 적음
    //13 * 12 * 11
    //할만함.
    //---
    //반복문의 사이즈가 정해져있기 때문, 일반 3중 반복문으로 해결
    class Solution {
        public int solution(int[] number) {
            int count = 0;
            int max = number.length;

            for(int first=0; first < max; first++) {
                for(int second = first+1; second < max; second++) {
                    for(int third = second+1; third < max; third++) {
                        if(number[first] + number[second] + number[third] == 0) {
                            count++;
                        }
                    }
                }
            }

            return count;
        }
    }
}
