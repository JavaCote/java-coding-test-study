import java.util.*;

class Solution {
    public String[] solution(String[] files) {

        Arrays.sort(files, (f1, f2) -> {
            String[] p1 = splitName(f1);
            String[] p2 = splitName(f2);

            // HEAD 비교 (대소문자 무시)
            int headCompare = p1[0].compareToIgnoreCase(p2[0]);
            if (headCompare != 0) return headCompare;

            // NUMBER 비교 (정수값으로)
            int num1 = Integer.parseInt(p1[1]);
            int num2 = Integer.parseInt(p2[1]);
            return num1 - num2;  // 같으면 입력 순서 유지(안정 정렬)
        });

        return files;
    }

    private String[] splitName(String file) {
        String head = "";
        String number = "";
        String tail = "";

        int i = 0;
        while (i < file.length() && !Character.isDigit(file.charAt(i))) {
            head += file.charAt(i);
            i++;
        }

        int cnt = 0;
        while (i < file.length() && Character.isDigit(file.charAt(i)) && cnt < 5) {
            number += file.charAt(i);
            i++;
            cnt++;
        }

        if (i < file.length()) {
            tail = file.substring(i);
        }

        return new String[]{head, number, tail};
    }
}
