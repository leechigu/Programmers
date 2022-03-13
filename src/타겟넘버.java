public class 타겟넘버 {
    public static int cnt =0;
    public static int[] arr;
    public static void dfs(int depth,int target,int sum){
        if(depth == arr.length){
            if(sum == target)
                cnt++;
            return;
        }
        sum+=arr[depth];
        dfs(depth+1,target,sum);
        sum-=arr[depth];
        sum-=arr[depth];
        dfs(depth+1,target,sum);
    }
    public int solution(int[] numbers, int target) {
        arr = numbers;
        dfs(0,target,0);
        int answer = cnt;
        return answer;
    }

}
