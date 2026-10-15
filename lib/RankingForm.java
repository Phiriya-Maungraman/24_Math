package lib;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import lib.function.User;
import lib.function.UserManager;

public class RankingForm extends JDialog {
    Container cp;
    private String currentMode;

    public RankingForm(JFrame owner, String mode) {
        super(owner, "Ranking", true);
        this.currentMode = mode;
        Initial();
        rankingLeader();
        Finally();
    }

    public JLabel CreateLabel(String text, int fontSize, Color textColor, Color bgColor) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("", Font.BOLD, fontSize));
        label.setForeground(textColor);
        label.setBackground(bgColor);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(220, 220, 220)));

        cp.add(label);
        return label;
    }

    public void rankingLeader() {

        Color headerBg = new Color(50, 50, 50);
        CreateLabel("NO.", 22, Color.WHITE, headerBg);
        CreateLabel("Name", 22, Color.WHITE, headerBg);
        CreateLabel("Score", 22, Color.WHITE, headerBg);

        List<User> topUsers = UserManager.getTopRankings(currentMode, 5);

        Color[] rowBgColors = {
                new Color(255, 223, 0, 180),
                new Color(192, 192, 192, 180),
                new Color(205, 127, 50, 180),
                new Color(245, 245, 245),
                new Color(235, 235, 235)
        };

        Color[] textColors = {
                new Color(100, 70, 0),
                new Color(60, 60, 60),
                new Color(80, 40, 10),
                Color.BLACK,
                Color.BLACK
        };
        
        for (int i = 0; i < 5; i++) {
            Color rowColor = rowBgColors[i];
            Color textColor = textColors[i];

            if (i < topUsers.size()) {
                User user = topUsers.get(i);
                CreateLabel(String.valueOf(i + 1), 20, textColor, rowColor);
                CreateLabel(user.getUsername(), 20, textColor, rowColor);
                CreateLabel(String.valueOf(user.getScore(currentMode)), 20, textColor, rowColor);
            } else {

                CreateLabel(String.valueOf(i + 1), 20, Color.LIGHT_GRAY, Color.LIGHT_GRAY);
                CreateLabel("-", 20, Color.LIGHT_GRAY, rowColor);
                CreateLabel("-", 20, Color.LIGHT_GRAY, rowColor);
            }
        }
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(6, 3));

    }

    public void Finally() {
        this.setSize(420, 520);
        this.setLocation(100, 150);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
