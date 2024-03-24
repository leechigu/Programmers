package 백준;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class 백준20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String st = br.readLine();
        String[] sts = st.split(" ");
        int n = Integer.valueOf(sts[0]);
        int m = Integer.valueOf(sts[1]);
        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            String str = br.readLine();
            if(str.length()<m)
                continue;

            if(map.containsKey(str))
                map.put(str,map.get(str)+1);
            else
                map.put(str,1);
        }

        String[] ans = new String[map.size()];
        int indx = 0;

        for(String str : map.keySet()){
            ans[indx] = str;
            indx++;
        }

        Arrays.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a = map.get(o1);
                int b = map.get(o2);

                if(a==b){
                    if(o1.length()==o2.length()){
                        return o1.compareTo(o2);
                    }
                    else{
                        return o2.length()-o1.length();
                    }
                }else{
                    return b-a;
                }

            }
        });

        for(String str : ans){
            bw.write(str+"\n");
        }

        String a = "dassdd";

        bw.flush();
        bw.close();
    }
}
