class Solution {
    public int countBattleships(char[][] board) {
        int R = board.length;
        if(R==0) return 0;
        int C = board[0].length;
        if(C==0) return 0;

        int count=0; int i,j;
        if(board[0][0]=='X') count++;
        for(i=1;i<R;i++){
            if(board[i][0]=='X' && board[i-1][0]=='.') count++;
        }
        for(i=1;i<C;i++){
            if(board[0][i]=='X' && board[0][i-1]=='.') count++;
        }

        for(i=1;i<R;i++){
            for(j=1;j<C;j++){
                if(board[i][j]=='X' && board[i-1][j]=='.' && board[i][j-1]=='.') count++;
            }
        }
        return count;

    }
}
