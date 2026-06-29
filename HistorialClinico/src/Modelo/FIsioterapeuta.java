/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ACER
 */
public class FIsioterapeuta extends Usuario
{

    public FIsioterapeuta(String username, String contraseña, String nombreCompleto) {
        super(username, contraseña, nombreCompleto);
    }

    @Override
    public String getRol() {
        return "FISIOTERAPEUTA";
    }

    @Override
    public boolean puedeRegistrarPaciente() {
        return true;
    }

    @Override
    public boolean puedeVerHistorial() {
        return true;
    }
    
}
