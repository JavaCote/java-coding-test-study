package week21.강성욱.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * PackageName : week21.강성욱.programmers
 * FileName    : 과제_진행하기
 * Author      : Baekgwa
 * Date        : 2025-09-19
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-19     Baekgwa               Initial creation
 */
public class 과제_진행하기 {
	// queue? stack? 정렬?
	// 일딴 시작 시간 기준으로 정렬은 무조건 필요.
	// 그리고, 이전걸 계속 가지고 가야함.
	// 이거 정렬이든, 뭐든 쉽게 가져가기 위해서 내부적으로 통일화 해서 쓰자. class로

	class Solution {
		public String[] solution(String[][] plans) {
			// 실행할 Job 을 Queue 순서대로 진행
			// 정렬은, 시작 순서
			PriorityQueue<Job> jobQueue = new PriorityQueue<>(Comparator.comparingInt(j -> j.startTime));

			for(String[] plan : plans) {
				jobQueue.offer(new Job(plan[0], convertToMin(plan[1]), Integer.valueOf(plan[2])));
			}

			String[] result = new String[plans.length]; //결과를 담을 result;
			int resIdx = 0; //
			//중간에 멈춘 작업은, 가장 최근에 멈춘 과제부터 다시 시작하기 때문에, LIFO Stack 으로 구성
			Stack<Job> stack = new Stack<>();
			Job nowJob = null;
			int nowTime = 0;

			while (resIdx < plans.length) {
				if (nowJob == null) {
					if (!jobQueue.isEmpty() && jobQueue.peek().startTime <= nowTime) {
						nowJob = jobQueue.poll();
						nowTime = Math.max(nowTime, nowJob.startTime);
					}
					else if (!stack.isEmpty()) {
						nowJob = stack.pop();
					}
					else if (!jobQueue.isEmpty()) {
						nowJob = jobQueue.poll();
						nowTime = nowJob.startTime;
					} else {
						break;
					}
				}

				int nextStart = jobQueue.isEmpty() ? Integer.MAX_VALUE : jobQueue.peek().startTime;

				if (nowTime + nowJob.remainTime <= nextStart) {
					nowTime += nowJob.remainTime;
					result[resIdx++] = nowJob.name;
					nowJob = null;
				} else {
					int spent = nextStart - nowTime;
					nowJob.remainTime -= spent;
					nowTime = nextStart;
					stack.push(nowJob);
					nowJob = jobQueue.poll();
				}
			}

			return result;
		}

		private static class Job {
			private String name;
			private int startTime; //시작시간 (분)
			private int remainTime; //남은시간 (분)

			public Job(String name, int startTime, int remainTime) {
				this.name = name;
				this.startTime = startTime;
				this.remainTime = remainTime;
			}
		}

		private int convertToMin(String str) {
			String[] strArray = str.split(":");
			return Integer.valueOf(strArray[0]) * 60 + Integer.valueOf(strArray[1]);
		}
	}
}
