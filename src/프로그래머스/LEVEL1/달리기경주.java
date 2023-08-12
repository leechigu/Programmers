package 프로그래머스.LEVEL1;

import java.util.ArrayList;

public class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};

        for(int i=0;i<callings.length;i++){
            String call = callings[i];
            for(int j=0;j<players.length;j++){
                if(players[j].equals(call)){
                    String temp = players[j];
                    players[j] = players[j+1];
                    players[j+1] = temp;
                }
            }
        }

        return players;
    }


}
