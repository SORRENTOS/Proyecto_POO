public abstract class Publicacion {

    private String titulo;
    private String descripcion;
    private String imagen;
    private int cantidadDisp;
    private int numPaginas;
    private int id;

    // Constructor de la clase Publicacion
    public Publicacion(int id, String titulo, String descripcion, int cantidadDisp, int numPaginas, String imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cantidadDisp = cantidadDisp;
        this.numPaginas = numPaginas;
        this.imagen = imagen;
        this.id = id;
    }

    abstract public void showInformation();

    /* Getters */
    public int getID() {
        return id;
    }

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
    public void setID(int _id) {
        this.id = _id;
    }

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
