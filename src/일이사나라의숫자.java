public class 일이사나라의숫자 {
    public String solution(int n) {
        int temp = n;
        int num = 1;
        int count =0;
        while(true){
            if(n/num==0){
                break;
            }
            count++;
            num = num*3;
        }
        num = num/3;

        int[] arr = new int[count];
        while(true){
            arr[count-1]=n/num;
            n = n-(arr[count-1]*num);
            num = num/3;
            if(count==1)
                break;
            count--;
        }
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==0){
                if(arr[i+1]==4){
                    arr[i+1]=2;
                }
                else{
                    arr[i+1]--;
                }
                arr[i]=4;
            }
        }
        String answer = "";
        for(int i=arr.length-1;i>=0;i--) {
            answer += String.valueOf(arr[i]);
        }

        if(answer.charAt(0)=='0'){
            answer = answer.substring(1,answer.length());
        }
        return answer;
    }
}
