package com.example.dfloresalarcon.appbd;

/**
 * Created by dfloresalarcon on 11/03/15.
 */
public class Contactos {

    private int id;
    private String nombre;
    private int telefono;
    private String email;

    // Constructor de un objeto Contactos
    public Contactos(int id, String nombre, int telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    // Recuperar/establecer ID
    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }

    // Recuperar/establecer NOMBRE
    public String getNOMBRE() {
        return nombre;
    }
    public void setNOMBRE(String nombre) {
        this.nombre = nombre;
    }

    // Recuperar/establecer TELEFONO
    public int getTELEFONO() {
        return telefono;
    }
    public void setTELEFONO(int telefono) {
        this.telefono = telefono;
    }

    // Recuperar/establecer EMAIL
    public String getEMAIL() {
        return email;
    }
    public void setEMAIL(String email) {
        this.email = email;
    }
}
