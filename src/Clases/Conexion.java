/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Clases.File;
import Tools.CryptoUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DanielSantiago
 */
public class Conexion {
    
    private String urlFinal;

    private Connection conn;
    
    private String nameFile = "Conection.text"; 
    
    private static final String FILE_NAME = "conexion.txt";
    
    private File file = new File(nameFile);
    
    public Conexion( ){
//        this.url = url_;
//        this.database = database_;
//        this.user = user_;
//        this.password = password_;
//        this.urlFinal = url + "database=" + database + ";encrypt=true;trustServerCertificate=true;loginTimeout=30;";
//        try {
//            this.conn = Connection();
//        } catch (SQLException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public static void GuardarConexion(String user, String password, String server, String db, String logintimeout, Boolean encrypt, Boolean trustcertificate) {
        try {
            String datos = user + ";" + password + ";" + server + ";" + db + ";" + logintimeout + ";" + encrypt + ";" + trustcertificate + ";";
            String datosEncriptados = CryptoUtil.encrypt(datos);

            File file = new File(FILE_NAME);
            file.createFileIfNotExists(); // Crea el archivo si no existe
            file.Writer(datosEncriptados, false); // Sobrescribe el contenido del archivo
        } catch (Exception e) {
            System.err.println("Error al guardar la conexión: " + e.getMessage());
        }
    }
    
    public static String[] RecuperarConexion() {
        try {
            File file = new File(FILE_NAME);
            if (file.Validate()) {
                List<String> lines = file.readFile();
                if (!lines.isEmpty()) {
                    String datosEncriptados = lines.get(0); // Tomamos la primera línea
                    String datos = CryptoUtil.decrypt(datosEncriptados);
                    return datos.split(";"); // Devuelve un array con host, puerto, usuario, contraseña
                }
            } else {
                System.out.println("El archivo no existe.");
            }
        } catch (Exception e) {
            System.err.println("Error al recuperar la conexión: " + e.getMessage());
        }
        return null;
    }
    
    public Connection Connection() throws SQLException {
        String[] datosConexion = RecuperarConexion();
        urlFinal = "jdbc:sqlserver://" + datosConexion[2]  + ";database=" + datosConexion[3] + ";encrypt=true;trustServerCertificate=true;loginTimeout=30;";
        Connection conn = null;
        try {
            //System.out.println(urlFinal);
            conn = DriverManager.getConnection(urlFinal, datosConexion[0], datosConexion[1]);
            if (conn != null) {
                System.out.println("Conexión exitosa.");
            }
        } catch (SQLException e) {
            System.err.println("Error al establecer la conexión: " + e.getMessage());
            throw e;
        }
        return conn;
    }
    
    public void cerrarConexion() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
