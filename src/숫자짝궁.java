public class 숫자짝궁 {
    public String solution(String X, String Y) {
        String answer = "";

        StringBuffer x = new StringBuffer(X);
        StringBuffer y = new StringBuffer(Y);

        long [] arr1 = new long[10];
        long [] arr2 = new long[10];

        for(int i=0;i<x.length();i++){
            char temp = x.charAt(i);
            int a = temp-'0';
            arr1[a]++;
        }

        for(int i=0;i<y.length();i++){
            char temp = y.charAt(i);
            int a = temp-'0';
            arr2[a]++;
        }

        StringBuffer ansS = new StringBuffer();

        for(int i=9;i>=0;i--){
            if(arr1[i]>0&&arr2[i]>0){
                long min = -1;
                if(arr1[i]>arr2[i]){
                    min = arr2[i];
                }else{
                    min = arr1[i];
                }

                String t = String.valueOf(i);

                for(int j=0;j<min;j++) {
                    ansS.append(t);
                }
            }
        }

        if(ansS.length()==0){
            return "-1";
        }
        else {
            if (ansS.charAt(0) == '0')
                return "0";
        }
        return ansS.toString();
    }
}
