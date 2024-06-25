public class GlobalConverter {
    public static void main(String[] args) {
        Validator validator = new Validator();
        Converter converter = new Converter();

        String inputBase = null;
        String outputBase = null;
        String inputString = null;
        int shiftKey = 0;

        // Parse command-line arguments
        if (args.length < 3) {
            System.out.println("Utilisation de la commande : java GlobalConverter <inputBase> <outputBase> <inputString> [-k <shiftKey>]");
            return;
        }

        inputBase = args[0];
        outputBase = args[1];
        inputString = args[2];

        // Find shiftKey for the encryption
        for (int i = 3; i < args.length - 1; i++) {
            if (args[i].equals("-k")) {
                try {
                    shiftKey = Integer.parseInt(args[i + 1]);
                } catch (NumberFormatException e) {
                    System.out.println("Clé de chiffrement invalide, la conversion va se réaliser sans encryptage");
                }
            }
        }

        // Validate bases and inputString
        if (!validator.isValidBase(inputBase) || !validator.isValidBase(outputBase)) {
            System.out.println("Option invalide, veuillez saisir une option parmi les choix disponibles : -h, -o, -d, -b, -t");
            return;
        }

        if (inputString == null || !validator.isValidString(inputString)) {
            System.out.println("Chaîne de caractère invalide, veuillez fournir une chaîne valide");
            return;
        }

        // Encrypt if shiftKey is provided (encryption logic can be added here if needed)
        if (shiftKey != 0) {
            // Code for encrypting the inputString (optional)
        }

        // Convert the input string to text (ASCII values) using the input base
        String text = converter.convertBack(inputString, inputBase);

        // Convert the text to the desired output base
        String result = converter.convertString(text, outputBase);
        System.out.println(result);
    }
}
