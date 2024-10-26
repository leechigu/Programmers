package 백준;

import java.io.*;

public class 백준11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] splitStr = input.split(" ");
        int n = Integer.parseInt(splitStr[0]);
        int m = Integer.parseInt(splitStr[1]);

        input = br.readLine();
        splitStr = input.split(" ");

        long[] sumArr = new long[n+1];
        for(int i=0;i<n;i++){
            int a = Integer.parseInt(splitStr[i]);
            sumArr[i+1] = sumArr[i] + a;
            //System.out.println(sumArr[i+1]);
        }



        for(int i=0;i<m;i++){
            input = br.readLine();
            splitStr = input.split(" ");

            int a = Integer.parseInt(splitStr[0]);
            int b = Integer.parseInt(splitStr[1]);
            long answer = sumArr[b]-sumArr[a-1];

            bw.write(answer+"\n");
        }

        bw.flush();
        bw.close();
    }
}
