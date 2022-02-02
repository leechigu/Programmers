import java.util.ArrayList;

public class 다트게임 {


    public int solution(String dartResult) {

        StringBuffer stb = new StringBuffer(dartResult);

        int[] numbers = new int[3];

        String level;
        //num,sdt,pri
        int count =0;
        String number ="";
        int t;
        for(int i=0;i<stb.length();i++){
            char temp =stb.charAt(i);
            if(temp>=48 &&temp<=57){
                number +=temp;
            }
            else if(temp =='S'){
                t = Integer.parseInt(number);
                number = "";
                t = t;
                numbers[count] = t;
                count++;
            }
            else if(temp=='D'){
                t = Integer.parseInt(number);
                number = "";
                t = t*t;
                numbers[count] = t;
                count++;
            }
            else if(temp=='T'){
                t = Integer.parseInt(number);
                number = "";
                t = t*t*t;
                numbers[count] = t;
                count++;
            }
            else if(temp =='*'){
                if(count>1){
                    numbers[count-1] *=2;
                    numbers[count-2] *=2;
                }
                else{
                    numbers[0] = numbers[0]*2;
                }
            }
            else if(temp=='#'){
                numbers[count-1] *=-1;
            }
        }
        int answer = numbers[0]+numbers[1]+numbers[2];
        return answer;
    }


}
