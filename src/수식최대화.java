import java.util.ArrayList;

public class 수식최대화 {
    static ArrayList<Long> operands;
    static ArrayList<Character> operators;
    static char[] chars = {'-','+','*'};
    static long Max = 0;
    static boolean isFirst=true;
    static char[] output = new char[chars.length];
    static boolean[] visited = new boolean[chars.length];
    static void perm(int depth){
        if(depth ==chars.length){
            char a = output[0];
            char b = output[1];
            char c = output[2];
            long temp =calc(a,b,c);
            System.out.print(a+" ");
            System.out.print(b+" ");
            System.out.println(c);
            if(temp<0)
                temp*=-1;
            if(temp>Max){
                Max = temp;
            }
            return;
        }
        for(int i=0;i<chars.length;i++){
            if(visited[i]!=true){
                visited[i] = true;
                output[depth] = chars[i];
                perm(depth+1);
                visited[i] = false;
            }
        }
    }



    static long calc(char a,char b,char c){
        ArrayList<Character> tempOperator = new ArrayList<>(operators);
        ArrayList<Long> tempOperands =new ArrayList<>(operands);
        for(int i=0;i<tempOperator.size();i++){
            if(tempOperator.get(i)==a){
                Long x = tempOperands.get(i);
                Long y = tempOperands.get(i+1);
                long temp=0;
                if(a=='-')
                    temp = x-y;
                else if(a=='*')
                    temp = x*y;
                else if(a=='+')
                    temp = x+y;
                tempOperands.set(i+1,temp);
                tempOperands.remove(i);
                tempOperator.remove(i);
                i--;
            }
        }
        for(int i=0;i<tempOperator.size();i++){
            if(tempOperator.get(i)==b){
                Long x = tempOperands.get(i);
                Long y = tempOperands.get(i+1);
                System.out.println(i +" = "+ x);
                System.out.println(i+"+1 = "+ y);

                long temp=0;
                if(b=='-')
                    temp = x-y;
                else if(b=='*')
                    temp = x*y;
                else if(b=='+')
                    temp = x+y;
                tempOperands.set(i+1,temp);
                tempOperands.remove(i);
                tempOperator.remove(i);
                i--;
            }
        }
        for(int i=0;i<tempOperator.size();i++){
            if(tempOperator.get(i)==c){
                Long x = tempOperands.get(i);
                Long y = tempOperands.get(i+1);
                System.out.println(i +" = "+ x);
                System.out.println(i+"+1 = "+ y);
                long temp=0;
                if(c=='-')
                    temp = x-y;
                else if(c=='*')
                    temp = x*y;
                else if(c=='+')
                    temp = x+y;
                tempOperands.set(i+1,temp);
                tempOperands.remove(i);
                tempOperator.remove(i);
                i--;
            }
        }
        return tempOperands.get(0);
    }



    public long solution(String expression) {
        operands = new ArrayList<>();
        operators = new ArrayList<>();
        int numPoint=0;
        boolean x =false;
        for(int i=0;i<expression.length();i++){
            char temp =expression.charAt(i);
            if(temp=='-'||temp=='*'||temp=='+'){
                String numberString = expression.substring(numPoint,i);
                operands.add(Long.parseLong(numberString));
                operators.add(temp);
                x = true;
            }
            else{
                if(x){
                    numPoint = i;
                    x = false;
                }
            }
        }
        operands.add(Long.parseLong(expression.substring(numPoint)));


        perm(0);
        long answer =Max;
        return answer;
    }
}
