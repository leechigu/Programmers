package 프로그래머스.LEVEL2;

import java.util.*;

public class 과제진행하기 {

    public String[] solution(String[][] plans) {
        int indx = 0;
        String[] answer = new String[plans.length];
        Stack<String[]> stack = new Stack<>();

        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });

        stack.add(plans[0]);

        String[] t = plans[0][1].split(":");
        int lastStTime = Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);

        for(int i=1;i<plans.length;i++) {
            String[] plan = plans[i];
            String start = plan[1];
            String[] stTime = start.split(":");
            int curTime = Integer.parseInt(stTime[0]) * 60 + Integer.parseInt(stTime[1]);
            int totalTime = curTime - lastStTime;
            lastStTime = curTime;
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    String[] temp = stack.pop();
                    String tempName = temp[0];
                    int playTempTime = Integer.parseInt(temp[2]);
                    if (totalTime >= playTempTime) {
                        answer[indx] = tempName;
                        indx++;
                        totalTime -= playTempTime;
                        if (totalTime <= 0)
                            break;
                    } else {
                        playTempTime -= totalTime;
                        temp[2] = String.valueOf(playTempTime);
                        stack.add(temp);
                        break;
                    }
                }
            }
            stack.add(plans[i]);
        }

        return answer;
    }

}
