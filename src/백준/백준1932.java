package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class 백준1932 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String temp = sc.nextLine();

        int[][] nums = new int[n][];
        int[][] ans = new int[n][];


        for(int i=0;i<n;i++){
            temp = sc.nextLine();
            nums[i] = new int[i+1];
            ans[i] = new int[i+1];
            String[] numStr = temp.split(" ");
            for(int j=0;j<nums[i].length;j++){
                nums[i][j] = Integer.valueOf(numStr[j]);
            }
        }

        ans[0][0] = nums[0][0];
        for(int i=1;i<nums.length;i++){

            for(int j=0;j<i+1;j++){
                if(j==0){
                    ans[i][j] = ans[i-1][0]+nums[i][j];
                }else if(j==i){
                    ans[i][j] = ans[i-1][i-1]+nums[i][j];
                }else{
                    ans[i][j] = Math.max(ans[i-1][j-1],ans[i-1][j])+nums[i][j];
                }
            }
        }

        Arrays.sort(ans[n-1]);

        System.out.println(ans[n-1][n-1]);

    }
}
