package 프로그래머스.LEVEL2;

import java.util.Arrays;
import java.util.Comparator;

public class three차파일정렬 {

    public String[] solution(String[] files) {
        String[] answer = null;

        String[][] strSlice = new String[files.length][];

        for(int i=0;i<files.length;i++){
            String temp = files[i];
            int numIndx = 0;
            for(int j=0;j<temp.length();j++){
                char tempChar = temp.charAt(j);
                if(tempChar-'0'>=0&&tempChar-'0'<=9){
                    numIndx = j;
                    break;
                }
            }
            int tailIndx = temp.length();
            for(int j=numIndx;j<temp.length();j++){
                char tempChar = temp.charAt(j);
                if(tempChar-'0'<0||tempChar-'0'>9){
                    tailIndx = j;
                    break;
                }
            }

            String head = temp.substring(0,numIndx);
            String num = temp.substring(numIndx,tailIndx);
            String tail = temp.substring(tailIndx,temp.length());

            strSlice[i] = new String[]{head, num, tail};
        }


        Arrays.sort(strSlice, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                String head1 = o1[0].toLowerCase();
                String head2 = o2[0].toLowerCase();

                if(head1.equals(head2)){
                    int num1 = Integer.parseInt(o1[1]);
                    int num2 = Integer.parseInt(o2[1]);

                    return num1-num2;
                }
                else {
                    return head1.compareTo(head2);
                }
            }
        });

        answer = new String[strSlice.length];

        for(int i=0;i< strSlice.length;i++)
        {
            answer[i] = strSlice[i][0]+strSlice[i][1]+strSlice[i][2];
        }

        return answer;
    }
}
