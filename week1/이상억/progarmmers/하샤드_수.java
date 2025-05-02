package week1.이상억.progarmmers;

/**
 * PackageName : week1.이상억.programmers
 * FileName    : 하샤드_수
 * Author      : sangeok
 * Date        : 2025. 4. 30.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 30.     sangeok               Initial creation
 */



class Solution {
    public boolean solution(int x) {

        String s = String.valueOf(x);
        int a = 0;

        for(int i = 0 ; i < s.length(); i++ ){
            a += s.charAt(i)-'0';
        }


        return ( x % a == 0) ? true : false ;
    }
}