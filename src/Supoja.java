public class Supoja {
    public int[] solution(int[] answers) {
        int[] supoja1 = new int[10000];
        int[] supoja2 = new int[10000];
        int[] supoja3 = new int[10000];

        for(int i=0;i<10000;i++){
            if(i%5==0){
                supoja1[i] =1;
            }
            else if(i%5==1) {
                supoja1[i] = 2;
            }
            else if(i%5==2){
                supoja1[i]=3;
            }
            else if(i%5==3){
                supoja1[i]=4;
            }
            else if(i%5==4){
                supoja1[i]=5;
            }
        }
        for(int i=0;i<10000;i++){
            if(i%2==0){
                supoja2[i]=2;
            }
            else{
                if((i/2)%4==0){
                    supoja2[i] =1;
                }
                else if((i/2)%4==1) {
                    supoja2[i] = 3;
                }
                else if((i/2)%4==2){
                    supoja2[i]=4;
                }
                else if((i/2)%4==3){
                    supoja2[i]=5;
                }
            }
        }
        for(int i = 0;i<10000;i++){
            if((i%10)/2==0){
                supoja3[i]=3;
            }
            else if((i%10)/2==1){
                supoja3[i]=1;
            }
            else if((i%10)/2==2){
                supoja3[i]=2;
            }
            else if((i%10)/2==3){
                supoja3[i]=4;
            }
            else if((i%10)/2==4){
                supoja3[i]=5;
            }
        }
        int cnt1=0,cnt2=0,cnt3=0;
        for(int i =0;i<answers.length;i++){

            if(answers[i]==supoja1[i]){
                cnt1++;
            }
            if(answers[i]==supoja2[i]){
                cnt2++;
            }
            if(answers[i]==supoja3[i]){
                cnt3++;
            }
        }
        int max =-1;
        int maxcnt=0;
        if(cnt1>=max)
            max = cnt1;
        if(cnt2>=max)
            max = cnt2;
        if(cnt3>=max)
            max = cnt3;

        if(max ==cnt1)
            maxcnt++;
        if(max ==cnt2)
            maxcnt++;
        if(max ==cnt3)
            maxcnt++;

        int[] answer = new int[maxcnt];
        int x =0;
        if(max ==cnt1){
            answer[x]=1;
            x++;
        }
        if(max ==cnt2){
            answer[x]=2;
            x++;
        }
        if(max ==cnt3){
            answer[x] =3;
            x++;
        }
        return answer;

    }

}
