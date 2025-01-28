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
    /*public List<T> ObtenerRegistrosIngredientes(String tableName, RowMapper<T> mapper) throws SQLException {
        List<T> registros = new ArrayList<>();
        String query = "SELECT P.sNIT,P.sNombre,I.sCodigo,I.sDescrip,* FROM " + tableName + " I inner join Proveedor P " +"on I.iProveedor = P.iProveedor";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                registros.add(mapper.mapRow(rs));
            }
        }
        return registros;
    }*/
    
    
    public List<Map<String, Object>> ObtenerRegistrosIngredientes(String tableName, boolean inactivo) throws SQLException {
        List<Map<String, Object>> registros = new ArrayList<>();
 
        // Consulta SQL
        String query = "SELECT I.iIngrediente AS iIngrediente, " +
               "I.sCodigo AS ingredienteCodigo, " +
               "I.sDescrip AS ingredienteDescrip, " +
               "TI.iTipoIngrediente AS tipoId, " +
               "TI.sCodigo AS tipoCodigo, " +
               "TI.sNombre AS tipoNombre, " +
               "M.iMedida AS medidaId, " +
               "M.sCodigo AS medidaCodigo, " +
               "M.sNombre AS medidaNombre, " +
               "P.iProveedor AS proveedorId, " +
               "P.sNIT AS proveedorNit, " +
               "P.sNombre AS proveedorNombre, " +
               "I.yPrecio AS ingredientePrecio, " +
               "I.rRendimiento AS ingredienteRendimiento, " +
               "I.mNota AS ingredienteNota, " +
               "I.bInactivo AS ingredienteInactivo " +
               "FROM " + tableName + " I " +
               "INNER JOIN TipoIngrediente TI ON I.iTipoIngrediente = TI.iTipoIngrediente " +
               "INNER JOIN Medida M ON I.iMedida = M.iMedida " +
               "INNER JOIN Proveedor P ON I.iProveedor = P.iProveedor ";
               
        if(!inactivo){
            query += "WHERE I.bInactivo = 0";
        }
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Obtener la metainformación de las columnas (nombres y número de columnas)
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount(); // Cantidad de columnas

            // Iterar sobre cada fila del ResultSet
            while (rs.next()) {
                // Usar LinkedHashMap para mantener el orden de las columnas
                Map<String, Object> fila = new LinkedHashMap<>();

                // Procesar todas las columnas de la fila actual
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i); // Nombre de la columna
                    Object columnValue = rs.getObject(i);         // Valor de la columna
                    fila.put(columnName, columnValue);            // Insertar en el mapa
                }

                // Agregar la fila al listado de registros
                registros.add(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Volver a lanzar la excepción para que el llamador la maneje
        }

        return registros;
    }
    
    public boolean ActualizarRegistros(String tabla, Map<String, Object> registro, String clavePrimaria) throws SQLException {
            if (registro == null || registro.isEmpty()) {
            System.out.println("No hay registros para actualizar.");
            return false;
        }

        // Construir la consulta SQL dinámicamente
        StringBuilder sql = new StringBuilder("UPDATE ").append(tabla).append(" SET ");
        for (String columna : registro.keySet()) {
            if (!columna.equals(clavePrimaria)) {
                sql.append(columna).append(" = ?, ");
            }
        }

        // Eliminar la coma final y agregar la cláusula WHERE
        sql.deleteCharAt(sql.lastIndexOf(","));
        sql.append(" WHERE ").append(clavePrimaria).append(" = ?");
        
        System.out.println("Consulta generada: " + sql); // Debugging: muestra la consulta generada

        try (PreparedStatement statement = conn.prepareStatement(sql.toString())) {
            // Asignar valores a los parámetros
            int index = 1;
            for (Map.Entry<String, Object> entry : registro.entrySet()) {
                if (!entry.getKey().equals(clavePrimaria)) {
                     System.out.println("Índice " + index + ": Columna " + entry.getKey() + " = " + entry.getValue());
                    statement.setObject(index++, entry.getValue());
                }
            }
            //System.out.println("Índice " + index + ": Clave primaria (" + clavePrimaria + ") = " + registro.get(clavePrimaria));
            // Agregar el valor de la clave primaria
            statement.setObject(index, registro.get(clavePrimaria));

            // Ejecutar la consulta y verificar si se actualizó algún registro
            int filasActualizadas = statement.executeUpdate();
            //System.out.println("Filas actualizadas: " + filasActualizadas); // Debugging
            return filasActualizadas > 0; // Devuelve true si al menos una fila fue actualizada
        } catch (SQLException e) {
            System.err.println("Error actualizando registro: " + e.getMessage());
            throw e;
        }
    }
    
    // Método genérico para actualizar un registro a inactivo por ID
    public boolean MarcarComoInactivo(String tableName, String idColumnName, int id) throws SQLException {
        String query = "UPDATE " + tableName + " SET bInactivo = 1 WHERE " + idColumnName + " = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        }
    }
    
}
