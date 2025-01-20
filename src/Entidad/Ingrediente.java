/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import Clases.Query.RowMapper;

/**
 *
 * @author DanielSantiago
 */
public class Ingrediente {
    private int tipoingrediente;
    private int medida;
    private int proveedor;
    private String codigo;
    private String descrip;
    private float preciounidad;
    private float rendimiento;
    private String nota;
    private boolean inactivo;

    public Ingrediente(int tipoingrediente, int medida, int proveedor, String codigo, String descrip, float preciounidad, float rendimiento, String nota, boolean inactivo) {
        this.tipoingrediente = tipoingrediente;
        this.medida = medida;
        this.proveedor = proveedor;
        this.codigo = codigo;
        this.descrip = descrip;
        this.preciounidad = preciounidad;
        this.rendimiento = rendimiento;
        this.nota = nota;
        this.inactivo = inactivo;
    }

    public int getTipoingrediente() {
        return tipoingrediente;
    }

    public void setTipoingrediente(int tipoingrediente) {
        this.tipoingrediente = tipoingrediente;
    }

    public int getMedida() {
        return medida;
    }

    public void setMedida(int medida) {
        this.medida = medida;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public float getPreciounidad() {
        return preciounidad;
    }

    public void setPreciounidad(float preciounidad) {
        this.preciounidad = preciounidad;
    }

    public float getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(float rendimiento) {
        this.rendimiento = rendimiento;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public boolean isInactivo() {
        return inactivo;
    }

    public void setInactivo(boolean inactivo) {
        this.inactivo = inactivo;
    }
    
    public static RowMapper<Ingrediente> rowMapper() {
        return (rs) -> {
            return new Ingrediente(
                rs.getInt("iTipoIngrediente"),
                rs.getInt("iMedida"),
                rs.getInt("iProveedor"),
                rs.getString("sCodigo"),
                rs.getString("sDescrip"),
                rs.getFloat("yPrecio"),
                rs.getFloat("rRendimiento"),
                rs.getString("mNota"),
                rs.getBoolean("bInactivo")
            );
        };
    }
}
