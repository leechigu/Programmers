import java.util.Arrays;

public class 문자열압축 {

    public int solution(String s) {
        StringBuffer sb = new StringBuffer(s);
        int[] answer = new int[s.length()];
        for(int i=1;i<=s.length();i++){
            String temp = "";
            if(i==s.length()){
                answer[i-1] = s.length();
                break;
            }
            int stNum;
            if(sb.length()%i==0)
                stNum = s.length()/i;
            else
                stNum = s.length()/i+1;
            String[] x= new String[stNum];
            for(int j = 0;j<stNum;j++){
                x[j] ="";
            }
            int cnt = 0;
            for(int j =0;j<stNum;j++){
                int end;
                if((cnt+i)>s.length()){
                    end = s.length();
                }
                else
                    end = cnt+i;
                for(int k =cnt;k<end;k++){
                    x[j] += sb.charAt(k);
                }
                cnt = end;
            }
            for(int j=0;j<stNum-1;j++){
                int countEqual =0;
                for(int k=j;k<stNum;k++){
                    if(k==stNum-1){
                        if(x[j].equals(x[k])){
                            countEqual++;
                            if(countEqual >1){
                                temp+=String.valueOf(countEqual)+x[j];
                                j=stNum;
                                break;
                            }
                            else{
                                temp+=x[j];
                                break;
                            }
                        }
                        else{
                            if(countEqual >1){
                                temp+=String.valueOf(countEqual)+x[j]+x[k];
                                j=stNum;
                                break;
                            }
                            else{
                                temp+=x[j]+x[k];
                                break;
                            }
                        }
                    }
                    if(x[j].equals(x[k])){
                        countEqual++;
                    }
                    else{
                        if(countEqual >1){
                            temp+=String.valueOf(countEqual)+x[j];
                            j = k-1;
                            break;
                        }
                        else{
                            j = k-1;
                            temp+=x[j];
                            break;
                        }
                    }
                }
            }
            answer[i-1] = temp.length();
        }
        Arrays.sort(answer);
        return answer[0];
    }

}

//