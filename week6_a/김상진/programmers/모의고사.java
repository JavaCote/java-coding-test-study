package week6_a.김상진.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week6_a.김상진.programmers
 * FileName    : 모의고사
 * Author      : sangxxjin
 * Date        : 2025. 6. 7.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 7.     sangxxjin               Initial creation
 */
public class 모의고사 {
	// 첫번쨰 풀이는 라이브코테때 풀었던 풀이임.
	// 두번째 풀이와 성능차이는 answers가 엄청 크지 않는 이상 큰 차이 없지만.
	// 코딩테스트의 측면으로 봤을때는 두번째 풀이가 더 좋다고 판단
	import java.util.*;
	class Solution {
		public List<Integer> solution(int[] answers) {
			List<Integer> arr = new ArrayList<>();
			int[] r = new int[]{first(answers),second(answers),third(answers)};
			int max=Math.max(r[0],Math.max(r[1],r[2]));
			for(int i=0; i<r.length; i++){
				if(r[i]==max)arr.add(i+1);
			}
			return arr;
		}
		private int first(int[] answers){
			int[] sub = new int[]{1,2,3,4,5};
			int sum=0;
			int idx=0;
			for(int i=0; i<answers.length; i++){
				if(answers[i]==sub[idx++]) sum++;
				if(idx>4)idx=0;
			}
			return sum;
		}
		private int second(int[] answers){
			// 21232425 반복
			int[] sub = new int[]{2,1,2,3,2,4,2,5};
			int sum=0;
			int idx=0;
			for(int i=0; i<answers.length; i++){
				if(answers[i]==sub[idx++]) sum++;
				if(idx>7)idx=0;
			}
			return sum;
		}
		private int third(int[] answers){
			// 33  11 22 44 55 반복
			int[] sub = new int[]{3,3,1,1,2,2,4,4,5,5};
			int sum=0;
			int idx=0;
			for(int i=0; i<answers.length; i++){
				if(answers[i]==sub[idx++]) sum++;
				if(idx>9)idx=0;
			}
			return sum;
		}
	}
	// 두번째 풀이
	import java.util.*;
	class Solution {
		public List<Integer> solution(int[] answers) {
			int[] first = new int[]{1,2,3,4,5};
			int[] second = new int[]{2,1,2,3,2,4,2,5};
			int[] third = new int[]{3,3,1,1,2,2,4,4,5,5};
			int firstAnswerCount =0;
			int secondAnswerCount =0;
			int thirdAnswerCount =0;
			for(int i=0; i<answers.length; i++){
				if(answers[i]==first[i%5]) firstAnswerCount++;
				if(answers[i]==second[i%8]) secondAnswerCount++;
				if(answers[i]==third[i%10]) thirdAnswerCount++;
			}
			int max = Math.max(firstAnswerCount,Math.max(secondAnswerCount,thirdAnswerCount));
			int[] countList = new int[]{firstAnswerCount,secondAnswerCount,thirdAnswerCount};
			List<Integer> answer = new ArrayList<>();
			for(int i =0; i<countList.length; i++){
				if(max==countList[i])answer.add(i+1);
			}
			return answer;
		}
	}
}
