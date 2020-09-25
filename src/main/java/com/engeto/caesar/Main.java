package com.engeto.caesar;

public class Main {

    public static void main(String[] args) {

        //načtení a kontrola vstupních parametrů
        if (args.length < 3) {
            System.err.println("Bylo zadano malo parametru, potrebuji 3 parametry: input_file output_file posun");
            System.exit(1);
        }

        String inputFile = args[0];
        String outputFile = args[1];

        int shift = 0;
        try {
            shift = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Treti parametr 'posun' musi byt cislo");
            System.exit(1);
        }

        // načtení souboru
        FileRepository fileRepository = new FileRepository();
        String plaintext = fileRepository.loadFile(inputFile);

        //zpracování
        //Encoder encoder = new Encoder(); //obyčejně
        StreamEncoder encoder = new StreamEncoder(); // využití streamu
        String coded = encoder.code(plaintext, shift); //zašifrování

        //zapsání zašifrovaného textu do souboru
        fileRepository.writeToFile(outputFile, coded);

    }

}
