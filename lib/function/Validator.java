package lib.function;

public class Validator {

    public static boolean isAlphaNume(String str) {

        if (str == null || str.isEmpty())
            return false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidUserName(String name) {
        
        boolean hasLetter = false;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (Character.isLetter(c))
                hasLetter = true;
        }
        return hasLetter;
    }

    public static boolean isValidPassword(String password) {

        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isWhitespace(c)) {
                hasSpecial = true;
            }
        }

        // ต้องมีครบทั้ง 3 ประเภท
        return hasLetter && hasDigit && hasSpecial;
    }

    public static boolean isPasswordMatch(String p1, String p2) {
        if (p1 == null || p2 == null)
            return false;
        if (p1.length() != p2.length())
            return false;

        for (int i = 0; i < p1.length(); i++) {
            if (p1.charAt(i) != p2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}