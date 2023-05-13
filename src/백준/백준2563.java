package 백준;
import java.util.Scanner;

public class 백준2563 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] template = new int[100][100];

        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            for(int j=0;j<10;j++){
                for(int k=0;k<10;k++){
                    template[x+j][y+k] = 1;
                }
            }
        }

        int answer = 0;

        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(template[i][j]==1)
                    answer++;
            }
        }

        System.out.print(answer);

    }
}
