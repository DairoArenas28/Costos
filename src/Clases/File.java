package Clases;

import java.io.FileWriter;
import java.io.IOException;

public class File {

    private String nameFile;
    private String contentFile;

    public File(String nameFile, String contentFile) {
        this.nameFile = nameFile;
        this.contentFile = contentFile;
    }

    public void Writer() {
        try (FileWriter writer = new FileWriter(nameFile, true)) { // Modo 'append' activado con true
            writer.write(contentFile + System.lineSeparator());
            System.out.println("Contenido escrito correctamente en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
