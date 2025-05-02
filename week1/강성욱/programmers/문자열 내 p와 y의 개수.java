class Solution {
	boolean solution(String s) {
		s = s.toLowerCase(); // 모두 소문자로 통일
		int p = 0;
		int y = 0;

		for (char c : s.toCharArray()) {
			if (c == 'p') {
				p++;
			} else if (c == 'y') {
				y++;
			}
		}

		return p == y;
	}
}