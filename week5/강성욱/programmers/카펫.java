package week5.강성욱.programmers;

public class 카펫 {
    //brown 이든 yellow 든 하나를 통해서, 만들 수 있는 카페트를 생성
        //yellow 로 카페트를 만드는게 훨신 더 쉬울듯?
    //상상속 카페트의 brown 숫자를 확인
    //이걸 입력받은 brown 와 같은지 확인
    //
    //구현은?
    //케이스를 List<Integer[]> 에 2차원으로 가로,세로 조합을 만들어서 넣어두고
    //그걸 토대로, brown 를 계산하는 공식을 만들어서 전달하면 메서드로 뽑아주고 return 해서
    //검사하고 맞으면 return 하는 방식으로 해도 될듯.
    //
    //이거 굳이 이러지 말고, 적절한 카페트 생성되면 바로 체크하는게 더 유리할 듯. (시간 복잡도 상)
    //
    //가로가 더 길다는 가정 잘 생각해야됨.

    class Solution {
        public int[] solution(int brown, int yellow) {
            for(int y=1; y<=Math.sqrt(yellow); y++) { //절반만 써야됨. 왜냐? x가 더 크거나 같으니
                if(yellow % y == 0) { //나눠져야지 사각형이 됨.
                    int xSize = yellow/y + 2;
                    int ySize = y + 2;
                    if (calcBrownCount(xSize, ySize) == brown) {
                        return new int[]{xSize, ySize};
                    }
                }
            }

            return new int[]{-1, -1};
        }

        private int calcBrownCount(int xSize, int ySize) {
            return (xSize * 2) + (ySize * 2) - 4;
        }
    }
}
