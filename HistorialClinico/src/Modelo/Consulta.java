/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ACER
 */
public class Consulta implements Calculable{

    private String fecha;
    private String motivoconsulta;
    private double peso;
    private double talla;
    private double imc;
    private String pa;
    private String o3;
    private String prp;
    private String terapia;
    private String indicaciones;
    private String diagnostico;

    public Consulta() {
    }

    public Consulta(String fecha, String motivoconsulta, double peso, double talla,
            String pa, String o3, String prp, String terapia, String indicaciones, String diagnostico) {
        setFecha(fecha);
        setMotivoconsulta(motivoconsulta);
        setPeso(peso);
        setTalla(talla);
        setPa(pa);
        this.o3 = o3;
        this.prp = prp;
        this.terapia = terapia;
        this.indicaciones = indicaciones;
        setDiagnostico(diagnostico);
        this.imc = calcularIMC(this.peso, this.talla);
    }
    
    @Override
    public double calcularIMC(double peso, double talla) {
        if (talla <= 0) {
            return 0;
        }
        double tallaMetros = talla / 100.0;
        return peso / (tallaMetros * tallaMetros);
    }

    public String getFecha() {
        return fecha;
    }

    // No puede estar vacío, formato dd/mm/aaaa
    public void setFecha(String fecha) {
        String patron = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        if (fecha == null || !fecha.matches(patron)) {
            throw new IllegalArgumentException("Ingrese una fecha válida en formato dd/mm/aaaa.");
        }
        this.fecha = fecha;
    }

    public String getMotivoconsulta() {
        return motivoconsulta;
    }

    // No puede estar vacío
    public void setMotivoconsulta(String motivoconsulta) {
        if (motivoconsulta == null || motivoconsulta.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Motivo de Consulta es obligatorio.");
        }
        this.motivoconsulta = motivoconsulta;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser un valor mayor a 0.");
        }
        this.peso = peso;
        this.imc = calcularIMC(this.peso, this.talla);
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        if (talla <= 0) {
            throw new IllegalArgumentException("La talla debe ser un valor mayor a 0.");
        }
        this.talla = talla;
        this.imc = calcularIMC(this.peso, this.talla);
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getPa() {
        return pa;
    }

    // Formato sistólica/diastólica, ej: "120/80"
    public void setPa(String pa) {
        if (pa == null || !pa.matches("\\d{2,3}/\\d{2,3}")) {
            throw new IllegalArgumentException("La presión arterial debe tener formato sistólica/diastólica, ej: 120/80.");
        }
        this.pa = pa;
    }

    public String getO3() {
        return o3;
    }

    // Campo opcional - sin validación de obligatoriedad
    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getPrp() {
        return prp;
    }

    // Campo opcional
    public void setPrp(String prp) {
        this.prp = prp;
    }

    public String getTerapia() {
        return terapia;
    }

    // Campo opcional
    public void setTerapia(String terapia) {
        this.terapia = terapia;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    // Campo opcional
    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    // No puede estar vacío
    public void setDiagnostico(String diagnostico) {
        if (diagnostico == null || diagnostico.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Diagnóstico es obligatorio.");
        }
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha
                + " | Motivo: " + motivoconsulta
                + " | IMC: " + String.format("%.2f", imc)
                + " | Diagnóstico: " + diagnostico;
    }
}
