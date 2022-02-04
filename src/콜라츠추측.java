public class 콜라츠추측 {
    public int solution(long num) {
        if(num ==1)
            return 0;
        int count  =0;
        while(true){
            count++;
            if(count >500)
                return -1;
            if(num%2==0){
                num = num/2;
            }
            else{
                num =(num*3) +1;
            }
            if(num==1){
                return count;
            }
        }
    }
}
