package co.edu.uniquindio.taller2.taller2.model;

public class ReporteUsuario {
    private String usuario;
    private int prestamos;
    private int libros;
    private int retrasos;

    public ReporteUsuario(String usuario, int prestamos, int libros, int retrasos) {
        this.usuario = usuario;
        this.prestamos = prestamos;
        this.libros = libros;
        this.retrasos = retrasos;
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(int prestamos) {
        this.prestamos = prestamos;
    }

    public int getLibros() {
        return libros;
    }

    public void setLibros(int libros) {
        this.libros = libros;
    }

    public int getRetrasos() {
        return retrasos;
    }

    public void setRetrasos(int retrasos) {
        this.retrasos = retrasos;
    }

    @Override
    public String toString() {
        return "ReporteUsuario{" +
                "usuario='" + usuario + '\'' +
                ", prestamos=" + prestamos +
                ", libros=" + libros +
                ", retrasos=" + retrasos +
                '}';
    }
}
