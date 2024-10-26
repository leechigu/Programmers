package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 백준11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int n = Integer.parseInt(input);

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){

            input = br.readLine();
            String[] splitStr = input.split(" ");

            String a = splitStr[0];
            int b=-1;

            if(splitStr.length==2){
                b = Integer.parseInt(splitStr[1]);
            }

            if("add".equals(a)){
                set.add(b);
            }else if("remove".equals(a)){
                if(set.contains(b))
                    set.remove(b);
            }else if("check".equals(a)){
                if(set.contains(b))
                    bw.write(1+"\n");
                else
                    bw.write(0+"\n");
            }
            else if("toggle".equals(a)){
                if(set.contains(b))
                    set.remove(b);
                else
                    set.add(b);
            }
            else if("all".equals(a)){
                set = new HashSet<>();
                for(int j=1;j<=20;j++){
                    set.add(j);
                }
            }else if("empty".equals(a)){
                set = new HashSet<>();
            }
        }
        bw.flush();
        bw.close();
    }

}
