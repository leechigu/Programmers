package 프로그래머스.LEVEL2;

public class N_Queen {

    int[] board;
    int cnt = 0;

    public boolean possiblle(int row){

        for(int i=0;i<row;i++){
            if(board[i] == board[row]){
                return false;
            }
            if(Math.abs(row-i)==Math.abs(board[row]-board[i])){
                return false;
            }

        }
        return true;
    }
    public void backT(int n,int row){

        if(row==n){
            cnt++;
            return;
        }

        for(int i=0;i<n;i++){
            board[row]= i;
            if(possiblle(row)){
                backT(n,row+1);
            }


        }

    }
    public int solution(int n){


        board = new int[n];

        backT(n,0);
        return cnt;
    }

}
