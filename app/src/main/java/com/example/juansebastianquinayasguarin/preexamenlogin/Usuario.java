package com.example.juansebastianquinayasguarin.preexamenlogin;

/**
 * Created by juansebastianquinayasguarin on 26/2/18.
 */

public class Usuario {
    private String nombre, hotmail, contraseña;

    public Usuario(String nombre, String hotmail, String contraseña) {
        this.nombre = nombre;
        this.hotmail = hotmail;
        this.contraseña = contraseña;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHotmail() {
        return hotmail;
    }

    public void setHotmail(String hotmail) {
        this.hotmail = hotmail;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
