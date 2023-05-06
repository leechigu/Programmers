package 백준;

import java.util.ArrayList;
import java.util.Scanner;

public class 백준1149 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String temp = sc.nextLine();
        ArrayList<int[]> arrayList =new ArrayList<>();

        for(int i=0;i<n;i++){
            temp = sc.nextLine();
            String[] numsStr = temp.split(" ");
            int[] nums = new int[3];
            for(int j=0;j<nums.length;j++)
                nums[j] = Integer.valueOf(numsStr[j]);
            arrayList.add(nums);
        }
        int[][] rtn = new int[arrayList.size()][3];

        int[] t = arrayList.get(0);

        rtn[0][0] = t[0];
        rtn[0][1] = t[1];
        rtn[0][2] = t[2];


        for(int i=1;i<arrayList.size();i++){
            t = arrayList.get(i);


            rtn[i][0] = Math.min(rtn[i-1][1],rtn[i-1][2])+t[0];
            rtn[i][1] = Math.min(rtn[i-1][2],rtn[i-1][0])+t[1];
            rtn[i][2] = Math.min(rtn[i-1][0],rtn[i-1][1])+t[2];
        }

        int answer = Math.min(Math.min(rtn[n-1][0],rtn[n-1][1]),rtn[n-1][2]);

        System.out.println(answer);
    }

}
