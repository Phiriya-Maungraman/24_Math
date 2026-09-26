import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
    private Timer timer = new Timer();
    private int initialSeconds;
    private int seconds;
    private JLabel targetLabel;
    private Runnable onTimeUp; // ตัวแปรเก็บชุดคำสั่งที่จะทำเมื่อหมดเวลา

    public CountdownTimer() {
        this.initialSeconds = 0;
        this.seconds = 0;
        this.targetLabel = null;
        this.onTimeUp = null;
    }
    public CountdownTimer(int seconds, JLabel targetLabel) {
        this.initialSeconds = seconds;
        this.seconds = seconds;
        this.targetLabel = targetLabel;
    }

    // รับค่าจำนวนวินาที และ JLabel ที่ต้องการให้แสดงผล
    public CountdownTimer(int seconds, JLabel targetLabel, Runnable onTimeUp) {
        this.initialSeconds = seconds;
        this.seconds = seconds;
        this.targetLabel = targetLabel;
        this.onTimeUp = onTimeUp;
    }

    public void start(int delay, int period) {
        stop();

        // สร้าง Timer ใหม่ และรีเซตเวลาให้กลับมาเท่ากับค่าเริ่มต้น
        timer = new Timer();
        this.seconds = initialSeconds;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (seconds >= 0) {
                    // แปลงวินาทีเป็น นาที:วินาที (เช่น 00:30)
                    int m = seconds / 60;
                    int s = seconds % 60;
                    String timeFormatted = String.format("%02d:%02d", m, s);

                    // ทำงานผ่านจุดนี้เพื่อเช็คค่าที่รับมามีค่าไหม
                    SwingUtilities.invokeLater(() -> {
                        if (targetLabel != null) {
                            targetLabel.setText(timeFormatted);
                        }
                    });
                    seconds--;
                } else {
                    stop();
                    
                    // เมื่อหมดเวลา (seconds < 0) ให้ทำงานคำสั่งที่ส่งมา (ถ้ามี)
                    if (onTimeUp != null) {
                        SwingUtilities.invokeLater(onTimeUp);
                    }
                }
            }
        }, delay, period);

    }

    public void stop() {
        if (timer != null) {
            timer.cancel();
        }
    }
}
