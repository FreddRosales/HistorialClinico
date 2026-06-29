/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import Modelo.FIsioterapeuta;
import Modelo.Recepcionista;
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
        listaUsuarios.add(new FIsioterapeuta("admin", "admin123", "Administrador General"));
        listaUsuarios.add(new Recepcionista("recepcion", "recep123", "Recepcionista Baganet"));
    }

    // Valida usuario y contraseña, retorna el objeto Usuario si es correcto, null si no
    public Usuario validarLogin(String username, String password, String rolSeleccionado) {
    for (Usuario u : listaUsuarios) {
        if (u.getUsername().equals(username) && u.getContraseña().equals(password)) {
            if (u.getRol().equalsIgnoreCase(rolSeleccionado)) {  // equalsIgnoreCase evita problemas de mayúsculas
                return u;
            }
        }
    }
    return null;
    }
}
