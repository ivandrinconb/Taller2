package co.edu.uniquindio.taller2.taller2.model;

import java.time.LocalDate;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean disponible;

    public Prestamo(Usuario usuario, Libro libro, LocalDate fechaPrestamo, LocalDate fechaDevolucion, boolean disponible) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.disponible = disponible;
    }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Libro getLibro() { return libro; }
    public void setLibro(Libro libro) { this.libro = libro; }

    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(LocalDate fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "Prestamo{" +
                "usuario=" + usuario +
                ", libro=" + libro +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                ", disponible=" + disponible +
                '}';
    }
}
