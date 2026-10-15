package lib;

import lib.function.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class TimeUpForm extends JDialog implements MouseListener {
    Container cp;
    JButton scr, high, again, mode, ch;
    JLabel tm, nm, pl;
    JFrame owner;
    String currentMode, username;
    boolean play;
    int highScoreValue = 0;

    public TimeUpForm(JFrame owner, String currentMode, String currentUser, int score) {
        super(owner, "Time's Up", true);
        this.owner = owner;
        this.currentMode = currentMode;
        this.username = currentUser;

        for (User u : UserManager.getTopRankings(currentMode, 100)) {
            if (u.getUsername().equalsIgnoreCase(currentUser)) {
                highScoreValue = u.getScore(currentMode); 
                break;
            }
        }

        Initial();
        timeupMenu();

        scr.setText(String.valueOf(score));
        high.setText(String.valueOf(highScoreValue));

        Finally();
    }

    public JButton CreateButtonIcon(JButton button, String text, ImageIcon Icon, int fontSize, Color lnColor,
            Color bgColor) {
        button = new JButton(text, Icon);
        button.setFont(new Font("", Font.BOLD, fontSize));
        button.setBackground(new Color(60, 74, 106));
        button.setBorder(new LineBorder(lnColor, 2));
        button.setForeground(bgColor);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFocusable(false);
        cp.add(button);
        return button;
    }

    public JButton CreateButtonIcon2(JButton button, String text, ImageIcon Icon, int fontSize, Color lnColor,
            Color bgColor) {
        button = new JButton(text, Icon);
        button.setFont(new Font("", Font.BOLD, fontSize));
        button.setBackground(new Color(30, 42, 68));
        button.setBorder(new LineBorder(lnColor, 2));
        button.setForeground(bgColor);
        button.setFocusable(false);
        cp.add(button);
        return button;
    }

    public JButton CreateButton(JButton button, String text, int fontSize) {
        button = new JButton(text);
        button.setFont(new Font("", Font.BOLD, fontSize));
        button.setBackground(new Color(255, 138, 61));
        button.setBorder(new LineBorder(new Color(30, 42, 68), 1));
        button.setForeground(new Color(30, 42, 68));
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFocusable(false);
        cp.add(button);
        return button;
    }

    public JLabel CreateJLable(JLabel lable, String text, int fontSize, Color bgColor) {
        lable = new JLabel(text);
        lable.setFont(new Font("", Font.BOLD, fontSize));
        lable.setForeground(bgColor);
        cp.add(lable);
        return lable;
    }

    public void timeupMenu() {
        scr = CreateButtonIcon(scr, "", new ImageIcon("./Icon/Scoreic.png"), 50, new Color(77, 92, 128),
                Color.WHITE);
        scr.setBounds(25, 150, 200, 100);
        scr.addMouseListener(this);

        high = CreateButtonIcon(high, "", new ImageIcon("./Icon/Highic.png"), 50, new Color(77, 92, 128),
                Color.WHITE);
        high.setBounds(250, 150, 200, 100);
        high.addMouseListener(this);

        tm = CreateJLable(tm, "TIME'S UP", 50, Color.WHITE);
        tm.setBounds(100, 0, 400, 100);

        mode = CreateButton(mode, currentMode, 15);
        mode.setBounds(75, 100, 150, 25);

        pl = CreateJLable(pl, "Player : ", 20, new Color(61, 220, 151));
        pl.setBounds(250, 100, 300, 25);

        nm = CreateJLable(nm, username, 17, Color.WHITE);
        nm.setBounds(330, 100, 300, 25);

        again = CreateButton(again, "Play Again", 30);
        again.setBounds(25, 300, 225, 50);
        again.addMouseListener(this);

        ch = CreateButtonIcon2(ch, "Change Mode", new ImageIcon("./Icon/Changeic.png"), 18, new Color(60, 74, 106),
                Color.WHITE);
        ch.setBounds(275, 300, 175, 50);
        ch.addMouseListener(this);

    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setBackground(new Color(30, 42, 68));
        cp.setLayout(null);
    }

    public void Finally() {
        this.setSize(490, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    private void openSetting() {
        SettingForm form = new SettingForm(owner, currentMode, username);
        form.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == again) {
            play = true;
            dispose();
        }
        if (e.getSource() == ch) {
            openSetting();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
