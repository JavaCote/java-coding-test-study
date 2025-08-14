package week16.강성욱.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PackageName : week16.강성욱.backjoon
 * FileName    : 파일명_정렬
 * Author      : Baekgwa
 * Date        : 2025-08-13
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-13     Baekgwa               Initial creation
 */
public class 파일명_정렬 {
	// 일딴, 3가지로 나눠야함.
	// Head, Number, [Tail] 부
	// 각 부는, 없을 수도 있나?
	// 숫자는 반드시 있다고 하기 대문에, number 까지는 있을꺼임. 단, tail 부는 없을 수도 있음.
	// 심지어 정렬 순서에 tail 부는 없어도 되기 때문에, 저장만 해두면 될듯.
	// 정렬 우선순위는 Head
	//Head -> 사전순 정렬. 단 대소문자 구분하지 않으므로 underCase 및 UpperCase 변환 후 정렬검사가 필요.
	//Number 는, 숫자 정렬. 앞숫자 무시이니깐, long 으로 변환해서 사용하는걸로
	//Tail은, 고려하지 않아도 됨. 원래 입력에 주어진 순서를 유지

	class Solution {
		public String[] solution(String[] files) {
			String[] result = new String[files.length];
			List<CustomFile> fileList = new ArrayList<>();

			for(String file : files) {
				fileList.add(new CustomFile(div(file)));
			}

			Collections.sort(fileList);

			int idx = 0;
			for(CustomFile c : fileList) {
				result[idx++] = c.getOrdinalFileName();
			}

			return result;
		}

		private String[] div(String file) {
			boolean isNumberStart = false;
			boolean isNumberEnd = false;
			StringBuilder sbHead = new StringBuilder();
			StringBuilder sbNumber = new StringBuilder();
			StringBuilder sbTail = new StringBuilder();

			int i = 0;
			for(char c : file.toCharArray()) {
				if(isNumberStart == false && !Character.isDigit(c) && !isNumberEnd) {
					sbHead.append(c);
					continue;
				} else if(Character.isDigit(c) && !isNumberEnd) {
					isNumberStart = true;
					sbNumber.append(c);
					if (sbNumber.length() == 5) { //숫자는 최대 5자리
						isNumberEnd = true;
					}
				} else {
					isNumberEnd = true;
					sbTail.append(c);
				}
			}
			// 잘 나눴는지 확인용 출력
			// System.out.printf(file + " : ");
			// System.out.printf(sbHead.toString() + ", " + sbNumber.toString() + ", " + sbTail.toString());
			// System.out.printf("\n");
			return new String[]{ sbHead.toString(), sbNumber.toString(), sbTail.toString() };
		}

		public static class CustomFile implements Comparable<CustomFile> {
			private String head;
			private String number;
			private String tail;

			public CustomFile (String[] arr) {
				this.head = arr[0];
				this.number = arr[1];
				this.tail = arr[2];
			}

			public String getOrdinalFileName() {
				return this.head + this.number + this.tail;
			}

			@Override
			public int compareTo(CustomFile o) {
				int headCompare = this.head.toLowerCase().compareTo(o.head.toLowerCase());
				if (headCompare != 0) return headCompare;

				int numCompare = Integer.compare(
					Integer.parseInt(this.number),
					Integer.parseInt(o.number)
				);
				if (numCompare != 0) return numCompare;

				return 0;
			}
		}
	}
}
