package 백준;

import java.util.Scanner;

public class 백준2579 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] rtn = new int[n][2];
        int[] str = new int[n];

        for(int i=0;i<rtn.length;i++)
            str[i] = sc.nextInt();

        rtn[0][0] = str[0];
        rtn[0][1] = 0;

        if(n>1) {
            rtn[1][0] = str[1];
            rtn[1][1] = str[1] + str[0];
            //뒤에 있으면 1 없으면 0
            for (int i = 2; i < rtn.length; i++) {
                rtn[i][0] = Math.max(rtn[i - 2][1], rtn[i - 2][0]) + str[i];
                rtn[i][1] = rtn[i - 1][0] + str[i];
            }
        }
        System.out.println(Math.max(rtn[n-1][0],rtn[n-1][1]));
    }

}
