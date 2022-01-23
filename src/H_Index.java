public class H_Index {

    public int solution(int[] citations) {
        int h;
        int h_cnt;
        int max_h=0;
        for(int i =0;i<10000;i++){
            h_cnt =0;
            h = i;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=h)
                    h_cnt++;
            }
            if(h_cnt>=h&&h>=max_h) {
                max_h = h;
            }
        }
        return max_h;
    }

}
