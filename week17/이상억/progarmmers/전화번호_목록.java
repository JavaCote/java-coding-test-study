/**
 * PackageName : week17.이상억.progarmmers;
 * FileName    : 전화번호_목록
 * Author      : sangeok
 * Date        : 2025. 08. 20.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 20.     sangeok               Initial creation
 */


import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> number_set = new HashSet<>();

        for(String number : phone_book){
            number_set.add(number);
        }

        for(String number : phone_book){
            for(int i = 1; i < number.length(); i++){
                String pre = number.substring(0,i);

                if(number_set.contains(pre)) return false;
            }
        }
        return answer;
    }
}