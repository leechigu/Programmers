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

        for(int i= arr.length-1;i>=0;i--){
            arr[i] = n/num;
            n = n-(arr[i]*num);
            num = num/3;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        int c=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==0){
                c++;
                arr[i]=2;
                if(c==1){
                    arr[i] =4;
                }
                if(arr[i+1]!=0){
                    arr[i+1]--;
                    if(arr[i+1]==3){
                        arr[i+1]--;
                    }
                    c=0;
                }
                i--;
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
