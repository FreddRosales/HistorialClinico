/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ACER
 */
public abstract class Usuario {
    private String username;
    private String contraseña;
    private String nombreCompleto;

    public Usuario(String username, String contraseña, String nombreCompleto) {
        this.username = username;
        this.contraseña = contraseña;
        this.nombreCompleto = nombreCompleto;
    }
    // Métodos abstractos — cada subclase los implementa
    public abstract String getRol();
    public abstract boolean puedeRegistrarPaciente();
    public abstract boolean puedeVerHistorial();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    
}
