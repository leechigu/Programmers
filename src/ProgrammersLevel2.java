import java.util.ArrayList;

public class ProgrammersLevel2 {




    public long solution(String expression) {

        String temp = expression;

        int count =0;
        String x ="";
        ArrayList<Integer> operand = new ArrayList<>();
        ArrayList<String> operator = new ArrayList<>();

        for(int i=0;i<temp.length();i++)
        {
            if(temp.charAt(i)=='*'){
                for(int j = i-count;j<i;j++){
                    x +=temp.charAt(j);
                }
                int a = Integer.parseInt(x);
                x ="";
                operand.add(a);
                count =0;
                operator.add("*");
            }
            else if(temp.charAt(i)=='-'){
                for(int j = i-count;j<i;j++){
                    x+=temp.charAt(j);
                }
                int a = Integer.parseInt(x);
                x ="";
                operand.add(a);
                count =0;
                operator.add("-");
            }
            else if(temp.charAt(i)=='+'){
                for(int j = i-count;j<i;j++){
                    x +=temp.charAt(j);
                }
                int a = Integer.parseInt(x);
                operand.add(a);
                x ="";
                count =0;
                operator.add("+");
            }
            else{
                count++;
            }
        }
        for(int j = temp.length()-count;j<temp.length();j++){
            x +=temp.charAt(j);
        }
        int a = Integer.parseInt(x);
        x ="";
        operand.add(a);

        for(int i = 0; i<operand.size();i++){
            System.out.println(operand.get(i));
        }
        for(int i = 0; i<operator.size();i++){
            System.out.println(operator.get(i));
        }

        int max = 0;

        int testcase=1;
        for(int i=operator.size();i>0;i--){
            testcase *=i;
        }
        System.out.println(testcase);

        ArrayList<String> test;
        for(int i =0;i<testcase;i++){
            test = new ArrayList<>();


        }


        int answer =0;
        return answer;
    }
}
