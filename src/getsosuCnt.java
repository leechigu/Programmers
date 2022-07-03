import java.util.ArrayList;

public class getsosuCnt {
    public boolean isSosu(String st){
        if(st==null || st.equals(""))
            return false;
        long temp = Long.parseLong(st);
        if(temp<2)
            return false;
        if(temp==2)
            return true;
        boolean check = true;

        for(int i=2;i<Math.sqrt(temp)+1;i++){
            if(temp%i==0){
                check = false;
                break;
            }
        }
        return check;
    }
    public int solution(int n, int k) {
        String primeString = "";
        int primeCol =1;
        while(true){
            primeCol *=k;
            if(primeCol>n)
                break;
        }
        while(true){
            primeCol/=k;
            if(primeCol==1){
                primeString = primeString + n;
                break;
            }
            int ahrt = n/primeCol;
            n -=ahrt*(primeCol);
            String temp = String.valueOf(ahrt);

            primeString = primeString + temp;
        }

        ArrayList<String> arrayList = new ArrayList<>();

        String[] splitStrings = primeString.split("0");

        if(splitStrings.length==0)
            return 0;

        for(int i=0;i< splitStrings.length;i++)
            arrayList.add(splitStrings[i]);

        int answer = 0;

        for(String splitString : arrayList){
            if(isSosu(splitString)){
                answer++;
            }
        }

        return answer;
    }
}
