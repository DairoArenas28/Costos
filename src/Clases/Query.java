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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.tree.RowMapper;
import java.sql.ResultSetMetaData;
import java.util.LinkedHashMap;

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
    
   public List<Map<String, Object>> obtenerRegistrosComoMap(String tableName, List<String> itemSearch) throws SQLException {
        List<Map<String, Object>> registros = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;

        if(!itemSearch.isEmpty() && !"".equals(itemSearch.get(0)) && !"".equals(itemSearch.get(1))){
            query += " WHERE " + itemSearch.get(0) + " = '" + itemSearch.get(1) + "'";
        }
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Obtener los nombres de las columnas
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Procesar cada fila del ResultSet
            while (rs.next()) {
                // Usar LinkedHashMap para mantener el orden de las columnas
                Map<String, Object> fila = new LinkedHashMap<>();

                // Asignar los valores de cada columna al mapa respetando el orden de las columnas
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i); // Nombre de la columna
                    Object columnValue = rs.getObject(i); // Valor de la columna
                    fila.put(columnName, columnValue); // Insertamos la columna en el mapa
                }

                // Agregar la fila a la lista de registros
                registros.add(fila);
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
   
   
   //Ingrediente
    public List<T> ObtenerRegistrosIngredientes(String tableName, RowMapper<T> mapper) throws SQLException {
        List<T> registros = new ArrayList<>();
        String query = "SELECT P.sNIT,P.sNombre,I.sCodigo,I.sDescrip,* FROM " + tableName + " I inner join Proveedor P " +"on I.iProveedor = P.iProveedor";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                registros.add(mapper.mapRow(rs));
            }
        }
        return registros;
    }
    
    public List<Map<String, Object>> obtenerRegistrosIngredientes(String tableName) throws SQLException {
        List<Map<String, Object>> registros = new ArrayList<>();
        String query = "SELECT P.sNIT, P.sNombre, I.sCodigo, I.sDescrip " +
                       "FROM " + tableName + " I " +
                       "INNER JOIN Proveedor P ON I.iProveedor = P.iProveedor";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Obtener los metadatos para saber cuántas columnas tiene el resultado
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                // Iterar sobre las columnas y llenar el mapa
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object value = rs.getObject(i);
                    row.put(columnName, value);
                }
                registros.add(row);
            }
        }
        return registros;
    }
}
