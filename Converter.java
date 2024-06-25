public class Converter {

    // Convert ASCII value to binary string
    public String toBinary(int asciiValue) {
        StringBuilder binary = new StringBuilder();
        while (asciiValue > 0) {
            binary.insert(0, asciiValue % 2);
            asciiValue = asciiValue / 2;
        }
        return binary.toString();
    }

    // Convert ASCII value to octal string
    public String toOctal(int asciiValue) {
        StringBuilder octal = new StringBuilder();
        while (asciiValue > 0) {
            octal.insert(0, asciiValue % 8);
            asciiValue = asciiValue / 8;
        }
        return octal.toString();
    }

    // Convert ASCII value to hexadecimal string
    public String toHexadecimal(int asciiValue) {
        StringBuilder hex = new StringBuilder();
        char[] hexChars = "0123456789ABCDEF".toCharArray();
        while (asciiValue > 0) {
            hex.insert(0, hexChars[asciiValue % 16]);
            asciiValue = asciiValue / 16;
        }
        return hex.toString();
    }

    // Convert ASCII value to decimal string
    public String toDecimal(int asciiValue) {
        return Integer.toString(asciiValue);
    }

    // Convert string to the desired base
    public String convertString(String input, String base) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            int asciiValue = (int) c;
            switch (base) {
                case "hexadecimal":
                case "-h":
                    result.append(toHexadecimal(asciiValue)).append(" ");
                    break;
                case "octal":
                case "-o":
                    result.append(toOctal(asciiValue)).append(" ");
                    break;
                case "decimal":
                case "-d":
                    result.append(toDecimal(asciiValue)).append(" ");
                    break;
                case "binary":
                case "-b":
                    result.append(toBinary(asciiValue)).append(" ");
                    break;
                case "text":
                case "-t":
                    result.append(c).append(" ");
                    break;
            }
        }
        return result.toString().trim();
    }

    // Additional methods for reverse conversion from base to ASCII values
    // Conversion from binary string to ASCII
    public int fromBinary(String binary) {
        int asciiValue = 0;
        for (int i = 0; i < binary.length(); i++) {
            asciiValue = asciiValue * 2 + (binary.charAt(i) - '0');
        }
        return asciiValue;
    }

    // Conversion from octal string to ASCII
    public int fromOctal(String octal) {
        int asciiValue = 0;
        for (int i = 0; i < octal.length(); i++) {
            asciiValue = asciiValue * 8 + (octal.charAt(i) - '0');
        }
        return asciiValue;
    }

    // Conversion from hexadecimal string to ASCII
    public int fromHexadecimal(String hex) {
        int asciiValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            int hexValue;
            if (hexChar >= '0' && hexChar <= '9') {
                hexValue = hexChar - '0';
            } else {
                hexValue = hexChar - 'A' + 10;
            }
            asciiValue = asciiValue * 16 + hexValue;
        }
        return asciiValue;
    }

    // Convert base string back to original text
    public String convertBack(String input, String base) {
        String[] tokens = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String token : tokens) {
            int asciiValue = 0;
            switch (base) {
                case "hexadecimal":
                case "-h":
                    asciiValue = fromHexadecimal(token);
                    break;
                case "octal":
                case "-o":
                    asciiValue = fromOctal(token);
                    break;
                case "decimal":
                case "-d":
                    asciiValue = Integer.parseInt(token);
                    break;
                case "binary":
                case "-b":
                    asciiValue = fromBinary(token);
                    break;
                case "text":
                case "-t":
                    result.append(token);
                    continue;
            }
            result.append((char) asciiValue);
        }
        return result.toString();
    }
}
