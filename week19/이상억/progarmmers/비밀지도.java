/**
 * PackageName : week19.이상억.progarmmers;
 * FileName    : 비밀지도
 * Author      : sangeok
 * Date        : 2025. 09. 03.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 03.     sangeok               Initial creation
 */


import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String binary1 = number_binary(arr1[i], n);
            String binary2 = number_binary(arr2[i], n);

            String map1 = binary_Map(binary1);
            String map2 = binary_Map(binary2);

            answer[i] = merge(map1, map2);
        }
        return answer;
    }

    public String number_binary(int num, int length) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) sb.append("0");

        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }
        sb.reverse();

        while (sb.length() < length) {
            sb.insert(0, "0");
        }

        return sb.toString();
    }

    public String merge(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '#' || s2.charAt(i) == '#') {
                sb.append('#');
            } else {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public String binary_Map(String binary) {
        StringBuilder sb = new StringBuilder();
        for (char c : binary.toCharArray()) {
            if (c == '1') sb.append('#');
            else sb.append(' ');
        }
        return sb.toString();
    }
}
