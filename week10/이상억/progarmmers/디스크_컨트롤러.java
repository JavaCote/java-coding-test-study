/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 디스크_컨트롤러
 * Author      : sangeok
 * Date        : 2025. 07. 01.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 01.     sangeok               Initial creation
 */


// 작업 소요시간 짧은 것 >> 작업 요청시각 빠른 것 >> 작업의 번호가 작은 것 순
// 한번 하면 마칠 때 까지 그거만 함 / 마치자 마자 바로 다른 작업 가능
// jobs -> [ 작업이 요청되는 시점, 작업의 소요 시간]


// 다음 작업으로 넘어갈 때 연속적으로 넘어가는데 아니라 8에 끝나고 다음 작업이 14 이런식일 수도 있는데 반환시간 계산을
// 연속적인 부분만 고려해서 그 부분에서 좀 헤맸었다.

// 문제 자체는 그 요즘 정처기 공부하고 있는데 비선점 스케줄링 내용이여서 문제를 이해하는데 있어 어렵지 않았다. 3단계는 처음 풀어보는데 힙 알고리즘 관련이라 그런가 할만했다.
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        int[][] jobsWithIndex = new int[jobs.length][3];

        for (int i = 0; i < jobs.length; i++) {
            jobsWithIndex[i][0] = jobs[i][0];
            jobsWithIndex[i][1] = jobs[i][1];
            jobsWithIndex[i][2] = i;          // 작업 번호 (인덱스)
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[1] != b[1]) return a[1] - b[1]; // 소요시간 짧은 순
                    if (a[0] != b[0]) return a[0] - b[0]; // 요청시각 빠른 순
                    return a[2] - b[2]; // 작업번호(작은 순)
                }
        );

        int returntime = 0; // 반환시간
        int time = 0; // 현재시간
        int jobcount = 0; // 작업 개수
        int idx = 0;  // 배열에서 아직 안넣은 작업 인덱스

        Arrays.sort(jobsWithIndex, (a, b) -> a[0] - b[0]); // 요청 시각 기준 정렬

        while (jobcount < jobs.length) {
            // 현재 시간 이전에 요청된 작업들을 pq에 삽입
            while (idx < jobs.length && jobsWithIndex[idx][0] <= time) {
                pq.offer(jobsWithIndex[idx]);
                idx++;
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                int requesttime = job[0];
                int duration = job[1];

                int starttime = Math.max(time,requesttime);
                time = starttime + duration;
                returntime += (time - requesttime); // (종료시각 - 요청시각)
                jobcount++;
            } else {
                time = jobsWithIndex[idx][0];
                continue;
            }
        }

        return returntime / jobs.length;
    }
}