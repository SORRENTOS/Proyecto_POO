public abstract class Publicacion {

    private String titulo;
    private String descripcion;
    private String imagen;
    private int cantidadDisp;
    private int numPaginas;

    // Constructor de la clase Publicacion
    public Publicacion(String titulo, String descripcion, int cantidadDisp, int numPaginas, String imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cantidadDisp = cantidadDisp;
        this.numPaginas = numPaginas;
        this.imagen = imagen;
    }

    abstract public void showInformation();

    /* Getters */
    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public int getCantidadDisp() {
        return cantidadDisp;
    }

    public int getNumPaginas() {
        return numPaginas;
    }
    /* Getters */

    /* Setters */
    public void setTitulo(String _titulo) {
        this.titulo = _titulo;
    }

    public void setDescripcion(String _descripcion) {
        this.descripcion = _descripcion;
    }

    public void setImagen(String _imagen) {
        this.imagen = _imagen;
    }

    public void setCantidadDisp(int _cantidadDisp) {
        this.cantidadDisp = _cantidadDisp;
    }

    public void setNumPaginas(int _numPaginas) {
        this.numPaginas = _numPaginas;
    }
    /* Setters */
}
