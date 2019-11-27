package zadanieJeden;

class RunLengthEncoder {

    String encoder(String plainText) {
        char[] input = plainText.toCharArray();

        String output = Character.toString(input[0]);
        int numberSameChars = 1;

        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[(i - 1)]) {
                numberSameChars++;
            } else {
                output = output + numberSameChars+",";
                numberSameChars=1;
                char x = input[i];
                output = output + x;
            }
        }  output = output + numberSameChars;
        return output;
    }

    String decode(String encodedText) {
        return "AAAABBB111111111111" + encodedText;
    }
}
