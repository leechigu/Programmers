public class 이진변환반복하기 {

    public int[] solution(String s) {


        String number = s;
        int[] answer = {0,0};

        int seqNum = 0;
        int delZeroCnt = 0;


        while(true){
            if(number.equals("1")){
                break;
            }
            int zeroCnt = 0 ;

            for(int i=0;i<number.length();i++){
                if(number.charAt(i)=='0'){
                    zeroCnt++;
                }
            }

            number = number.replace("0","");
            delZeroCnt+=zeroCnt;

            int length = number.length();

            number = Integer.toBinaryString(length);
            seqNum++;
        }
        answer[0] = seqNum;
        answer[1] = delZeroCnt;
        return answer;
    }
}
