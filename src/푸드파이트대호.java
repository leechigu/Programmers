public class 푸드파이트대호 {

    public String solution(int[] food) {

        for(int i=1;i<food.length;i++){

            if(food[i]%2!=0) {
                food[i]--;
            }
        }

        String head = "";
        String tail = "";

        for(int i=1;i<food.length;i++){

            for(int j=0;j<food[i]/2;j++){

                head = head + String.valueOf(i);
                tail = String.valueOf(i)+tail;

            }
        }



        String answer = "";

        answer = head + "0" +tail;
        return answer;

    }

}
