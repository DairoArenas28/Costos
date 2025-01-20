package Clases;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class File {
    private String nameFile;

    public File(String nameFile) {
        this.nameFile = nameFile;
    }

    // Setters y Getters
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getNameFile() {
        return nameFile;
    }

    // Validar existencia del archivo
    public Boolean Validate() {
        java.io.File file = new java.io.File(nameFile);
        return file.exists();
    }

    // Crear archivo si no existe
    public void createFileIfNotExists() {
        java.io.File file = new java.io.File(nameFile);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Archivo creado: " + nameFile);
                }
            } catch (IOException e) {
                System.err.println("Error al crear el archivo: " + e.getMessage());
            }
        }
    }

    // Escribir contenido en el archivo
    public void Writer(String contentFile, boolean append) {
        try (FileWriter writer = new FileWriter(nameFile, append)) {
            writer.write(contentFile + System.lineSeparator());
            System.out.println("Contenido escrito correctamente en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Leer contenido del archivo
    public List<String> readFile() {
        try {
            return Files.readAllLines(Paths.get(nameFile));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;
    }

    // Escritura rápida
    public static void quickWrite(String nameFile, String contentFile) {
        try (FileWriter writer = new FileWriter(nameFile, true)) {
            writer.write(contentFile + System.lineSeparator());
            System.out.println("Contenido escrito correctamente en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
