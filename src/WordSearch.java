/**
 * Created by flex on 17-3-4.
 * no.79 Word Search
 * @author flex
 */

public class WordSearch {

    private boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (exist(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int x, int y, int idx) {
        if (idx == word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (board[x][y] != word.charAt(idx)) return false;
        board[x][y] = 0;
        boolean result = exist(board, word, x, y+1, idx+1)
                || exist(board, word, x, y-1, idx+1)
                || exist(board, word, x+1, y, idx+1)
                || exist(board, word, x-1, y, idx+1);
        board[x][y] = word.charAt(idx);
        return result;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'A','A','A','A'},
                {'A','A','A','A'},
                {'A','A','A','A'},
        };
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "ABCCEE"));
        System.out.println(ws.exist(board, "SEE"));
        System.out.println(ws.exist(board, "AAAAAAAAAAAAA"));
    }

}
