package 백준;
import java.util.Scanner;

public class 백준9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] x = new int[11];
        x[0] = 1;
        x[1] = 2;
        x[2] = 4;
        for(int i=3;i<11;i++)
            x[i] = x[i-1]+x[i-2]+x[i-3];

        for(int i=0;i<n;i++){
            int temp = sc.nextInt();

            System.out.println(x[temp-1]);

        }


    }

}
