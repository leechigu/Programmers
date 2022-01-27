public class 이천십육년 {


    public String solution(int a, int b) {
        int[] days = {31,29,31,30,31,30,31,31,30,31,30,31};

        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int sum =0;
        for(int i = 0;i<a-1;i++){
            sum += days[i];
        }
        sum +=b;
        sum+=4;

        System.out.println(day[sum%7]);
        return day[(sum%7)];
    }



}
