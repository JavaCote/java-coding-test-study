package week10.강성욱.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * PackageName : week10.강성욱.programmers
 * FileName    : 디스크_컨트롤러
 * Author      : Baekgwa
 * Date        : 2025-07-02
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-02     Baekgwa               Initial creation
 */
public class 디스크_컨트롤러 {
	// 소요시간이 짧은 것, 작업 요청 시각이 빠른것, 작업의 번호가 작은 것이 우선순위
	// 입력 jobs 가 정렬? 되어있어야함 = 시점 0번 인덱스 순으로 오름차순
	// for문쓰니, 조건 분기가 너무 많음
	// 현재 시간 기준으로, 들어온 jobs 들을 모두 queue 에 넣어야됨.
	// 다 넣고 난뒤, 비어있지 않다면 힙에서 꺼내 쓰고, 종료 시간 계산해서 현재 시간으로 맞추고 루프 돌리기

	class Solution {
		public int solution(int[][] jobs) {
			int totalCount = jobs.length;

			Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
			PriorityQueue<Job> heap = new PriorityQueue<>();

			int time = 0;
			int index = 0;
			int completeCount = 0;
			int completeTimeSum = 0;

			while (completeCount < totalCount) {
				// 1) 현재 시간까지 요청된 모든 작업 heap에 추가
				while (index < totalCount && jobs[index][0] <= time) {
					heap.add(new Job(jobs[index][1], jobs[index][0], index));
					index++;
				}
				// 2) heap에 실행할 작업이 있다면
				if (!heap.isEmpty()) {
					Job cur = heap.poll();
					time += cur.workingTime;
					completeTimeSum += (time - cur.requestTime);
					completeCount++;
				} else {
					// 3) 작업 없으면 시간 점프
					if (index < totalCount) time = jobs[index][0];
				}
			}
			return completeTimeSum / totalCount;
		}

		private class Job implements Comparable<Job> {
			private int workingTime;
			private int requestTime;
			private int jobNo;

			public Job(int workingTime, int requestTime, int jobNo) {
				this.requestTime = requestTime;
				this.workingTime = workingTime;
				this.jobNo = jobNo;
			}

			@Override
			public int compareTo(Job o) {
				if(this.workingTime != o.workingTime) return this.workingTime - o.workingTime;
				if(this.requestTime != o.requestTime) return this.requestTime - o.requestTime;
				return this.jobNo - o.jobNo;
			}
		}
	}
}
