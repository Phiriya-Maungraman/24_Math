import javax.swing.*;
import java.awt.*;
import java.util.List;
import lib.*;

public class RankingForm extends JDialog {
    Container cp;
    // JLabel No, Name, Scr, First, FN, FS, Second, SCN, SCS, Third, THN, THS, Fourth, FON, FOS, Fifth, FIN, FIS;

    public RankingForm(JFrame owner) {
        super(owner, "Ranking", true);
        Initial();
        rankingLeader();
        Finally();
    }

    public JLabel CreateLabel(String text, int fontSize, Color textColor, Color bgColor) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("", Font.BOLD, fontSize));
        label.setForeground(textColor);
        label.setBackground(bgColor);
        label.setOpaque(true); // สำคัญมาก: ต้องเปิด opaque ถึงจะแสดงสีพื้นหลังบน JLabel ได้
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(220, 220, 220))); // เส้นขอบตารางบางๆ สบายตา
        cp.add(label);
        return label;
    }

     public void rankingLeader() {
        //  หัวตาราง
        Color headerBg = new Color(50, 50, 50);
        CreateLabel("NO.", 22, Color.WHITE, headerBg);
        CreateLabel("Name", 22, Color.WHITE, headerBg);
        CreateLabel("Score", 22, Color.WHITE, headerBg);

        List<User> topUsers = UserManager.getTopRankings(5);

        Color[] rowBgColors = {
            new Color(255, 223, 0, 180),   // อันดับ 1: โทนทอง
            new Color(192, 192, 192, 180), // อันดับ 2: โทนเงิน
            new Color(205, 127, 50, 180),  // อันดับ 3: โทนทองแดง
            new Color(245, 245, 245),      // อันดับ 4: สีเทาอ่อนมาก
            new Color(235, 235, 235)       // อันดับ 5: สีเทาอ่อน
        };

        Color[] textColors = {
            new Color(100, 70, 0),    // สีข้อความอันดับ 1
            new Color(60, 60, 60),    // สีข้อความอันดับ 2
            new Color(80, 40, 10),    // สีข้อความอันดับ 3
            Color.BLACK,              // สีข้อความอันดับ 4
            Color.BLACK               // สีข้อความอันดับ 5
        };

        // 3. แสดงข้อมูล 5 อันดับ
        for (int i = 0; i < 5; i++) {
            Color rowColor = rowBgColors[i];
            Color textColor = textColors[i];

            if (i < topUsers.size()) {
                User user = topUsers.get(i);
                CreateLabel(String.valueOf(i + 1), 20, textColor, rowColor);
                CreateLabel(user.getUsername(), 20, textColor, rowColor);
                CreateLabel(String.valueOf(user.getHighScore()), 20, textColor, rowColor);
            } else {
                // กรณีมีผู้เล่นไม่ถึง 5 คน ให้แสดงขีดว่างไว้
                CreateLabel(String.valueOf(i + 1), 20, Color.LIGHT_GRAY, Color.LIGHT_GRAY);
                CreateLabel("-", 20, Color.LIGHT_GRAY, rowColor);
                CreateLabel("-", 20, Color.LIGHT_GRAY, rowColor);
            }
        }
    }


    
    // public JLabel CreateLable( JLabel Label, String text, int fontSize, Color Textcolor) {
    //     Label = new JLabel(text);
    //     Label.setFont(new Font("", Font.PLAIN, fontSize));
    //     Label.setForeground(Textcolor);
    //     Label.setHorizontalAlignment(JLabel.CENTER);
    //     cp.add(Label);
    //     return Label;
    // }
    // public void rankingLeaderG() {
    //     // หัวตาราง
    //     No = CreateLable(No, "NO.", 25, Color.BLACK);
    //     Name = CreateLable(Name, "Name", 25, Color.BLACK);
    //     Scr = CreateLable(Scr, "Score", 25, Color.BLACK);

    //     // อันดับ 1
    //     First = CreateLable(First, "1", 25, new Color(255, 223, 0));
    //     FN = CreateLable(FN, "Matthiew", 25, new Color(255, 223, 0));
    //     FS = CreateLable(FS, "150", 25, new Color(255, 223, 0));

    //     // อันดับ 2
    //     Second = CreateLable(Second, "2", 25, Color.GRAY);
    //     SCN = CreateLable(SCN, "Tae", 25, Color.GRAY);
    //     SCS = CreateLable(SCS, "100", 25, Color.GRAY);

    //     // อันดับ 3
    //     Third = CreateLable(Third, "3", 25, new Color(205, 127, 50));
    //     THN = CreateLable(THN, "Aut", 25, new Color(205, 127, 50));
    //     THS = CreateLable(THS, "50", 25, new Color(205, 127, 50));

    //     // อันดับ 4
    //     Fourth = CreateLable(Fourth, "4", 25, Color.BLACK);
    //     FON = CreateLable(FON, "Graph", 25, Color.BLACK);
    //     CreateLable(null, "25", 25, Color.BLACK);

    //     // อันดับ 5
    //     CreateLable(null, "5", 25, Color.BLACK);
    //     CreateLable(null, "Test", 25, Color.BLACK);
    //     CreateLable(null, "10", 25, Color.BLACK);
    // }
     public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(6, 3));
        //cp.setBackground(new Color(200, 200, 200));
    }

    public void Finally() {
        this.setSize(420, 520);
        this.setLocation(100, 150);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
