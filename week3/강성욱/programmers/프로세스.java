package week3.강성욱.programmers;

import java.util.*;

public class 프로세스 {
        //[A:2, B:1, C:3, D:2]
    //1step
        //A를 꺼냈으나, 뒤에 우선순위가 더 높은 C가 있으니, 다시 맨뒤로 빠꾸
        //[B:1, C:3, D:2, A:2]
    //2step
        //B를 꺼냈으나, 뒤에 우선순위가 더 높은 C가 있으니, 다시 맨뒤로 빠꾸
        //[C:3, D:2, A:2, B:1]
    //3step
        //C꺼냈을때, 이게 제일 우선순위 높으니, 이거 실행
        //[D:2, A:2, B:1]
        //실행완료 : C,
    //4step
        //D 꺼냈는데, 이게 젤 높음. 실행
        //[A:2, B:1]
        //실행 완료 : C, D
    //... 이렇게 c d a b 인건가?
    //어짜피 실행 순서는 숫자가 높은순서인데, 문제는 같은 실행 순서가 있다면, 먼저 어떤 프로세스가 처리될지 엄격하게 관리해야됨.
    // 즉, 모든걸 pq 로 처리할 수는 없음.
    // 복합적으로 pq 도 관리하고 일반 queue 도 관리해야됨.

    class Solution {
        public int solution(int[] priorities, int location) {
            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < priorities.length; i++) {
                queue.add(new int[]{i, priorities[i]});
                pq.add(priorities[i]);
            }

            int count = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentIndex = current[0];
                int currentPriorites = current[1];

                // 현재 프로세스의 우선순위가 제일 높은 우선순위가 아니면 다시뒤로빠꾸
                if (currentPriorites < pq.peek()) {
                    queue.add(new int[]{currentIndex, currentPriorites});
                } else {
                    // 만약 현재 프로세스의 우선순위가 젤 높은 우선순위일경우.
                    count++; //실행 count ++
                    pq.poll();

                    // 만약 이번에 실행된게 찾는 프로세스면 return
                    if (currentIndex == location) {
                        return count;
                    }
                }
            }

            return -1;
        }
    }
}
