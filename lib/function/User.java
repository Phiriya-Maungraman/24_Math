package lib.function;
public class User {
    private String username;
    private String password;
    private int highScore;
    private int scoreFive;
    private int scoreSS;
    private int scoreRush;

    public User(String username, String password, int highScore,int scoreFive,int scoreSS,int scoreRush) {
        this.username = username;
        this.password = password;
        this.highScore = highScore;
        this.scoreFive = scoreFive;
        this.scoreSS = scoreSS;
        this.scoreRush = scoreRush;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getScore(String mode) {
        switch(mode){
            case "Four" : return highScore;
            case "Five" : return scoreFive;
            case "SS" : return scoreSS;
            case "Rush" : return scoreRush;
            default : return 0;
        }
    }

    public void setHighScore(String mode ,int highScore) {
        switch (mode) {
            case "Four": this.highScore = highScore; break;
            case "Five": this.scoreFive = highScore; break;
            case "SS": this.scoreSS = highScore; break;
            case "Rush": this.scoreRush = highScore; break;                            
        }
    }

    // แปลงข้อมูลเป็นรูปแบบ CSV บรรทัดเดียว
    public String toCsvRow() {
        return username + "," + password + "," + highScore + "," + scoreFive + "," + scoreSS + "," + scoreRush;
    }
}