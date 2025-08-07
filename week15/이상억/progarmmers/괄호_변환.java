/**
 * PackageName : week15.이상억.progarmmers;
 * FileName    : 괄호_변환
 * Author      : sangeok
 * Date        : 2025. 08. 07.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 07.     sangeok               Initial creation
 */

// 문제 잘 읽고 시키는대로 하자
class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return "";
        if (correct(p)) return p;

        String[] uv = split_balance(p);
        String u = uv[0];
        String v = uv[1];

        if (correct(u)) {
            return u + solution(v);
        } else {
            return "(" + solution(v) + ")" + reverse(u.substring(1, u.length() - 1));
        }
    }

    // 올바른 괄호 문자열 판단
    public boolean correct(String s) {
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else balance--;

            if (balance < 0) return false;
        }
        return balance == 0;
    }

    // 균형 잡힌 u,v 분리
    public String[] split_balance(String w) {
        int balance = 0;
        int idx = 0;

        for (; idx < w.length(); idx++) {
            if (w.charAt(idx) == '(') balance++;
            else balance--;

            if (balance == 0) break;
        }

        String u = w.substring(0, idx + 1);
        String v = w.substring(idx + 1);
        return new String[]{u, v};
    }

    // 괄호 반전
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }
}
