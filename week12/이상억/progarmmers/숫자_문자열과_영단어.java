/**
 * PackageName : week12.이상억.progarmmers;
 * FileName    : 숫자_문자열괴_영단어
 * Author      : sangeok
 * Date        : 2025. 07. 12.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 12.     sangeok               Initial creation
 */



import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Map<String, Integer> numbermap = new HashMap<>();
        numbermap.put("zero", 0);
        numbermap.put("one", 1);
        numbermap.put("two", 2);
        numbermap.put("three", 3);
        numbermap.put("four", 4);
        numbermap.put("five", 5);
        numbermap.put("six", 6);
        numbermap.put("seven", 7);
        numbermap.put("eight", 8);
        numbermap.put("nine", 9);

        for (String key : numbermap.keySet()) {
            s = s.replaceAll(key, numbermap.get(key).toString());
        }

        answer = Integer.parseInt(s);
        return answer;
    }
}
