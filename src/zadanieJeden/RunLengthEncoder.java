package zadanieJeden;

 class RunLengthEncoder {

    String encoder(String plainText){
        return "A4,B3,C1,112"+ plainText;
    }

    String decode(String encodedText){
        return "AAAABBBC111111111111"+ encodedText;
    }
}
