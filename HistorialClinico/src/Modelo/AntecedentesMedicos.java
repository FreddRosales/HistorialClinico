/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ACER
 */
public class AntecedentesMedicos {

    private boolean app;
    private boolean cirugias;
    private boolean intoxicacion;
    private double peso;
    private double talla;
    private double imc;
    private String pa;
    private boolean trabajo;
    private boolean deporte;

    public AntecedentesMedicos() {
    }

    public AntecedentesMedicos(boolean app, boolean cirugias, boolean intoxicacion,
            double peso, double talla, String pa, boolean trabajo, boolean deporte) {
        this.app = app;
        this.cirugias = cirugias;
        this.intoxicacion = intoxicacion;
        setPeso(peso);
        setTalla(talla);
        setPa(pa);
        this.trabajo = trabajo;
        this.deporte = deporte;
        this.imc = calcularIMC(this.peso, this.talla);
    }

    public double calcularIMC(double peso, double talla) {
        if (talla <= 0) {
            return 0;
        }
        double tallaMetros = talla / 100.0;
        return peso / (tallaMetros * tallaMetros);
    }

    public boolean isApp() {
        return app;
    }

    public void setApp(boolean app) {
        this.app = app;
    }

    public boolean isCirugias() {
        return cirugias;
    }

    public void setCirugias(boolean cirugias) {
        this.cirugias = cirugias;
    }

    public boolean isIntoxicacion() {
        return intoxicacion;
    }

    public void setIntoxicacion(boolean intoxicacion) {
        this.intoxicacion = intoxicacion;
    }

    public double getPeso() {
        return peso;
    }

    // Debe ser mayor a 0
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

    // Debe ser mayor a 0
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

    public boolean isTrabajo() {
        return trabajo;
    }

    public void setTrabajo(boolean trabajo) {
        this.trabajo = trabajo;
    }

    public boolean isDeporte() {
        return deporte;
    }

    public void setDeporte(boolean deporte) {
        this.deporte = deporte;
    }

    @Override
    public String toString() {
        return "APP: " + (app ? "Sí" : "No")
                + " | Cirugías: " + (cirugias ? "Sí" : "No")
                + " | Intoxicación/Alergias: " + (intoxicacion ? "Sí" : "No")
                + " | Trabajo: " + (trabajo ? "Sí" : "No")
                + " | Deporte: " + (deporte ? "Sí" : "No")
                + " | Peso: " + peso + " kg"
                + " | Talla: " + talla + " cm"
                + " | IMC: " + String.format("%.2f", imc)
                + " | PA: " + pa;
    }
}
