import javax.swing.JButton;
import javax.swing.JLabel;

import lib.function.*;

public class TestRunner {
     static int pass = 0, fail = 0;

    static void check(String name, boolean ok) {
        if (ok) { pass++; System.out.println("  [PASS] " + name); }
        else    { fail++; System.out.println("  [FAIL] " + name); }
    }

        static double calc(String expr) {
        return Double.parseDouble(new ReicveNum(expr).getresult());
    }

    static void TestCal(){
        boolean threw = false;
        try { calc("5/(3-3)"); }
        catch (UnsupportedOperationException e) { threw = true;}
        System.out.println("Test 1: ReicveNum");
        check("หารด้วย 0 ต้องโยน exception", threw);
       check("2+3*4 = 14 (คูณก่อนบวก)", calc("2+3*4") == 14.0);
        check("(2+3)*4 = 20 (วงเล็บ)", calc("(2+3)*4") == 20.0);
        check("(1+2+3)*4 = 24", calc("(1+2+3)*4") == 24.0);
        check("10-2*3 = 4", calc("10-2*3") == 4.0);
        check("8-3-2 = 3 (ซ้ายไปขวา)", calc("8-3-2") == 3.0);
    }

        static void TestUser(){
        boolean threw = false;
        try { calc("5/(3-3)"); }
        catch (UnsupportedOperationException e) { threw = true;}
        System.out.println("Test Username");
        check("isAlphaNume('abc123') = true", Validator.isAlphaNume("abc123"));
        check("isAlphaNume('abc_1') = false", !Validator.isAlphaNume("abc_1"));
        check("isAlphaNume('') = false", !Validator.isAlphaNume(""));
        check("isValidUserName('123') = false (ไม่มีตัวอักษร)", !Validator.isValidUserName("123"));
        check("isValidPassword('abc123!') = true", Validator.isValidPassword("abc123!"));
        check("isValidPassword('abcdefgh') = false", !Validator.isValidPassword("abcdefgh"));
        check("isValidPassword('abc12345') = false (ไม่มีอักขระพิเศษ)", !Validator.isValidPassword("abc12345"));
        check("isPasswordMatch ตรงกัน", Validator.isPasswordMatch("a1!", "a1!"));
        check("isPasswordMatch ไม่ตรงกัน", !Validator.isPasswordMatch("a1!", "a1?"));
    }

        static int score(String result, String mode) {
        JLabel lb = new JLabel("0");
        ScoreManager.checkScore(result, lb, mode);
        return Integer.parseInt(lb.getText());
    }

        static void TestScore(){
        boolean threw = false;
        System.out.println("Test ScoreManager");
        check("Four: 24 = +3", score("24", "Four") == 3);
        check("Five: 25 = +2", score("25", "Five") == 2);
        check("Rush: 20 = +1", score("20", "Rush") == 1);
        check("Four: 10 = +0", score("10", "Four") == 0);
        check("SS: 67 = +3", score("67", "SS") == 3);
        check("SS: 24 = +0 (ไม่ใช่เป้าหมายของโหมด 67)", score("24", "SS") == 0);
        JLabel lb = new JLabel("5");
        ScoreManager.checkScore("24", lb, "Four");
        check("คะแนนสะสม 5 + 3 = 8", lb.getText().equals("8"));
    }

        static void TestRandomNum(){
        boolean threw = false;
        System.out.println("Test RandomNumber");
        JButton[] btns = { new JButton("0"), new JButton("0"), new JButton("0"), new JButton("0") };
        RandomNumber rn = new RandomNumber(btns);
        boolean allInRange = true;
        for (int round = 0; round < 1000; round++) {
            rn.randomizeAll();
            for (JButton b : btns) {
                int v = Integer.parseInt(b.getText());
                if (v < 1 || v > 9) allInRange = false;
            }
        }
        check("สุ่ม 1000 รอบ ทุกปุ่มอยู่ในช่วง 1-9 (ไม่มี 0)", allInRange);
    }
    
        static void TestKeepScore(){
        boolean threw = false;
        System.out.println("Test ScoreBoard");
        // (a) User เก็บคะแนนแยกตามโหมด - ควรผ่านอยู่แล้ว
        User u = new User("tester", "pw", 1, 2, 3, 4);
        u.setHighScore("Five", 99);
        check("setHighScore Five -> getScore Five = 99", u.getScore("Five") == 99);
        check("โหมดอื่นไม่ถูกกระทบ (Four = 1)", u.getScore("Four") == 1);
        check("toCsvRow ถูกรูปแบบ", u.toCsvRow().equals("tester,pw,1,99,3,4"));
        check("โหมดที่ไม่รู้จักคืน 0", u.getScore("Unknown") == 0);
    }
    //*เปิด Maingui */
    public static void main(String[] args) {
         //*ข้างล่างตรงนี้เป็น Test*/
         boolean ea = false;
        assert ea = true;

        System.out.println("== 24 Game ==");

        //*Test 5 ตัว*
        //ReicveNum
        //ตรวจ username/password
        //การให้คะแนน
        //RandomNumber
        //เก็บคะแนนแยกโหมด

        TestCal();
        TestUser();
        TestScore();
        TestRandomNum();
        TestKeepScore();

        System.out.println("==================================");
        System.out.printf("PASS %d / FAIL %d%n", pass, fail);
        System.out.println("==================================");
        System.exit(fail == 0 ? 0 : 1);
    
        }
        
    }
    
