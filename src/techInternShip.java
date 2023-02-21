public class techInternShip {

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        int[] x = new int[4];
        int[] y = new int[4];

        char[] c1 = {'R','C','J','A'};
        char[] c2 = {'T','F','M','N'};

        for(int i=0;i<choices.length;i++){

            char a = survey[i].charAt(0);
            int indx = -1;
            boolean is1 = false;
            for(int j=0;j<4;j++){
                if(c1[j] == a){
                    is1 = true;
                    indx = j;
                    break;
                }
                else if(c2[j] ==a){
                    is1 = false;
                    indx = j;
                    break;
                }

            }

            if(is1){
                int choice = -1*(choices[i]-4);
                x[indx] += choice;

            }else{
                int choice = -1*(choices[i]-4);
                y[indx] += choice;
            }
        }



        for(int i=0;i<4;i++){
            if(x[i]>y[i]){
                answer+=c1[i];
            }else if(x[i]==y[i]){
                answer+=c1[i];
            }else{
                answer+=c2[i];
            }
        }

        return answer;
    }

}
