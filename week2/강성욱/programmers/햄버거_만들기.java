package week2.강성욱.programmers;

import java.util.*;

public class 햄버거_만들기 {
    // 계속 쌓이다가, 마지막 빵이 들어온다면, pop x 4 하면 될듯
    // 그럼 stack 을 사용하면 어떨까?
    // list 를 사용해도 큰 문제는 없을듯?
        // 근데 List 를 쓰면, 넣고 뺏을때, 안에 값을 지우고 다시 땡겨주고 하는 과정이 조금 귀찮을 것 같음.
    class Solution {
        public int solution(int[] ingredient) {
            Stack<Integer> buffer = new Stack<>();
            int count = 0;

            //재료 쌓기
            for(int now : ingredient) {
                buffer.push(now);

                //4개가 가득 차면, 마지막 위에꺼 4개 확인
                int nowCount = buffer.size();
                if(nowCount >= 4) {
                    if(
                            buffer.get(nowCount-1) == 1 && //빵
                                    buffer.get(nowCount-2) == 3 && //고기
                                    buffer.get(nowCount-3) == 2 && //야채
                                    buffer.get(nowCount-4) == 1 //빵
                    ) {
                        count++;
                        for(int i=0; i<4; i++) buffer.pop();
                    }
                }
            }
            //마지막에 한번더 쳌? 할필요없음. 구조상

            return count;
        }
    }
}
