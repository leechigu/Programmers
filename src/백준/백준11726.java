package 백준;

import java.util.Scanner;

public class 백준11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rtn = new int[1001];
        rtn[0] = 1;
        rtn[1] = 2;
        for(int i=2;i<rtn.length;i++)
            rtn[i] = (rtn[i-1]+rtn[i-2])%10007;
        System.out.print(rtn[n-1]);
    }

}
