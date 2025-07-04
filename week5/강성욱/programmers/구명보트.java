package week5.강성욱.programmers;

import java.util.*;

public class 구명보트 {
    //2명밖에 못타는게 핵심
    //가장 무거운 사람이, 가능한 태울 수 있는 사람을 태우는게 좋다..?
    //가능한듯
    //단순 반복으로 하면 시간복잡도는, 최대 O(n^2)... n=50,000; 불가능
    //정렬을 해서 오름차순? 으로 하고, 쓰면?
    //[20, 30, 50, 90] 100
    //90 선택 (right)
    //now left = 20
    //possible? no
    //아, 불가능할때까지 left를 우측으로 쉬프트하면서 쓰면 되겠다.
    //이러면 이론상 O(n)
    //종료 조건은? left 가 더 커지면? 같은거 까지는 해야됨.
        //[1, 2, 3, 4, 5] 일때, 10이면, [1, 5], [2, 4] 하고 left right 가 동일해지는데, 태워야함

    class Solution {
        public int solution(int[] people, int limit) {
            int left = 0;
            int right = people.length-1; //인덱스 기반이니 -1 해야됨.
            int count = 0;
            Arrays.sort(people); //오름차순 정렬

            while(left <= right) {
                if(people[left] + people[right] <= limit) { //태울만함
                    left++;
                    right--;
                    count++;
                } else if(right == left) { //남은 사람이 한명이면 걍 한명 태워서 보냄
                    count++;
                    break;
                }
                else { //무거워서 한명만 태워야됨
                    right--;
                    count++;
                }
            }

            return count;
        }
    }
}
