public class 멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer;
        long width = w;
        long height = h;
        answer =  (long)width*height;
        long min = Math.min(w,h);
        long max = Math.max(w,h);
        if(min==1||max==1){
            return 0;
        }
        long count=0;
        for(int i=1;i<=min;i++){
            double x = (double)i*max;
            x = (double)x/min;
            if(x-(int)x!=0.0){
                count++;
            }
        }
        answer -=count +max;
        return answer;
    }
}
