// https://leetcode.com/problems/word-search/
// Given an m x n gird of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Note: There will be some test cases with a board or a word larger than constraints to test if your solution is using pruning.


 

class WordSearch {
    
    public boolean exist(char[][] board, String word) {
       // char[] w = word.toCharArray();
       for (int y=0; y<board.length; y++) {
    	for (int x=0; x<board[y].length; x++) {
    		if (recur(board, y, x, word, 0)) return true;
    	}
    }
    return false;
        
    }
    
    private boolean recur(char[][] board,int i, int j, String word, int z){
        if(z==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return false;
        }
        if(board[i][j]!=word.charAt(z)){
            return false;
        }
        board[i][j] ^=256;
        boolean reset = recur(board,i-1,j,word,z+1) ||
           recur(board,i,j-1,word,z+1) ||
           recur(board,i+1,j,word,z+1) ||
           recur(board,i,j+1,word,z+1);
          
        board[i][j] ^=256;
        return reset;
    }
}
