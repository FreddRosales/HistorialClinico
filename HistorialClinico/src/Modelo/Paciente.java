/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Paciente {

    private int numHC;
    private String tipodoc;
    private String numdoc;
    private String paterno;
    private String materno;
    private String nombre;
    private String sexo;
    private int edad;
    private String fechanaci;
    private String direccion;
    private String telefono;
    private AntecedentesMedicos antecedentes;
    private ArrayList<Consulta> consultas;

    public Paciente() {
        this.consultas = new ArrayList<>();
    }

    public Paciente(int numHC, String tipodoc, String numdoc, String paterno, String materno,
            String nombre, String sexo, int edad, String fechanaci, String direccion,
            String telefono, AntecedentesMedicos antecedentes) {
        this.numHC = numHC;
        setTipodoc(tipodoc);
        setNumdoc(numdoc);
        setPaterno(paterno);
        setMaterno(materno);
        setNombre(nombre);
        setSexo(sexo);
        setEdad(edad);
        setFechanaci(fechanaci);
        setDireccion(direccion);
        setTelefono(telefono);
        this.antecedentes = antecedentes;
        this.consultas = new ArrayList<>();
    }

    public void agregarConsulta(Consulta nuevaConsulta) {
        this.consultas.add(0, nuevaConsulta);
    }

    public int getNumHC() {
        return numHC;
    }

    public void setNumHC(int numHC) {
        this.numHC = numHC;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    // Valores aceptados: "DNI" o "CE"
    public void setTipodoc(String tipodoc) {
        if (tipodoc == null || (!tipodoc.equals("DNI") && !tipodoc.equals("CE"))) {
            throw new IllegalArgumentException("Tipo de documento inválido. Use 'DNI' o 'CE'.");
        }
        this.tipodoc = tipodoc;
    }

    public String getNumdoc() {
        return numdoc;
    }

    // Para DNI debe contener exactamente 8 dígitos numéricos y CE debe contener 9 dígitos
    public void setNumdoc(String numdoc) {
        if (numdoc == null || numdoc.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de documento no puede estar vacío.");
        }
        if ("DNI".equals(this.tipodoc) && !numdoc.matches("\\d{8}")) {
            throw new IllegalArgumentException("El DNI debe contener exactamente 8 dígitos numéricos.");
        }
        if ("CE".equals(this.tipodoc) && !numdoc.matches("\\d{9}")) {
            throw new IllegalArgumentException("El CE debe contener exactamente 9 dígitos numéricos.");
        }
        this.numdoc = numdoc;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        if (paterno == null || paterno.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Apellido Paterno es obligatorio.");
        }
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        if (materno == null || materno.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Apellido Materno es obligatorio.");
        }
        this.materno = materno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Nombres es obligatorio.");
        }
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    // Valores aceptados: "F" o "M"
    public void setSexo(String sexo) {
        if (sexo == null || (!sexo.equals("F") && !sexo.equals("M"))) {
            throw new IllegalArgumentException("Seleccione un sexo válido: F o M.");
        }
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    // Debe ser un valor entero mayor a 0
    public void setEdad(int edad) {
        if (edad <= 0 || edad > 100) {
            throw new IllegalArgumentException("Ingrese una edad válida.");
        }
        this.edad = edad;
    }

    public String getFechanaci() {
        return fechanaci;
    }

    // Formato dd/mm/aaaa
    public void setFechanaci(String fechanaci) {
        String patron = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        if (fechanaci == null || !fechanaci.matches(patron)) {
            throw new IllegalArgumentException("Ingrese una fecha de nacimiento válida en formato dd/mm/aaaa.");
        }
        this.fechanaci = fechanaci;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Dirección es obligatorio.");
        }
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    // Solo dígitos, 9 caracteres
    public void setTelefono(String telefono) {
        if (telefono == null || !telefono.matches("\\d{9}")) {
            throw new IllegalArgumentException("Ingrese un número de teléfono válido.");
        }
        this.telefono = telefono;
    }

    public AntecedentesMedicos getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(AntecedentesMedicos antecedentes) {
        this.antecedentes = antecedentes;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    public String getNombreCompleto() {
        return nombre + " " + paterno + " " + materno;
    }

    @Override
    public String toString() {
        return "HC-" + numHC + " | " + getNombreCompleto() + " | DNI: " + numdoc;
    }
}
