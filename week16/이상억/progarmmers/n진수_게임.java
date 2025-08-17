/**
 * PackageName : week16.이상억.progarmmers;
 * FileName    : n진수_게임
 * Author      : sangeok
 * Date        : 2025. 08. 12.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 12.     sangeok               Initial creation
 */


// 진법 : n , 미리 구할 숫자의 갯수 : t , 게임에 참여하는 인원 : m , 튜브의 순서 : p
// Integer.toString 검색 안했으면 되게 힘들게 풀었거나 못풀었을듯 ..

import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {

        StringBuilder sb = new StringBuilder();
        int a = 0;

        while(sb.length() < t * m ){
            sb.append(Integer.toString(a++,n).toUpperCase());
        }

        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < t; i++){
            answer.append(sb.charAt((p-1) + i * m));
        }
        return answer.toString();
    }
}