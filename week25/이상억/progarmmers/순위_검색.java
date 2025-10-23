import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();

        for (String s : info) {
            String[] arr = s.split(" ");
            String[] cond = {arr[0], arr[1], arr[2], arr[3]};
            int score = Integer.parseInt(arr[4]);
            dfs(map, cond, 0, "", score);
        }

        for (ArrayList<Integer> list : map.values()) {
            Collections.sort(list);
        }

        // query 처리
        int[] answer = new int[query.length];
        int idx = 0;
        for (String q : query) {
            q = q.replaceAll(" and ", " ");
            String[] arr = q.split(" ");
            String key = arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " ";
            int score = Integer.parseInt(arr[4]);

            if (map.containsKey(key)) {
                ArrayList<Integer> list = map.get(key);
                int count = list.size() - lowerBound(list, score);
                answer[idx] = count;
            } else {
                answer[idx] = 0;
            }
            idx++;
        }

        return answer;
    }

    void dfs(Map<String, ArrayList<Integer>> map, String[] cond, int depth, String key, int score) {
        if (depth == 4) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }
        dfs(map, cond, depth + 1, key + cond[depth] + " ", score);
        dfs(map, cond, depth + 1, key + "- ", score);
    }

    int lowerBound(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
