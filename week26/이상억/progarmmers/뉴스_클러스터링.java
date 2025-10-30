import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> m1 = make_set(str1);
        Map<String, Integer> m2 = make_set(str2);

        if (m1.isEmpty() && m2.isEmpty()) {
            return 65536;
        }

        int interSize = 0; // 교집합
        int unionSize = 0; // 합집합

        Set<String> allKeys = new HashSet<>();

        allKeys.addAll(m1.keySet());
        allKeys.addAll(m2.keySet());

        for (String key : allKeys) {
            int c1 = m1.getOrDefault(key, 0);
            int c2 = m2.getOrDefault(key, 0);

            interSize += Math.min(c1, c2);
            unionSize += Math.max(c1, c2);
        }

        double jaccard = (double) interSize / (double) unionSize;
        return (int) Math.floor(jaccard * 65536.0);
    }

    public Map<String, Integer> make_set(String s) {
        Map<String, Integer> map = new HashMap<>();
        s = s.toLowerCase();

        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);

            if (Character.isLetter(a) && Character.isLetter(b)) {
                String token = "" + a + b; // 두 글자 묶기

                map.put(token, map.getOrDefault(token, 0) + 1);
            }
        }

        return map;
    }
}
