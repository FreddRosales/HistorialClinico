/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class ControladorUsuario 
{
    private ArrayList<Usuario> listaUsuarios;

    public ControladorUsuario() {
        listaUsuarios = new ArrayList<>();
        cargarUsuariosIniciales();
    }

    // Usuarios precargados (mientras no hay BD - Solución C del informe)
    private void cargarUsuariosIniciales() {
        listaUsuarios.add(new Usuario("admin", "admin123", "ADMIN", "Administrador General"));
        listaUsuarios.add(new Usuario("recepcion", "recep123", "RECEPCIONISTA", "Recepcionista Baganet"));
    }

    // Valida usuario y contraseña, retorna el objeto Usuario si es correcto, null si no
    public Usuario validarLogin(String username, String password, String rolSeleccionado) {
        for (Usuario u : listaUsuarios) {
            if (u.getUsername().equals(username) && u.getContraseña().equals(password)) {
                // Validamos que el rol coincida con lo seleccionado
                if (rolSeleccionado.equals("Fisioterapeuta") && u.getRol().equals("ADMIN")) {
                    return u;
                } else if (rolSeleccionado.equals("Recepcionista") && u.getRol().equals("RECEPCIONISTA")) {
                    return u;
                }
            }
        }
        return null;
    }
}
