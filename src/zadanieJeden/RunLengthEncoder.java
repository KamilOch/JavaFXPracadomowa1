package zadanieJeden;


import java.util.ArrayList;
import java.util.List;

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
        return encoderOutput /*+ "," */;
    }

    String decode(String encodedText) {

        String encodedTextPlusComma = encodedText + ",";
        char[] arrayChar = encodedTextPlusComma.toCharArray();
        String decoderOutput = "";

        List<String> singleEncodedString = new ArrayList<>();

        String singleInput = "";

        for (int i = 1; i < arrayChar.length; i++) {

            singleInput += Character.toString(arrayChar[i - 1]);

            if (Character.toString(arrayChar[i]).equals(",")) {
                singleEncodedString.add(singleInput);
                singleInput = "";
                i++;
            }

        }

        for (String it : singleEncodedString) {

            char encodedChar = it.charAt(0);
            int numberOfEncodedChar = Integer.parseInt(it.substring(1));

            for (int i = 0; i < numberOfEncodedChar; i++) {
                decoderOutput += encodedChar;
            }
        }
        return decoderOutput;
    }

}
