/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ACER
 */
public class Recepcionista extends Usuario{

    public Recepcionista(String username, String contraseña, String nombreCompleto) {
        super(username, contraseña, nombreCompleto);
    }

    @Override
    public String getRol() {
        return "RECEPCIONISTA";
    }

    @Override
    public boolean puedeRegistrarPaciente() {
        return false;
    }

    @Override
    public boolean puedeVerHistorial() {
        return false;
    }
    
}
