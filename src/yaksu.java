public class yaksu {
    public int yaksu(int num){
        int count =0;
        for(int i =1;i<=num;i++){
            if(num%i==0)
                count++;
        }
        return count;
    }

    public int solution(int left, int right) {

        int sum = 0;
        for(int i=left;i<=right;i++){
            if(yaksu(i)%2==0)
                sum+=i;
            else
                sum-=i;
        }
        return sum;
    }
}
