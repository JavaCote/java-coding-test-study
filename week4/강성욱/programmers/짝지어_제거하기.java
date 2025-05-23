package week4.강성욱.programmers;

import java.util.*;

public class 짝지어_제거하기 {
    //문자 출현 개수로 파악?
    //a 2개, b 1개 면 짝짓기 실패
    //근데, 이경우, abab 도 짝짓기 성공이 됨. 결국 케이스를 확인해야됨.
    //-----------
    //한번에 빡 모든 문자열을 다 집어넣고, 모든 index 에 대해 앞뒤로 검사를 한다면
    //1,000,000 ^ 2 니깐, 너무 시간 복잡도 감당이 안됨.
    //그냥 1,000,000 개를 하나씩 받아서 stack 처럼 pop 시키면 될듯?
    //step1) a
    //a
    //step2) b
    //ab
    //step3) a
    //aba
    //step4) a
    //ab
    //step5) b
    //a
    //즉, 한번에 터지지 말고, 애니팡처럼 들어온 순서대로 터지게 하자.

    class Solution {
        public int solution(String s) {
            Deque<Character> stack = new ArrayDeque<>();

            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peekLast() == c) {
                    stack.pollLast();
                } else {
                    stack.addLast(c);
                }
            }

            return stack.isEmpty() ? 1 : 0;
        }
    }
}
