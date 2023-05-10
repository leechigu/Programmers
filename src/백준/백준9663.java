package 백준;
import java.util.Scanner;
public class 백준9663 {
    static int[] board;
    static int cnt = 0;
    public static boolean possiblle(int row){
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
    public static void backT(int n, int row){
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
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        board = new int[n];
        backT(n,0);
        System.out.println(cnt);
    }
}
