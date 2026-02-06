package week40.강성욱.programers;

/**
 * PackageName : week40.강성욱.programers
 * FileName    : 추석_트래픽
 * Author      : Baekgwa
 * Date        : 26. 2. 6.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 2. 6.     Baekgwa               Initial creation
 */
public class 추석_트래픽 {
	class Solution {
		// 그 시간대에 진행중이기만 하면 오케
		// 음 그럼 그냥 파싱해서, 그 시간대 정보만큼 count++ 하면 되는거 아닌가?
		// 최대 N(작업 개수) 는 2000개
		// 시간의 정보는, 00시 00분 00초 부터, 23시 59분 59초 까지. 총? 60*60*24 = 86400
		// 모든 정보가 시작부터 끝까지 처리되는 그럴리가 없네. => 처리시간은 최대 3초
		// 그럼 3초, 앞뒤로 겹쳐서 최대 4초
		// 작업들이 모두 4초쪽에 걸리면, 8000 개만 처리?
		// 그냥 쉬운데? 할만한데?

		public int solution(String[] lines) {
			int n = lines.length;
			long[][] logs = new long[n][2];

			for (int i = 0; i < n; i++) {
				String[] parts = lines[i].split(" ");

				long end = toMillis(parts[1]);
				long duration = parseDuration(parts[2]);
				long start = end - duration + 1;

				logs[i][0] = start;
				logs[i][1] = end;
			}

			int max = 0;

			for (int i = 0; i < n; i++) {
				max = Math.max(max, countOverlap(logs, logs[i][0]));
				max = Math.max(max, countOverlap(logs, logs[i][1]));
			}

			return max;
		}

		private int countOverlap(long[][] logs, long windowStart) {
			long windowEnd = windowStart + 999;
			int count = 0;

			for (long[] log : logs) {
				if (log[0] <= windowEnd && log[1] >= windowStart) {
					count++;
				}
			}

			return count;
		}

		private long toMillis(String time) {
			String[] hms = time.split(":");

			int hour = Integer.parseInt(hms[0]);
			int minute = Integer.parseInt(hms[1]);

			String[] secMilli = hms[2].split("\\.");
			int second = Integer.parseInt(secMilli[0]);
			int milli = Integer.parseInt(secMilli[1]);

			return hour * 3600_000L
				+ minute * 60_000L
				+ second * 1_000L
				+ milli;
		}

		private long parseDuration(String durationStr) {
			String value = durationStr.substring(0, durationStr.length() - 1);
			double seconds = Double.parseDouble(value);
			return (long) (seconds * 1000);
		}
	}


	//     // 2016-09-15 01:00:04.001
	//     // 형식을, time 형태로 변환
	//     private LocalDateTime convertDateTimeFormat(String date, String time) {
	//         String[] dateArray = date.split("-");
	//         String[] timeArray = time.split(":");
	//         // sec 랑 ns
	//         String[] secArray = timeArray[2].split("\\.");
	//         int sec = Integer.parseInt(secArray[0]);
	//         int ns = Integer.parseInt(secArray[1]) * 1_000_000; // 기본 밀리초에서 나노로 변환

	//         return LocalDateTime.of(
	//             Integer.parseInt(dateArray[0]),
	//             Integer.parseInt(dateArray[1]),
	//             Integer.parseInt(dateArray[2]),
	//             Integer.parseInt(timeArray[0]),
	//             Integer.parseInt(timeArray[1)],
	//             sec,
	//             ns
	//         );
	//     }
}
