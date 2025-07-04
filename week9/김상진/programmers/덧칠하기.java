package week9.김상진.programmers;

public class 덧칠하기 {
    class Solution {
        public int solution(int n, int m, int[] section) {
            // m길이 만큼의 슬라이딩 윈도우
            // 가장왼쪽에서부터 칠해지지 않은 구간 + m 만큼은 모두 칠하기
            int answer = 1;
            int index=section[0]+m-1;

            for(int i=0; i<section.length; i++){
                if(section[i]>index){
                    index=section[i]+m-1;
                    answer++;
                }
            }
            return answer;
        }
    }

}
