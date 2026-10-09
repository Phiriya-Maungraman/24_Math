import javax.swing.*;
import java.awt.*;

public class RankingForm extends JDialog{
    Container cp;
    JLabel No, Name, Scr, First, FN, FS, Second, SCN, SCS, Third, THN, THS, Fourth, FON, FOS, Fifth, FIN, FIS;
    public RankingForm(JFrame owner){
        super(owner,"Ranking",true);
        Initial();
        rankingLeader();
        Finally();
    }

     public JLabel CreateLable(JLabel Label, String text, int fontSize, Color Textcolor) {
        Label = new JLabel(text);
        Label.setFont(new Font("", Font.PLAIN, fontSize));
        Label.setForeground(Textcolor);
        Label.setHorizontalAlignment(JLabel.CENTER);
        cp.add(Label);
        return Label;
    }

    public void rankingLeader(){
    //หัวตาราง
    No = CreateLable(No,"NO.",25,Color.BLACK);
    Name = CreateLable(Name, "Name", 25,Color.BLACK);
    Scr = CreateLable(Scr, "Score", 25,Color.BLACK);

    //อันดับ 1
    First = CreateLable(First, "1", 25,new Color(255,223,0));
    FN = CreateLable(FN, "Matthiew", 25,new Color(255,223,0));
    FS = CreateLable(FS, "150", 25,new Color(255,223,0));

    //อันดับ 2
    Second = CreateLable(Second, "2", 25,Color.GRAY);
    SCN = CreateLable(SCN, "Tae", 25,Color.GRAY);
    SCS = CreateLable(SCS, "100", 25,Color.GRAY);

    //อันดับ 3
    Third = CreateLable(Third, "3", 25,new Color(205,127,50));
    THN = CreateLable(THN, "Aut", 25,new Color(205,127,50));
    THS = CreateLable(THS, "50", 25,new Color(205,127,50));

    //อันดับ 4
    Fourth = CreateLable(Fourth, "4", 25,Color.BLACK);
    FON = CreateLable(FON, "Graph", 25,Color.BLACK);
    CreateLable(null, "25", 25,Color.BLACK);

    //อันดับ 5
    CreateLable(null, "5", 25,Color.BLACK);
    CreateLable(null, "Test", 25,Color.BLACK);
    CreateLable(null, "10", 25,Color.BLACK);
    }
    public void Initial() {
    cp = this.getContentPane();
    cp.setLayout(new GridLayout(6,3)); 
}
    
    public void Finally() {
        this.setSize(400, 550);
        this.setLocation(100,150);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
