package week16.강성욱.programmers;

/**
 * PackageName : week16.강성욱.programmers
 * FileName    : 방금그곡
 * Author      : Baekgwa
 * Date        : 2025-08-13
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-13     Baekgwa               Initial creation
 */
public class 방금그곡 {
	// // 음 musicinfos 의 3번째 인덱스 값을 들리는 만큼 그냥 길게 붙여주고 contain 검사?

	// import java.util.*;

	// class Solution {
	//     public String solution(String m, String[] musicinfos) {
	//         String result = "";

	//         for(String musicInfo : musicinfos) {
	//             StringBuilder repeatMelody = new StringBuilder();

	//             String[] musicInfoArray = musicInfo.split(",");
	//             int musicLength = calcMusicLength(musicInfoArray[0], musicInfoArray[1]); // 시작부터 끝까지 몇초
	//             String nowMelody = musicInfoArray[3];
	//             // 현재 멜로디를 반복하기 편하도록 array 로 만들기. 즉, C, C#, D, D#, E, F, F#, G, G#, A, A#, B 등, # 고려해서 저장
	//             String[] nowMelodyArray = convertArray(nowMelody);
	//             for(int i=0; i<nowMelodyArray.length; i++) {
	//                 System.out.println(nowMelodyArray[i]);
	//             }

	//             // 길이만큼 문자열 늘려주기
	//             for(int i=0; i<musicLength; i++) {
	//                 repeatMelody.append(nowMelodyArray[i % nowMelodyArray.length]);
	//             }

	//             if(repeatMelody.toString().contains(m) && result.length() < musicInfoArray[2].length()) {
	//                 result = musicInfoArray[2];
	//             }
	//         }

	//         return result == "" ? "(None)" : result;
	//     }

	//     private int calcMusicLength(String from, String to) {
	//         String[] fromArray = from.split(":");
	//         String[] toArray = to.split(":");
	//         return (Integer.parseInt(toArray[0]) * 60 + Integer.parseInt(toArray[1])) - (Integer.parseInt(fromArray[0]) * 60 + Integer.parseInt(fromArray[1]));
	//     }

	//     private String[] convertArray(String melody) {
	//         List<String> list = new ArrayList<>();

	//         int idx = 0;
	//         for(char c : melody.toCharArray()) {
	//             // # 이면 이전 인덱스에 # 붙이기
	//             if(c == '#') {
	//                 list.set(idx - 1, list.get(idx - 1) + c);
	//                 continue;
	//             }
	//             list.add(String.valueOf(c));
	//             idx++;
	//         }

	//         String[] result = new String[list.size()];
	//         for(int i=0; i<list.size(); i++) {
	//             result[i] = list.get(i);
	//         }

	//         return result;
	//     }
	// }


	// 위에 실패 케이스가 나옴.
	// c#, 등 # 붙은게 있으면 contain 검사로 필터링이 잘 안됨.
	// 치환하여 사용하는 방법으로 변경

	class Solution {
		public String solution(String m, String[] musicinfos) {
			String findMelody = convertShap(m);
			String result = "(None)";
			int resultPlayTime = 0;

			for(String musicInfo : musicinfos) {
				String[] musicInfoArray = musicInfo.split(",");
				int nowPlayTime = calcMusicLength(musicInfoArray[0], musicInfoArray[1]);
				String nowMusicName = musicInfoArray[2];

				// 재생시간 만큼, 반복하는 문자열 만들어주기
				String nowRepeatMelody = makeRepeatString(convertShap(musicInfoArray[3]), nowPlayTime);
				if(nowRepeatMelody.contains(findMelody) && nowPlayTime > resultPlayTime) {
					result = nowMusicName;
					resultPlayTime = nowPlayTime;
				}
			}

			return result;
		}

		private String convertShap(String str) {
			return
				str.replace("C#", "c")
					.replace("D#", "d")
					.replace("F#", "f")
					.replace("G#", "g")
					.replace("A#", "a")
					.replace("B#", "b") // 아니 이거 어이가 없네 지문에 없는데 이거 넣어야 통과네ㅋㅋㅋ
					.replace("E#", "e") // 아니 이거 어이가 없네 지문에 없는데 이거 넣어야 통과네ㅋㅋㅋ
				;
		}

		private String makeRepeatString(String str, int cnt) {
			StringBuilder sb = new StringBuilder();

			for(int i=0; i<cnt; i++) {
				sb.append(str.charAt(i % str.length()));
			}

			return sb.toString();
		}

		private int calcMusicLength(String from, String to) {
			String[] fromArray = from.split(":");
			String[] toArray = to.split(":");
			return (Integer.parseInt(toArray[0]) * 60 + Integer.parseInt(toArray[1])) - (Integer.parseInt(fromArray[0]) * 60 + Integer.parseInt(fromArray[1]));
		}
	}
}
