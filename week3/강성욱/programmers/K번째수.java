package week3.강성욱.programmers;

import java.util.Arrays;

public class K번째수 {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int max = commands.length;
            int[] result = new int[max];

            for (int index = 0; index < max; index++) {
                int start = commands[index][0];
                int end = commands[index][1];
                int target = commands[index][2];

                int[] newArray = splitAndSort(array, start, end);
                result[index] = newArray[target - 1];
            }

            return result;
        }

        public int[] splitAndSort(int[] array, int start, int end) {
            int size = end - start + 1;
            int[] sliced = new int[size];

            for (int i = 0; i < size; i++) {
                sliced[i] = array[start - 1 + i];
            }

            Arrays.sort(sliced);

            return sliced;
        }
    }
}
