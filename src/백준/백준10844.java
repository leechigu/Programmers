package 백준;

import java.util.Scanner;

public class 백준10844 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long mod = 1000000000;
        int n = sc.nextInt();

        long[][] dp = new long[n][10];

        for(int i=1;i<10;i++)
            dp[0][i] = 1;

        for(int i=1;i<n;i++){
            for(int j=0;j<10;j++){
                if(j==0)
                    dp[i][j] = dp[i-1][1]%mod;
                else if(j==9)
                    dp[i][j] = dp[i-1][8]%mod;
                else
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%mod;
            }
        }

        long answer = 0;
        for(int i=0;i<10;i++)
            answer += dp[n-1][i]%mod;

        System.out.print(answer%mod);
    }
}
