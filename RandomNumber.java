import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JLabel;

public class RandomNumber {
    Supplier<Integer> randomDigit = () -> (int)(Math.random() * 10);
MainGui ui = new MainGui();
JButton[] buttons = ui.getButtons()   // ดึงปุ่มตัวจริงออกมา

for (JButton btn : buttons) {
    btn.addActionListener(e -> btn.setText(String.valueOf(randomDigit.get())));
}
    int num = randomDigit.get();     // ได้เลขสุ่มมา
    box.setText(String.valueOf(num)); // แสดงผล
    };
