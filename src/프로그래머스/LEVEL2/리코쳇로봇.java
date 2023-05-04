package 프로그래머스.LEVEL2;
import java.util.*;
public class 리코쳇로봇 {

    static int a1,b1;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[][] isVisited;

    static int answer =-1;

    public static void bfs(String[] board,int a,int b){

        Queue<int[]> queue =  new LinkedList<>();
        queue.offer(new int[]{a,b,0});

        int n = board.length;
        int m = board[0].length();
        isVisited = new boolean[n][m];
        isVisited[a][b] = true;

        while(!queue.isEmpty()){

            int now[] = queue.poll();

            for(int i=0;i<4;i++){

                int x = now[0];
                int y = now[1];
                int cnt = now[2];

                while(true){
                    x +=dx[i];
                    y +=dy[i];
                    if(x>=0 && y>= 0 && x<n && y<m){
                        if('D'==board[x].charAt(y)){
                            x-=dx[i];
                            y-=dy[i];
                            break;
                        }
                    }else{
                        x-=dx[i];
                        y-=dy[i];
                        break;
                    }
                }

                if(x==now[0] && y== now[1]){
                    continue;
                }

                if(!isVisited[x][y]){
                    if('G'==board[x].charAt(y)){
                        answer = cnt+1;
                        isVisited[x][y] = true;
                        queue.clear();
                    }
                    else{
                        queue.add(new int[]{x,y,cnt+1});
                        isVisited[x][y] = true;
                    }
                }
            }
        }
    }



    public int solution(String[] board) {
        a1 =-1;
        b1 = -1;

        boolean is =false;
        for(int i=0;i<board.length;i++){
            if(is)
                break;
            String temp = board[i];
            for(int j=0;j<temp.length();j++){
                char c = temp.charAt(j);
                if(c=='R'){
                    a1 = i;
                    b1 = j;
                    is = true;
                }
            }
        }

        bfs(board,a1,b1);


        return answer;
    }

}
