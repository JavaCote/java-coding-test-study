package week4.강성욱.programmers;

import java.util.*;
public class 체육복 {
    //기본 배열에서, lost 기반으로 true false, 배열을 관리
    //true 는 있음, false 는 없음.
    //reserve 배열을 돌며 확인.
    //reserve 는 정렬되서 들어온다는 말이 없으니, 정렬 먼저 처리. 오름차순으로 그냥 하자.
    //EX) 1, 3, 5...
    //그럼 확인을 하는데, 앞에서->뒤로 하기때문에, 앞, 뒤 확인 빌려줄 수 있는지 확인.
    //만약 빌려 줄 수 있다면, 배열 true 처리
    //30명이 최대라, 시간복잡도는 어떻게 해도 2중for를 돌려도, 안전빵이니 그냥 구현하자.

    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            boolean[] student = new boolean[n + 1]; // 1~n
            Arrays.fill(student, true);

            Set<Integer> lostSet = new HashSet<>();
            Set<Integer> reserveSet = new HashSet<>();

            for (int l : lost) {
                lostSet.add(l);
            }

            for (int r : reserve) {
                // 여벌 있는데 도난도 당한 경우 → 자기만 입을 수 있음
                if (lostSet.contains(r)) {
                    lostSet.remove(r); // 둘 다에서 제거
                } else {
                    reserveSet.add(r);
                }
            }

            // 도난만 당한 학생들 false 처리
            for (int l : lostSet) {
                student[l] = false;
            }

            // 여벌만 있는 애들이 빌려줌
            for (int r : reserveSet) {
                if (r > 1 && !student[r - 1]) {
                    student[r - 1] = true;
                } else if (r < n && !student[r + 1]) {
                    student[r + 1] = true;
                }
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (student[i]) count++;
            }

            return count;
        }
    }
}
