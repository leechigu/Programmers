package 백준;

import java.util.Scanner;

public class 백준1463 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] x = new int[1000001];

        x[1] = 0;
        x[2] = 1;
        x[3] = 1;

        for(int i=4;i<x.length;i++){
            int min1 = Math.min(x[i /2] + 1, x[i - 1] + 1);
            if(i%2==0&&i%3==0){
                int min = min1;
                x[i] = Math.min(min, x[i / 3] + 1);
            }
            else if(i%3==0){
                x[i] = Math.min(x[i/3]+1,x[i-1]+1);
            }else if(i%2==0){
                x[i] = min1;
            }else{
                x[i] = x[i-1]+1;
            }
        }

        int n = sc.nextInt();

        System.out.println(x[n]);
    }

}
