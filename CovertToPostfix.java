package algorithm1;

import java.util.Stack;

public class CovertToPostfix {
    public static String CovertToPostfix(String expr){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <expr.length() ; i++) {
            char c = expr.charAt(i);

            //check if char is operator
            if(isoperator(c)>0){
                while(stack.isEmpty()==false && isoperator(stack.peek())>=isoperator(c)){
                    sb.append(stack.pop());
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    sb.append(x);
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor (
                sb.append(c);
            }
        }
        for (int i = 0; i <=stack.size() ; i++) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    private static int isoperator(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        String expra ="a*b/(c-d)";
        String exprb ="(a-b*c)/(d*e*f+g)";
        String exprc ="a/b*(c+(d-e))";
        System.out.println(CovertToPostfix(expra));
        System.out.println(CovertToPostfix(exprb));
        System.out.println(CovertToPostfix(exprc));
    }
}
