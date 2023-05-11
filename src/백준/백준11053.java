package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11053 {

    public static int[] numArr;
    public static int[] dp;

    public static int LTS(int n){

        if(dp[n] == 0) {
            dp[n] = 1;

            for (int i = n - 1; i >= 0; i--)
                if (numArr[i] < numArr[n])
                    dp[n] = Math.max(dp[n], LTS(i) + 1);
        }
        return dp[n];

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");



        numArr =new int[n];
        dp = new int[n];
        for(int i = 0;i<n;i++)
            numArr[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++)
            LTS(i);

        int max = dp[0];
        // 최댓값 찾기
        for(int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
