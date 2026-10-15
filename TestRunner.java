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
        check("Division by zero must throw exception", threw);
        check("2+3*4 = 14 (multiplication before addition)", calc("2+3*4") == 14.0);
        check("(2+3)*4 = 20 (parentheses)", calc("(2+3)*4") == 20.0);
        check("(1+2+3)*4 = 24", calc("(1+2+3)*4") == 24.0);
        check("10-2*3 = 4", calc("10-2*3") == 4.0);
        check("8-3-2 = 3 (left to right)", calc("8-3-2") == 3.0);
    }

    static void TestUser(){
        boolean threw = false;
        try { calc("5/(3-3)"); }
        catch (UnsupportedOperationException e) { threw = true;}
        System.out.println("Test Username");
        check("isAlphaNume('abc123') = true", Validator.isAlphaNume("abc123"));
        check("isAlphaNume('abc_1') = false", !Validator.isAlphaNume("abc_1"));
        check("isAlphaNume('') = false", !Validator.isAlphaNume(""));
        check("isValidUserName('123') = false (no letters)", !Validator.isValidUserName("123"));
        check("isValidPassword('abc123!') = true", Validator.isValidPassword("abc123!"));
        check("isValidPassword('abcdefgh') = false", !Validator.isValidPassword("abcdefgh"));
        check("isValidPassword('abc12345') = false (no special characters)", !Validator.isValidPassword("abc12345"));
        check("isPasswordMatch match", Validator.isPasswordMatch("a1!", "a1!"));
        check("isPasswordMatch mismatch", !Validator.isPasswordMatch("a1!", "a1?"));
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
        check("SS: 24 = +0 (not target for mode 67)", score("24", "SS") == 0);
        JLabel lb = new JLabel("5");
        ScoreManager.checkScore("24", lb, "Four");
        check("Accumulated score 5 + 3 = 8", lb.getText().equals("8"));
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
        check("Randomized 1000 rounds, all buttons in range 1-9 (no 0)", allInRange);
    }
    
    static void TestKeepScore(){
        boolean threw = false;
        System.out.println("Test ScoreBoard");
        // (a) User stores scores per mode
        User u = new User("tester", "pw", 1, 2, 3, 4);
        u.setHighScore("Five", 99);
        check("setHighScore Five -> getScore Five = 99", u.getScore("Five") == 99);
        check("Other modes unaffected (Four = 1)", u.getScore("Four") == 1);
        check("toCsvRow correct format", u.toCsvRow().equals("tester,pw,1,99,3,4"));
        check("Unknown mode returns 0", u.getScore("Unknown") == 0);
    }

    /* Open MainGUI */
    public static void main(String[] args) {
        /* Below is the Test execution */
        boolean ea = false;
        assert ea = true;

        System.out.println("== 24 Game ==");

        /* 5 Test Suites */
        // ReicveNum
        // Username/password validation
        // Scoring system
        // RandomNumber generator
        // Score keeping per mode

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