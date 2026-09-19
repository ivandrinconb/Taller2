package co.edu.uniquindio.taller2.taller2.model;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConfiguracionBiblioteca {

    private static ConfiguracionBiblioteca instance;
    private String nombre;
    private String direccion;
    private double porcentajeMulta;
    private ObservableList<Usuario> listaUsuarios;
    private ObservableList<Libro> listaLibros;
    private ObservableList<Prestamo> listaPrestamos;


    private ConfiguracionBiblioteca() {
        listaUsuarios = FXCollections.observableArrayList();
        listaLibros = FXCollections.observableArrayList();
        listaPrestamos = FXCollections.observableArrayList();
    }

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
        if (instance == null) {
            instance = new ConfiguracionBiblioteca();
        }
        return instance;
    }

    public static void setInstance(ConfiguracionBiblioteca instance) {
        ConfiguracionBiblioteca.instance = instance;
    }
    public ObservableList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public ObservableList<Libro> getListaLibros() {
        return listaLibros;
    }

    public ObservableList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
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
