package com.engeto.caesar;

public class Encoder implements InterfaceEncoder{

    @Override
    public String code(String text, int shift) {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        int newShift = shift % abc.length();
        StringBuilder encodedText = new StringBuilder();
        char encodedLetter;

        for (char letter : text.toUpperCase().toCharArray()) { //převod vstupního textu na pole znaků
            int j = abc.indexOf(letter); //nalezení indexu písmene
            if (j + newShift >= abc.length()) {
                encodedLetter = abc.charAt((newShift + j) % abc.length());
            } else if (j + newShift < 0) {
                encodedLetter = abc.charAt(newShift + j + abc.length());
            } else {
                encodedLetter = abc.charAt(j + newShift);
            }
            encodedText.append(encodedLetter);
        }
        return encodedText.toString();
    }
}
