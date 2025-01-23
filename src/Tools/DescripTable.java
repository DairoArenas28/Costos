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
    private List<String> descripTable;

    public DescripTable(String tableName) {
        this.tableName = tableName;
    }
    
    public List<String> Descrip(){
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
