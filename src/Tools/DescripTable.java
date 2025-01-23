/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import java.util.List;

/**
 *
 * @author Dairo Arenas
 */
public class DescripTable {
    private String tableName;

    List<String> descripTable;
    
    public DescripTable() {
    }
    
    public List<String> Descrip(String tableName){
        
        switch(tableName){
            case "TipoIngrediente":
            descripTable.add("Nombre");
            descripTable.add("Descripción");
            descripTable.add("Inactivo");
            
            
            default:
            descripTable.add("False");
        }
        return descripTable;
    }
}
