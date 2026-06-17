/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Paciente;
import java.util.ArrayList;


/**
 *
 * @author ACER
 */
public class ControladorPaciente {

    private ArrayList<Paciente> listaPacientes;
    private int contadorHC;

    public ControladorPaciente() {
        listaPacientes = new ArrayList<>();
        contadorHC = 1;
    }

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    // REQ-04: no permitir dos pacientes con el mismo DNI
    // (esta validación NO puede ir en el setter porque depende de la lista completa,
    // no de un solo objeto Paciente)
    public boolean existeDNI(String dni) {
        for (Paciente p : listaPacientes) {
            if (p.getNumdoc().equals(dni)) {
                return true;
            }
        }
        return false;
    }

    // REQ-04 (variante para actualización): excluye al propio paciente de la comparación
    public boolean existeDNIEnOtroPaciente(String dni, int numHCExcluir) {
        for (Paciente p : listaPacientes) {
            if (p.getNumdoc().equals(dni) && p.getNumHC() != numHCExcluir) {
                return true;
            }
        }
        return false;
    }

    // REQ-11: registra el paciente y asigna N° HC correlativo
    public int registrarPaciente(Paciente paciente) {
        int nuevoHC = contadorHC;
        paciente.setNumHC(nuevoHC);
        listaPacientes.add(paciente);
        contadorHC++;
        return nuevoHC;
    }

    // REQ-21: búsqueda exacta por DNI (también usado en Registro de Consulta)
    public Paciente buscarPorDNI(String dni) {
        for (Paciente p : listaPacientes) {
            if (p.getNumdoc().equals(dni)) {
                return p;
            }
        }
        return null;
    }

    // REQ-21 y REQ-22: búsqueda por DNI exacto o nombre/apellido parcial
    public ArrayList<Paciente> buscarPacientes(String criterio) {
        ArrayList<Paciente> resultados = new ArrayList<>();
        String criterioLower = criterio.toLowerCase().trim();

        for (Paciente p : listaPacientes) {
            boolean coincideDNI = p.getNumdoc().equals(criterio.trim());
            boolean coincideNombre = p.getNombre().toLowerCase().contains(criterioLower);
            boolean coincideApPaterno = p.getPaterno().toLowerCase().contains(criterioLower);
            boolean coincideApMaterno = p.getMaterno().toLowerCase().contains(criterioLower);

            if (coincideDNI || coincideNombre || coincideApPaterno || coincideApMaterno) {
                resultados.add(p);
            }
        }
        return resultados;
    }
}
