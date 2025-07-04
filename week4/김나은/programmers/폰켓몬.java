package week4.김나은.programmers;

import java.util.*;

class Solution {
    public int solution(int[] nums) {

        // 고를 수 있는 포켓몬 수는 전체의 절반
        int num = nums.length / 2;

        // Set을 사용해서 중복 제거된 포켓몬 번호를 저장
        Set<Integer> hs = new HashSet<Integer>();

        // nums 배열을 순회하면서 HashSet에 넣기 → 중복 자동 제거됨
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }

        // 중복 제거된 포켓몬 종류 수
        int pokemon_nums = hs.size();

        // 포켓몬 종류 수가 절반보다 적거나 같으면 전부 고를 수 있음
        // 포켓몬 종류 수가 절반보다 많으면 절반만큼만 골라야 함
        if (pokemon_nums <= num) {
            return pokemon_nums; // 가능한 모든 종류 반환
        } else {
            return num; // 절반만큼만 반환
        }
    }
}