package lib.function;

import java.util.function.Supplier;
import javax.swing.JButton;

/* สุ่มเลข 1-9 แล้วนำไปแสดงบนปุ่มทุกปุ่ม */
/**
 * @param buttons     อาร์เรย์ปุ่มที่จะถูกเปลี่ยนข้อความ
 * @param randomDigit ฟังก์ชันสุ่มเลข 1-9
 */

public class RandomNumber {
    private JButton[] buttons;
    Supplier<Integer> randomDigit = () -> (int) (Math.random() * 9) + 1;

    public RandomNumber(JButton[] buttons) {
        this.buttons = buttons;
    }

    public void randomizeAll() {
        for (JButton btn : buttons) {
            btn.setText(String.valueOf(randomDigit.get()));
        }
    }
}