package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 백준11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] splitStr = input.split(" ");

        int n = Integer.parseInt(splitStr[0]);
        int k = Integer.parseInt(splitStr[1]);

        int[] arr = new int[n];

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0;i<n;i++)
            arrayList.add(i+1);

        String answer = "<";

        int[] ansArr = new int[n];

        int curIndx = k-1;

        for(int i=0;i<n;i++){

            int a = arrayList.remove((curIndx)%arrayList.size());
            if(i!=n-1)
                curIndx = (curIndx+k-1)%arrayList.size();
            ansArr[i] = a;
        }

        for(int i=0;i<n;i++){
            if(i==n-1)
                answer = answer + String.valueOf(ansArr[i])+">";
            else
                answer = answer + String.valueOf(ansArr[i])+", ";
        }

        System.out.println(answer);

    }

}
