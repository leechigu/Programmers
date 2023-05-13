package 백준;

import java.util.Scanner;

public class 백준10798 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String[] words = new String[5];

        for(int i=0;i<5;i++){
            words[i] = sc.nextLine();
        }

        String rtn = "";

        int maxLen = 0;

        for(int i=0;i<5;i++){
            if(words[i].length()>maxLen)
                maxLen = words[i].length();
        }
        for(int i=0;i<5;i++){
            int target = maxLen-words[i].length();
            for(int j=0;j<target;j++){
                words[i] +="-";
            }
        }

        for(int i=0;i<maxLen;i++){
            for(int j=0;j<5;j++){
                if(words[j].charAt(i)=='-')
                    continue;

                rtn += words[j].charAt(i);
            }
        }
        System.out.print(rtn);
    }

}
