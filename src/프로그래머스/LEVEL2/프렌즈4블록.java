package 프로그래머스.LEVEL2;

public class 프렌즈4블록 {


    int a;
    int b;
    int answer = 0;
    boolean del[][];
    public boolean go(char[][] board){

        boolean rtn = false;

        for(int i = 0; i<a-1;i++){
            for(int j=0;j<b-1;j++){
                if(check(board,i,j))
                    rtn = true;
            }
        }

        return rtn;
    }

    public boolean check(char[][] board,int x,int y){

        char a,b,c,d;
        a = board[x][y];
        b = board[x+1][y];
        c = board[x][y+1];
        d = board[x+1][y+1];

        if(a=='X')
            return false;


        if(a==b&&a==c&&a==d){
            del[x][y] = true;
            del[x+1][y] = true;
            del[x][y+1] = true;
            del[x+1][y+1] = true;
            return true;
        }

        return false;
    }

    public void move(char[][] board,int a,int b){

        for(int i = a-1;i>0;i--){
            board[i][b] = board[i-1][b];
        }
        board[0][b] = 'X';

    }



    public int solution(int m, int n, String[] board) {

        a = m;
        b = n;

        char[][] charBoard = new char[m][n];

        for(int i=0;i<m;i++){
            String temp = board[i];
            for(int j=0;j<n;j++){
                char c = temp.charAt(j);
                charBoard[i][j] = c;

            }
        }

        while(go(charBoard)){
            for(int i=0;i<a;i++){
                for(int j=0;j<b;j++){
                    if(del[i][j]){
                        charBoard[i][j] = 'X';
                        answer++;
                    }
                }
            }
            for(int i=0;i<a;i++){
                for(int j=0;j<b;j++){
                    if(charBoard[i][j]=='X'){
                        move(charBoard,i,j);
                    }
                }
            }


        }
        return answer;
    }

}
