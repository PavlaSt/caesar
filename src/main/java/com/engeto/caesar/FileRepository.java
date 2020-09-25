package com.engeto.caesar;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileRepository {

    public String loadFile(String inputFile) {
        String plaintext = "";
        try {
            plaintext = new String(Files.readAllBytes(Paths.get(inputFile)));
        } catch (
                IOException e) {
            System.out.printf("Chyba cteni vstupniho souboru: %s", e.getMessage());
            System.exit(1);
        }
        return plaintext;
    }

    public void writeToFile(String outputFile, String coded) {
        File file = new File(outputFile);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println(coded);

        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }
}
