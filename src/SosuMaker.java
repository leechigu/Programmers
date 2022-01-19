public class SosuMaker {


    public boolean sosuCheck(int num){
        int count = 0;
        for(int i=1;i<=num;i++){
            if(num%i==0)
                count++;
        }
        if(count==2){
            return true;
        }
        else{
            return false;
        }
    }



    public int solution(int[] nums) {

        int sum=0;
        int count  =0;
        for(int i=0;i<nums.length-2;i++){
            for(int j = i+1;j<nums.length-1;j++){
                for(int k= j+1;k<nums.length;k++){
                    sum+=nums[i]+nums[j]+nums[k];
                    if(sosuCheck(sum)){
                        count++;
                    }
                    sum = 0;
                }
            }
        }
        return count;
    }
}
