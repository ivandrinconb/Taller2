package co.edu.uniquindio.taller2.taller2.model;

import javafx.application.Application;

public class ConfiguracionBiblioteca {

    private static ConfiguracionBiblioteca instance;
    private String nombre;
    private String direccion;
    private double porcentajeMulta;

    public ConfiguracionBiblioteca(String nombre, String direccion, double porcentajeMulta) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.porcentajeMulta = porcentajeMulta;
    }
    public static ConfiguracionBiblioteca getInstance(String nombre, String direccion, double porcentajeMulta) {
        if (instance == null) {
            instance = new ConfiguracionBiblioteca(nombre, direccion, porcentajeMulta);
        }
        return instance;

    }

    public static ConfiguracionBiblioteca getInstance() {
        return instance;
    }

    public static void setInstance(ConfiguracionBiblioteca instance) {
        ConfiguracionBiblioteca.instance = instance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public double getPorcentajeMulta() {
        return porcentajeMulta;
    }
    public void setPorcentajeMulta(double porcentajeMulta) {
        this.porcentajeMulta = porcentajeMulta;
    }

}
