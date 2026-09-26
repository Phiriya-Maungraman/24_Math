import java.util.*;
import java.util.function.Supplier;
import javax.swing.JButton;

public class RandomNumber {
    private  JButton[] buttons;
    Supplier<Integer> randomDigit = () -> (int)(Math.random() * 10);

    public RandomNumber(JButton[] buttons) {
        this.buttons = buttons;
    }

    public void randomizeAll(){
        for (JButton btn : buttons) {
            btn.setText(String.valueOf(randomDigit.get()));
        }
    }
}