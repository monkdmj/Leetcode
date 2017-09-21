import java.util.HashSet;
import java.util.Set;

/**
 * Created by monkd on 2017/9/21.
 */
public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;
        int col = size;
        int row = board[0].length;
        if(row != col) return false;

        char[] onceShoot = new char[9];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                onceShoot[j] = board[i][j];
            }
            if(!isOnceValid(onceShoot)) return false;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                onceShoot[j] = board[j][i];
            }
            if(!isOnceValid(onceShoot)) return false;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                onceShoot[j] = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3];
            }
            if(!isOnceValid(onceShoot)) return false;
        }
        return true;
    }

    public boolean isOnceValid(char[] onceS) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i <= onceS.length - 1; i++) {
            if (Character.isDigit(onceS[i])) {
                if (set.contains(onceS[i])) {
                    return false;
                } else {
                    set.add(onceS[i]);
                }
            }
        }
        return true;
    }

    /**
     * Collect the set of things we see, encoded as strings. For example:
     * '4' in row 7 is encoded as "(4)7".
     * '4' in column 7 is encoded as "7(4)".
     * '4' in the top-right block is encoded as "0(4)2".
     * Scream false if we ever fail to add something because it was already added (i.e., seen before).
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }

    //思路跟自己的一样，但更加精简！！！佩服
    public boolean isValidSudoku3(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //test
        //一维数组{ , , }
        //二维数组,每个元素又是一个数组 { {} ,{} }
        int[][] arr = new int[][]{{1,2,3},{4,5,6}};
        System.out.println("args = [" + arr.length + "]");  //2
        System.out.println("args = [" + arr[0].length + "]");  //2
        char[][] chr = new char[][]{{'1', '2'}, {'3', '4'}};
        System.out.println("args = [" + chr.length + "]");  //2
    }
}
