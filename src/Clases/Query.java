/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.swing.tree.RowMapper;

/**
 *
 * @author DanielSantiago
 */
public class Query<T> extends Conexion {
    
    private Connection conn;

    public Query() {
        try {
            conn = Connection(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public interface RowMapper<T> {
        T mapRow(ResultSet rs) throws SQLException;
    }
    
    public List<T> ObtenerRegistros(String tableName, RowMapper<T> mapper) throws SQLException {
        List<T> registros = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                registros.add(mapper.mapRow(rs));
            }
        }
        return registros;
    }
    
    public boolean InsertarRegistro(String tableName, Map<String, Object> columnValues) throws SQLException {
        // Generar los nombres de las columnas y los placeholders para los valores
        String columns = String.join(", ", columnValues.keySet());
        String placeholders = String.join(", ", Collections.nCopies(columnValues.size(), "?"));

        // Crear la consulta dinámica
        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + placeholders + ")";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            int index = 1;
            for (Object value : columnValues.values()) {
                pstmt.setObject(index++, value);
            }
            return pstmt.executeUpdate() > 0;
        }
    }
}
