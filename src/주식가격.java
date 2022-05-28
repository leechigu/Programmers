public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];


        for(int i=0;i<prices.length;i++){
            int cnt = prices.length-i-1;
            for(int j=0;j<prices.length;j++){
                if(prices[i]>prices[j]){
                    cnt = i-j;
                    break;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }

}
