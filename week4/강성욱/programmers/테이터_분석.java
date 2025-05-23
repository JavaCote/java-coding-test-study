package week4.강성욱.programmers;

import java.util.*;

public class 테이터_분석 {
    class Solution {
        private static final Map<String, Integer> FILTER_MAP = Map.of(
                "code", 0,
                "date", 1,
                "maximum", 2,
                "remain", 3
        );

        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
            List<int[]> dataList = new ArrayList<>(Arrays.asList(data));
            List<int[]> filtered = filterData(dataList, ext, val_ext);
            sortData(filtered, sort_by);
            return listToArray(filtered);
        }

        private List<int[]> filterData(List<int[]> data, String ext, int val_ext) {
            int index = FILTER_MAP.get(ext);
            List<int[]> result = new ArrayList<>();

            for (int[] row : data) {
                if (row[index] < val_ext) {
                    result.add(row);
                }
            }

            return result;
        }

        private void sortData(List<int[]> data, String sortBy) {
            int index = FILTER_MAP.get(sortBy);
            data.sort(Comparator.comparingInt(a -> a[index]));
        }

        private int[][] listToArray(List<int[]> list) {
            int[][] result = new int[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }
}
