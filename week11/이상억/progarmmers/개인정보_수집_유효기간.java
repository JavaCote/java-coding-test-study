/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 개인정보_수집_유효기간
 * Author      : sangeok
 * Date        : 2025. 07. 07.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 07.     sangeok               Initial creation
 */


import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsmap = new HashMap<>();
        List<Integer> validprivacies = new ArrayList<>();

        for (String k : terms) {
            String[] a = k.split(" ");
            String alphabet = a[0];
            int month = Integer.parseInt(a[1]);
            termsmap.put(alphabet, month);
        }

        int[] todayarr = parsedate(today);

        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            int[] startdate = parsedate(parts[0]);  // 수집일
            String type = parts[1];                 // 약관 종류

            int term = termsmap.get(type);
            int[] expiredate = addmonths(startdate, term);

            if (isexpired(expiredate, todayarr)) {
                validprivacies.add(i + 1); // 1-based index
            }
        }

        int[] answer = new int[validprivacies.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = validprivacies.get(i);
        }
        return answer;
    }

    // 날짜 쪼개기
    public int[] parsedate(String date) {
        String[] parts = date.split("\\.");
        return new int[]{
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2])
        };
    }

    public int[] addmonths(int[] date, int monthstoadd) {
        int year = date[0];
        int month = date[1] + monthstoadd;
        int day = date[2];

        year += (month - 1) / 12;
        month = (month - 1) % 12 + 1;

        return new int[]{year, month, day};
    }

    // 만료일 <= 오늘인지 비교
    public boolean isexpired(int[] expire, int[] today) {
        for (int i = 0; i < 3; i++) {
            if (expire[i] < today[i]) return true;
            if (expire[i] > today[i]) return false;
        }
        return true; // 동일 날짜일 경우도 만료 처리
    }
}
