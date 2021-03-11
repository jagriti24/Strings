// https://leetcode.com/problems/word-search-ii/
// Given an m x n board of characters and a list of strings words, return all words on the board.

// Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        char[] firstChar = new char[words.length];
        List<String> result = new ArrayList<String>();
        for(int i=0; i<words.length ; i++){
            firstChar[i]=words[i].charAt(0);
        }
        
        for(int j=0; j< board.length; j++){
            for(int z=0; z< board[0].length; z++){
              for(int x=0; x< firstChar.length; x++){
                  if(board[j][z]==firstChar[x] && Character.isLowerCase(firstChar[x])){
                     if(recur(board,j,z,words[x],0)){
                         result.add(words[x]);
                         firstChar[x]=Character.toUpperCase(firstChar[x]);
                     } 
                  }
              }
                
            }
        }
        return result;
    }
    
    private boolean recur(char[][] board,int i, int j, String word, int z){
        if(z==word.length()){
            return true;
        }
        if(i<0 || j<0 || i==board.length || j==board[0].length){
            return false;
        }
        
        if(board[i][j]!=word.charAt(z)){
            return false;
        }
        board[i][j] ^= 256;
        boolean result = recur(board,i+1,j,word,z+1)||
            recur(board,i-1,j,word,z+1)||
            recur(board,i,j+1,word,z+1)||
            recur(board,i,j-1,word,z+1);
        board[i][j] ^= 256;
        
        return result;
    }
}
