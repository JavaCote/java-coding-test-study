package week2.이상억.progarmmers;

/**
 * PackageName : week2.이상억.programmers
 * FileName    : 2016년
 * Author      : sangeok
 * Date        : 2025. 5. 8.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 8.     sangeok               Initial creation
 */


class Solution {
    public String solution(int a, int b) {
        String answer = "";


        String[] weekday = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int totaldays = -1;
        for(int i = 0 ; i < a - 1 ; i ++) totaldays += days[i];

        return weekday[((totaldays+b)%7)];

    }
}