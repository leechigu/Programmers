package 백준;

import java.util.Scanner;

public class 백준2566 {
    public static void main(String[] args) {


        int[] max = new int[3];
        max[0] = -1;
        max[1] = -1;
        max[2] = -1;

        Scanner sc = new Scanner(System.in);

        int[][] x = new int[9][9];

        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                x[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                if(x[i][j]>max[0]){
                    max[0] = x[i][j];
                    max[1] = i;
                    max[2] = j;
                }
            }
        }
        System.out.println(max[0]);
        System.out.println((max[1]+1)+" "+(max[2]+1));
    }

}
