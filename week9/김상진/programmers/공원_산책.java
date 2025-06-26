package week9.김상진.programmers;


public class 공원_산책 {
    //단순 구현 문제
    class Solution {
        public int[] solution(String[] park, String[] routes) {
            char[][] board = new char[park.length][park[0].length()];
            for(int i=0; i<park.length; i++){
                board[i]=park[i].toCharArray();
            }
            // 시작 index 찾기
            int[] currentIndex = getStartIndex(board);
            for(String route : routes){
                String[] parts = route.split(" ");
                char dir = parts[0].charAt(0);
                int amount = Integer.parseInt(parts[1]);
                // 이동가능한 경로인지 확인 후 이동
                if(isCanMove(board,dir,amount,currentIndex)){
                    switch (dir) {
                        case 'E':
                            currentIndex[1]+=amount;
                            break;
                        case 'W':
                            currentIndex[1]-=amount;
                            break;
                        case 'S':
                            currentIndex[0]+=amount;
                            break;
                        case 'N':
                            currentIndex[0]-=amount;
                            break;
                    }
                }
            }
            return currentIndex;
        }
        //이동 가능한 경로인지 확인
        private boolean isCanMove(char[][] board, char dir, int amount, int[] currentIndex) {
            int currentRow = currentIndex[0];
            int currentCol = currentIndex[1];

            int boardRows = board.length;
            int boardCols = board[0].length;

            for (int i = 1; i <= amount; i++) {
                int nextRow = currentRow;
                int nextCol = currentCol;


                switch (dir) {
                    case 'E':
                        nextCol = currentCol + i;
                        break;
                    case 'W':
                        nextCol = currentCol - i;
                        break;
                    case 'S':
                        nextRow = currentRow + i;
                        break;
                    case 'N':
                        nextRow = currentRow - i;
                        break;
                }

                if (nextRow < 0 || nextRow >= boardRows || nextCol < 0 || nextCol >= boardCols) {
                    return false;
                }

                if (board[nextRow][nextCol] == 'X') {
                    return false;
                }
            }

            return true;
        }
        // 시작위치 찾기
        private int[] getStartIndex(char[][] board){
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length; j++){
                    if(board[i][j]=='S')return new int[]{i,j};
                }
            }
            return new int[]{0,0};
        }
    }

}
