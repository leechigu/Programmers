package 백준;

import java.io.*;
import java.util.*;

public class 백준1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        String[] splitStr = input.split(" ");

        int n = Integer.parseInt(splitStr[0]);
        int m = Integer.parseInt(splitStr[1]);

        //여기서 써야 하는 자료구조 형은?
        String[] stringArr = new String[n+m];

        for(int i=0;i<n+m;i++){
            input = br.readLine();
            stringArr[i] = input;
        }
        String a = "a";
        String b = "b";

        Arrays.sort(stringArr);
        ArrayList<String> arrList =new ArrayList<>();

        for(int i=0;i<stringArr.length-1;i++){
            String cur = stringArr[i];
            String next = stringArr[i+1];
            if(cur.equals(next))
                arrList.add(cur);
        }
        Collections.sort(arrList);

        System.out.println(arrList.size());

        for(String answer : arrList){
            System.out.println(answer);
        }

    }

}
