package co.edu.uniquindio.taller2.taller2.model;

public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private String categoria;
    private boolean disponible;

    public Libro(String codigo, String titulo, String autor, String categoria) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponible = true;
    }

    // Getters y setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}