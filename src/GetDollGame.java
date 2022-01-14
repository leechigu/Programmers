import java.util.ArrayList;
class Solution {
    public int solution(int[][] board, int[] moves) {
        ArrayList<Integer> bucket = new ArrayList<Integer>();
        int disa =0;
        for(int i = 0;i<moves.length;i++){
            int x = moves[i]-1;
            for(int j=0;j<board.length;j++){
                if(board[j][x]!=0){
                    bucket.add(board[j][x]);
                    if(bucket.size()>=2){
                        if(bucket.get(bucket.size()-1)==bucket.get(bucket.size()-2)&&bucket.get(bucket.size()-1)!=0){
                            disa+=2;
                            bucket.remove(bucket.size()-1);bucket.remove(bucket.size()-1);
                        }
                    }
                    board[j][x]=0;
                    break;
                }
            }
        }
        return disa;
    }
}
