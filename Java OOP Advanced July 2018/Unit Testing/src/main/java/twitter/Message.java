package twitter;

import java.util.Random;

public class Message implements Tweet {
    private static final int UPPERCASE_A_SYMBOL_VALUE = 97;
    private static final int RANDOM_STRING_LENGTH = 200;
    private static final int UPPER_SYMBOL_BOUND = 122;
    private static final int WHITESPACE_SYMBOL_VALUE = 32;
    private static final int LOWERCASE_A_SYMBOL_VALUE = 65;
    private static final int LOWERCASE_Z_SYMBOL_VALUE = 90;

    public String retrieveMessage() {

        Random random = new Random();
        StringBuilder output = new StringBuilder();
        int strLength = random.nextInt(RANDOM_STRING_LENGTH);
        for (int i = 0; i < strLength; i++) {
            int symbol = random.nextInt(UPPER_SYMBOL_BOUND);
            if(symbol == WHITESPACE_SYMBOL_VALUE ||(symbol> LOWERCASE_A_SYMBOL_VALUE && symbol< LOWERCASE_Z_SYMBOL_VALUE)
                    || symbol>UPPERCASE_A_SYMBOL_VALUE){
                output.append(Character.toChars(symbol));
            }
        }
        return output.toString();
    }
}
