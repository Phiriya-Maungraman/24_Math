package lib;

import java.util.Stack;
public class ReicveNum {
    private String number;
    private double result;

    public ReicveNum(String expression) {
        this.number = expression;
        this.result = process(expression);
    }
    public double process(String expression){
        char[] tokens =  expression.toCharArray();

        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++){
            if (tokens[i] == ' ') continue;

            // หากเป็นตัวเลข
            if(tokens[i]>='0' && tokens[i] <= '9'){
                StringBuilder num = new StringBuilder();
                while (i<tokens.length && tokens[i] >= '0' && tokens[i] <='9'){
                    num.append(tokens[i++]);
                    
                }
                i--;
                values.push(Double.parseDouble(num.toString()));

            }
            // หากเจอวงเล็บเปิด '('
            else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            }

            // หากเจอวงเล็บปิด ')' ให้คำนวณค่าในวงเล็บย้อนหลัง
            else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            }
            // หากเจอเครื่องหมาย +, -, *, /
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!ops.empty() && priority(tokens[i], ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(tokens[i]);
            }
              
        }
            while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }
        return values.pop();
        
   
    }
    // ลำดับความสำคัญของเครื่องหมาย (Precedence)
    private boolean priority(char op1,char op2){
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;

    }
    private double applyOp(char op, double b, double a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }


    public String getresult(){
        return String.valueOf(result);
    }
    



}