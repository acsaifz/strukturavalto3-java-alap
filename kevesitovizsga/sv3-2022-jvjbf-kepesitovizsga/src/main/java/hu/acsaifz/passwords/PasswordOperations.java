package hu.acsaifz.passwords;

public class PasswordOperations {
    public PasswordStrength checkPasswordStrength(String password){
        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasUpperCaseLetter = false;
        for (char actualCharacter: password.toCharArray()){
            if (Character.isLetter(actualCharacter)){
                hasLetter = true;
            }

            if (Character.isDigit(actualCharacter)){
                hasDigit = true;
            }

            if (Character.isUpperCase(actualCharacter)){
                hasUpperCaseLetter = true;
            }
        }

        if (hasLetter && hasDigit && hasUpperCaseLetter){
            return PasswordStrength.STRONG;
        } else if (hasLetter && hasDigit && !hasUpperCaseLetter){
            return PasswordStrength.MEDIUM;
        } else {
            return PasswordStrength.WEEK;
        }
    }
}
