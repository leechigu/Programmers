public class 최고의집합 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n>s)
            return new int[]{-1};
        int x = s/n;
        for(int i=0;i<n;i++)
            answer[i] = x;
        int y = s%n;
        if(y!=0)
            for(int i=n-1;i>=n-y;i--)
                answer[i]+=1;
        return answer;
    }

}
