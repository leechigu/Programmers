public class GhostNumberAdd {
    public int solution(int[] numbers) {

        int[] arr = new int[10];
        for(int i = 0; i<arr.length; i++)
            arr[i] =0;
        for (int i = 0; i<numbers.length;i++){
            arr[numbers[i]]++;
        }
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==0){
                sum+=i;
            }
        }
        return sum;
    }
}
