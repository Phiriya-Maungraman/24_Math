package lib.function;
import java.util.Stack;

/**
 * ADT สำหรับการคำนวณตัวเลข โดยใช้ Stack ในการจัดการลำดับความสำคัญ
 * 
 */

public class ReicveNum {
    private String number;
    private double result;

/**
 * สร้างอ็อบเจกต์ ReicveNum คำนวณค่า
 * 
 * @param expression ค่าทางคณิตศาสตร์
 */

    public ReicveNum(String expression) {
        this.number = expression;
        this.result = process(expression);
    }

    /**
     * ทำการประมวลผลและคำนวณค่าที่รับเข้ามา
     * 
     * @param expression ค่าทางคณิตศาสตร์ที่ต้องการคำนวณ
     * @return ผลลัพธ์ของการคำนวณ
     * @throws UnsupportedOperationException หากเกิดข้อผิดพลาดในการคำนวณ
     */

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

    /**
     * ตรวจสอบลำดับความสำคัญของเครื่องหมาย
     * 
     * @param op1 เครื่องหมายตัวใหม่ที่กำลังจะนำเข้า Stack
     * @param op2 เครื่องหมายที่อยู่บนสุดของ Stack ในปัจจุบัน
     * @return true หาก op1 มีลำดับความสำคัญน้อยกว่าหรือเท่ากับ op2, false ถือว่ามากกว่า
     */

    private boolean priority(char op1,char op2){
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;

    }

    /**
     * ดำเนินการทางคณิตศาสตร์ระหว่างตัวเลขสองจำนวนตามเครื่องหมายที่กำหนด
     * 
     * @param op เครื่องหมายทางคณิตศาสตร์
     * @param b ตัวถูกดำเนินการตัวหลัง
     * @param a ตัวถูกดำเนินการตัวแรก
     * @return ผลลัพธ์จากการคำนวณ
     * @throws UnsupportedOperationException หากมีการหารด้วยศูนย์
     */

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

    /**
     * ดึงค่าผลลัพธ์ของการคำนวณ
     * 
     * @return ผลลัพธ์การคำนวณแปลงเป็น String
     */

    public String getresult(){
        return String.valueOf(result);
    }
    



}