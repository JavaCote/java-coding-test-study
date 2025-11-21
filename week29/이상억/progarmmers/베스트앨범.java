import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreSum = new HashMap<>();
        Map<String, List<int[]>> genreMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            // 총 재생수 누적
            genreSum.put(g, genreSum.getOrDefault(g, 0) + p);

            if (!genreMap.containsKey(g)) {
                genreMap.put(g, new ArrayList<>());
            }

            // 재생수, 고유번호
            genreMap.get(g).add(new int[]{p, i});
        }

        List<String> genreList = new ArrayList<>(genreSum.keySet());
        genreList.sort((a, b) -> genreSum.get(b) - genreSum.get(a));

        List<Integer> result = new ArrayList<>();

        for (String g : genreList) {
            List<int[]> list = genreMap.get(g);

            list.sort((a, b) -> {
                if (b[0] != a[0]) return b[0] - a[0];
                return a[1] - b[1];
            });

            // 2개까지
            result.add(list.get(0)[1]);
            if (list.size() > 1) {
                result.add(list.get(1)[1]);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
