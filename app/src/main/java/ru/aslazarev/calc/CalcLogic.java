package ru.aslazarev.calc;

import java.util.Stack;

public class CalcLogic {

    public static String getResult(String expression){
        String result = new String();
        result = expressionPrepared(expression);
        result = String.valueOf(expressionExecute(result));
        return result;
    }

    private static String expressionPrepared(String expression){

        String current = "";
        Stack<Character> stack = new Stack<>();
        int priority;
        for (int i = 0; i < expression.length(); i++)
        {
            priority = getPriority(expression.charAt(i));
            if (priority == 0) current += expression.charAt(i);
            if (priority == 1) stack.push(expression.charAt(i));
            if (priority > 1)
            {
                current += ' ';
                while (!stack.empty()){
                    if(getPriority(stack.peek()) >= priority) current += stack.pop();
                    else break;
                }
                stack.push(expression.charAt(i));
            }
            if (priority == -1)
            {
                current += ' ';
                while (getPriority(stack.peek()) != 1) {
                    current += stack.pop();
                }
                stack.pop();
            }
        }
        while (!stack.empty())
        {
            current += stack.pop();
        }

        return current;
    }

    private static double expressionExecute(String expression){
        String operand = new String();
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++)
        {
            if (expression.charAt(i) == ' ') continue;

            if (getPriority(expression.charAt(i)) == 0)
            {
                while (expression.charAt(i) != ' ' && getPriority(expression.charAt(i)) == 0)
                {
                    operand += expression.charAt(i++);
                    if(i == expression.length()) break;
                }
                stack.push(Double.parseDouble(operand));
                operand = new String();
            }

            if(getPriority(expression.charAt(i)) > 1)
            {
                double tmp1 = stack.pop();
                double tmp2 = stack.pop();

                switch (expression.charAt(i)){
                    case '+': stack.push(tmp2 + tmp1); break;
                    case '-': stack.push(tmp2 - tmp1); break;
                    case 'x': stack.push(tmp2 * tmp1); break;
                    case '/': stack.push(tmp2 / tmp1); break;
                }

            }


        }

        return stack.pop();
    }

    private static int getPriority(char token){
        if (token == 'x' || token == '/') return 3;
        else if (token == '+' || token == '-') return 2;
        else if (token == '(') return 1;
        else if (token == ')') return -1;
        else return 0;
    }


}
