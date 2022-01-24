public class TriangleNum {
    public int solution(int[][] triangle) {
        int[][] dp =new int[triangle.length][];
        for(int i = 0;i<dp.length;i++){
            dp[i] = new int[triangle[i].length];
        }
        dp[0][0] = triangle[0][0];
        if(triangle.length==1)
            return dp[0][0];
        if(triangle.length>=2){
            dp[1][0] = dp[0][0]+triangle[1][0];
            dp[1][1] = dp[0][0]+triangle[1][1];
        }
        if(triangle.length==2){
            return Math.max(dp[1][1],dp[1][0]);
        }
        for(int i=2;i<dp.length;i++){
            dp[i][0] = triangle[i][0]+dp[i-1][0];
            for(int j=1;j<i+1;j++){
                if(j==i) {
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1],dp[i-1][j]);
                }
            }
        }
        int max = 0;
        for(int i=0;i<dp[dp.length-1].length;i++){
            max = Math.max(dp[dp.length-1][i],max);
        }
        return max;
    }
}
