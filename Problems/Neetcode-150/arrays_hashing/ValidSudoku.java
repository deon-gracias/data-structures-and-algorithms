// https://leetcode.com/problems/valid-sudoku/

class Solution {
  public boolean isValidSudoku(char[][] board) {
    List<HashSet<Character>> rows = new ArrayList<HashSet<Character>>();
    List<HashSet<Character>> cols = new ArrayList<HashSet<Character>>();
    List<HashSet<Character>> squares = new ArrayList<HashSet<Character>>();

    for (int i = 0; i < board.length; i++) {
      rows.add(new HashSet<Character>());
      cols.add(new HashSet<Character>());
      squares.add(new HashSet<Character>());
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        int sqIndex = ((i / 3) * 3) + (j / 3);

        if (board[i][j] == '.') {
          continue;
        }

        if (rows.get(i).contains(board[i][j])) {
          return false;
        }

        if (cols.get(j).contains(board[i][j])) {
          return false;
        }

        if (squares.get(sqIndex).contains(board[i][j])) {
          return false;
        }

        rows.get(i).add(board[i][j]);
        cols.get(j).add(board[i][j]);
        squares.get(sqIndex).add(board[i][j]);
      }
    }

    return true;
  }
}
