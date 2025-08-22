import java.util.*;

public class i7a2_implement_a_min {
    public static void main(String[] args) {
        Map<String, String> securityRules = new HashMap<>();
        securityRules.put("passwordLength", "8");
        securityRules.put("uppercaseRequired", "true");
        securityRules.put("numbersRequired", "true");
        securityRules.put("specialCharactersRequired", "true");

        System.out.println("Enter a password to analyze:");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        analyzePassword(securityRules, password);
    }

    public static void analyzePassword(Map<String, String> securityRules, String password) {
        int length = Integer.parseInt(securityRules.get("passwordLength"));
        boolean hasUppercase = securityRules.get("uppercaseRequired").equals("true");
        boolean hasNumbers = securityRules.get("numbersRequired").equals("true");
        boolean hasSpecialChars = securityRules.get("specialCharactersRequired").equals("true");

        boolean passwordIsValid = true;

        if (password.length() < length) {
            System.out.println("Password is too short. It should be at least " + length + " characters.");
            passwordIsValid = false;
        }

        if (hasUppercase && !hasUppercaseLetter(password)) {
            System.out.println("Password should have at least one uppercase letter.");
            passwordIsValid = false;
        }

        if (hasNumbers && !hasNumber(password)) {
            System.out.println("Password should have at least one number.");
            passwordIsValid = false;
        }

        if (hasSpecialChars && !hasSpecialChar(password)) {
            System.out.println("Password should have at least one special character.");
            passwordIsValid = false;
        }

        if (passwordIsValid) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid. Please try again.");
        }
    }

    public static boolean hasUppercaseLetter(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasNumber(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSpecialChar(String password) {
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }
}