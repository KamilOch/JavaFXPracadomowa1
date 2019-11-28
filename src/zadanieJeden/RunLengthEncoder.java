package zadanieJeden;

class RunLengthEncoder {

    String encoder(String plainText) {
        char[] encoderInput = plainText.toCharArray();

        String encoderOutput = Character.toString(encoderInput[0]);
        int numberSameChars = 1;

        for (int i = 1; i < encoderInput.length; i++) {
            if (encoderInput[i] == encoderInput[(i - 1)]) {
                numberSameChars++;
            } else {
                encoderOutput = encoderOutput + numberSameChars + ",";
                numberSameChars = 1;
                char x = encoderInput[i];
                encoderOutput = encoderOutput + x;
            }
        }
        encoderOutput = encoderOutput + numberSameChars;
        return encoderOutput;
    }

    String decode(String encodedText) {

        String[] decoderInput = encodedText.split(",");
        String decoderOutput = "";

        for (String it : decoderInput) {
            char encodedChar = it.charAt(0);
            int numberOfEncodedChar = Integer.parseInt(it.substring(1));

            for (int i = 0; i < numberOfEncodedChar; i++) {
                decoderOutput += encodedChar;
            }
        }
        return decoderOutput;
    }

}
