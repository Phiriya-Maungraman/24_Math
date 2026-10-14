package lib.function;
import javax.swing.*;

public class ScoreManager {

    public static boolean checkScore(String result, JLabel score, String currentMode) {
        try {
            double value = Double.parseDouble(result);
            int currentScore = Integer.parseInt(score.getText().trim()); 
            // เช็คว่าผลลัพธ์เท่ากับ 24 หรือไม่ (รองรับทั้งทศนิยมและจำนวนเต็ม)
            if(currentMode.equals("Four") || currentMode.equals("Five") || currentMode.equals("Rush") ){
                if (value == 24.0){
                score.setText(String.valueOf(currentScore + 3));
                return true;

            }else if(value == 23.0 || value == 25.0){
                score.setText(String.valueOf(currentScore + 2));

            }else if(value == 22.0 || value == 21.0 || value == 20.0 || value == 26.0 || value == 27.0 || value == 28.0){
                score.setText(String.valueOf(currentScore + 1));
            }else{
                 score.setText(String.valueOf(currentScore + 0));
                }
            }

            if(currentMode.equals("SS")){
                if (value == 67.0){
                score.setText(String.valueOf(currentScore + 3));
                return true;

            }else if(value == 66.0 || value == 68.0){
                score.setText(String.valueOf(currentScore + 2));

            }else if(value == 65.0 || value == 60.0 || value == 59.0 || value == 69.0 || value == 70.0 || value == 71.0){
                score.setText(String.valueOf(currentScore + 1));
            }else{
                 score.setText(String.valueOf(currentScore + 0));
                }
            }
            
        } catch (NumberFormatException e) { }
        return false;
    }
    
}
