package lib;

import javax.swing.JLabel;
import javax.swing.Timer;

public class CountdownTimer {
    private Timer timer;
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
        this(seconds, targetLabel, null);
    }

    public CountdownTimer(int seconds, JLabel targetLabel, Runnable onTimeUp) {
        this.initialSeconds = seconds;
        this.seconds = seconds;
        this.targetLabel = targetLabel;
        this.onTimeUp = onTimeUp;
        this.timer = new Timer(1000, e -> {
            if (this.seconds > 0) {
                this.seconds--;
                updateTimeLabel();
            } else {
                stop();
                if (this.onTimeUp != null) {
                    this.onTimeUp.run();
                }
            }
        });
    }

    private void updateTimeLabel() {
        if (targetLabel != null) {
            int m = seconds / 60;
            int s = seconds % 60;
            targetLabel.setText(String.format("%02d:%02d", m, s));
        }
    }

    public void start(int delay, int period) {
        stop();
        this.seconds = initialSeconds;
        updateTimeLabel(); // อัปเดตแสดงผลทันทีตั้งแต่เริ่ม

        // สำหรับ Swing Timer ให้กำหนด Initial Delay ได้
        timer.setInitialDelay(delay);
        timer.start();
    }

    public void stop() {
        if (timer != null && timer.isRunning()) {
            timer.stop(); // <--- หยุดทันทีแบบ Real-time ไม่มีดีเลย์
        }
    }
}