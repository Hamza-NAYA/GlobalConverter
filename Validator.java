public class Validator {
    public boolean isValidString(String input) {
        // Verify if input is a valid string including nummbers and spaces
        return input.matches("[a-zA-Z0-9 ]+");
    }

    public boolean isValidBase(String base) {
        switch (base) {
            case "hexadecimal":
            case "octal":
            case "decimal":
            case "binary":
            case "text":
            case "-h":
            case "-o":
            case "-d":
            case "-b":
            case "-t":
                return true;
            default:
                return false;
        }
    }
}