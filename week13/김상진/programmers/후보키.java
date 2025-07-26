package week13.김상진.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 후보키 {
    import java.util.*;

    class Solution {
        public int solution(String[][] relation) {
            int rowSize = relation.length;
            int colSize = relation[0].length;

            List<Integer> candidateKeys = new ArrayList<>();

            for (int mask = 1; mask < (1 << colSize); mask++) {
                Set<String> tupleSet = new HashSet<>();

                for (int r = 0; r < rowSize; r++) {
                    String key = "";
                    for (int c = 0; c < colSize; c++) {
                        if (((mask >> c) & 1) == 1) {
                            key += relation[r][c];
                        }
                    }
                    tupleSet.add(key);
                }

                if (tupleSet.size() != rowSize) {
                    continue;
                }

                boolean isMinimal = true;
                for (int existingKey : candidateKeys) {
                    if ((mask & existingKey) == existingKey) {
                        isMinimal = false;
                        break;
                    }
                }

                if (isMinimal) {
                    candidateKeys.add(mask);
                }
            }

            return candidateKeys.size();
        }
    }

}
