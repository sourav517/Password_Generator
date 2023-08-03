import java.util.Random;
import java.util.Scanner;

public class generator {
    static String generate_password(int size, boolean upper, boolean lower, boolean number, boolean special) {
        String upper_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower_chars = "abcdefghijklmnopqrstuvwxyz";
        String number_chars = "1234567890";
        String special_chars = "!@#$%^&*()_+-/.,<>?;':\"[]{}\\|`~";

        String chars = "";
        if (upper) {
            chars += upper_chars;
        }
        if (lower) {
            chars += lower_chars;
        }
        if (number) {
            chars += number_chars;
        }
        if (special) {
            chars += special_chars;
        }
        String password = "";
        // include at least one of each type
        int count = 0;
        Random rnd = new Random();
        if (upper) {
            password += upper_chars.charAt(rnd.nextInt(upper_chars.length()));
            count++;
        }
        if (lower) {
            password += lower_chars.charAt(rnd.nextInt(lower_chars.length()));
            count++;
        }
        if (number) {
            password += number_chars.charAt(rnd.nextInt(number_chars.length()));
            count++;
        }
        if (special) {
            password += special_chars.charAt(rnd.nextInt(special_chars.length()));
            count++;
        }
        while (password.length() < size - count) {
            int index = rnd.nextInt(chars.length());
            password += chars.charAt(index);
        }
        // shuffle the password
        String shuffled = "";
        while (password.length() > 0) {
            int index = rnd.nextInt(password.length());
            shuffled += password.charAt(index);
            password = password.substring(0, index) + password.substring(index + 1);
        }
        return shuffled;
    }
    static String password_strength(String password) {
        int strength = 0;
        if (password.length() >= 8) {
            strength += 1;
        }
        if (password.matches(".*[A-Z].*")) {
            strength += 1;
        }
        if (password.matches(".*[a-z].*")) {
            strength += 1;
        }
        if (password.matches(".*[0-9].*")) {
            strength += 1;
        }
        if (password.matches(".*[!@#$%^&*()_+-/.,<>?;':\"{}\\|`~].*")) {
            strength += 1;
        }
        if (strength == 1) {
            return "Very Weak";
        } else if (strength == 2) {
            return "Weak";
        } else if (strength == 3) {
            return "Medium";
        } else if (strength == 4) {
            return "Strong";
        } else if (strength == 5) {
            return "Very Strong";
        }
        return "Very Weak";
    }

    // function to generate password
    static String generate_password(int size) {
        // collection of characters that can be used in password
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+-/.,<>?;':\"[]{}\\|`~";

        String password = "";
        // creating object of Random class
        Random rnd = new Random();
        // looping to generate password
        while (password.length() < size) {
            // get a random number between 0 and length of chars
            int index = (int) (rnd.nextFloat() * chars.length());
            // add character at index to password
            password += chars.charAt(index);
        }
        return password;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of password: ");
        int size = sc.nextInt();
        sc.close();

        // calling function to generate password
        String password = generate_password(size);
        // printing the password
        System.out.println(password);
        System.out.println("Password Strength: " + password_strength(password));
        System.out.println("Some suggested Strong Passwords");
        System.out.println("Password 1: " + generate_password(8, true, true, true, true));
        System.out.println("Password 2: " + generate_password(14, true, false, true, false));
        System.out.println("Password 3: " + generate_password(20, false, true, false, true));


    }
}




