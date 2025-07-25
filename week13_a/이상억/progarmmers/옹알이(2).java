// aya,ye,woo,ma 밖에 발음 못함
// 연속 발음 x

import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        String[] speak = {"aya","ye","woo","ma"};

        for(String word : babbling){
            String tmp = word;

            for(String w : speak){ // 연속발음 안됨
                tmp = tmp.replace(w + w, "#");
            }

            for(String w : speak) { // 문자열 빈칸
                tmp = tmp.replace(w," ");
            }

            if(tmp.trim().isEmpty()){
                answer ++;
            }
        }
        return answer;
    }
}