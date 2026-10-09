import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import lib.UserManager;

public class LoginForm extends JFrame implements MouseListener {
    Container cp;
    JLabel user, pass;
    JTextField u1;
    JPasswordField p1;
    JButton lg, reg;

    public LoginForm() {
        Initial();
        loginFrame();
        Finally();
    }

    public JLabel CreateLable(JLabel Label, String text, int fontSize, Color Textcolor) {
        Label = new JLabel(text);
        Label.setFont(new Font("", Font.BOLD, fontSize));
        Label.setForeground(Textcolor);
        cp.add(Label);
        return Label;
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);
        cp.setBackground(new Color(39, 76, 67));
    }

    public void loginFrame() {
        user = CreateLable(user, "User :", 20, Color.WHITE);
        user.setBounds(65, 10, 100, 25);
        pass = CreateLable(pass, "Password :", 20, Color.WHITE);
        pass.setBounds(15, 40, 200, 25);
        u1 = new JTextField();
        u1.setBounds(150, 10, 100, 25);
        u1.setSize(200, 25);
        p1 = new JPasswordField();
        p1.setBounds(150, 40, 100, 25);
        p1.setSize(200, 25);

        lg = new JButton("Login");
        lg.setBounds(150, 105, 95, 30);
        lg.addMouseListener(this);

        reg = new JButton("Register");
        reg.setBounds(250, 105, 95, 30);
        reg.addMouseListener(this);

        cp.add(u1);
        cp.add(lg);
        cp.add(reg);
        cp.add(p1);
    }

    /** ฟังก์ชันเปิดหน้าเกมหลัก */
    public void openGamepanel(String currentUsername) {
        MainGui form = new MainGui( currentUsername);
        form.setVisible(true);
    }

    public void Finally() {
        this.setTitle("Login");
        this.setSize(420, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String username = u1.getText().trim();
        String password = new String(p1.getPassword()).trim();

        // 1. กรณีคลิกปุ่ม Login
        if (e.getSource() == lg) {
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "กรุณากรอก Username และ Password ให้ครบถ้วน", "แจ้งเตือน", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // ตรวจสอบข้อมูลกับ UserManager
            if (UserManager.authenticate(username, password)) {
                JOptionPane.showMessageDialog(this, "เข้าสู่ระบบสำเร็จ! ยินดีต้อนรับ " + username, "สำเร็จ", JOptionPane.INFORMATION_MESSAGE);
                openGamepanel(username);
                this.dispose(); // ปิดหน้าต่าง Login
            } else {
                JOptionPane.showMessageDialog(this, "Username หรือ Password ไม่ถูกต้อง", "เข้าสู่ระบบล้มเหลว", JOptionPane.ERROR_MESSAGE);
            }
        }

        // 2. กรณีคลิกปุ่ม Register
        else if (e.getSource() == reg) {
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "กรุณากรอก Username และ Password ที่ต้องการสมัคร", "แจ้งเตือน", JOptionPane.WARNING_MESSAGE);
                return;
            }

            boolean isRegistered = UserManager.register(username, password);
            if (isRegistered) {
                JOptionPane.showMessageDialog(this, "สมัครสมาชิกสำเร็จ! สามารถกด Login เข้าเล่นได้ทันที", "สำเร็จ", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "ชื่อผู้ใช้นี้มีคนใช้แล้ว กรุณาใช้ชื่ออื่น", "เกิดข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

}
