public abstract class Publicacion {

    private String titulo;
    private String autor;
    private String fechaPublicacion;
    private String categoria;
    private int DOI;
    private int ISBN;
    private int numPaginas;

    // Constructor de la clase Publicacion
    public Publicacion(String titulo, String autor, String fechaPublicacion, String categoria, int DOI, int ISBN,
            int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.categoria = categoria;
        this.DOI = DOI;
        this.ISBN = ISBN;
        this.numPaginas = numPaginas;
    }

    abstract public void showInformation();

    /* Getters */
    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getFechaPublicacion() {
        return this.fechaPublicacion;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public int getDOI() {
        return this.DOI;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public int getNumPaginas() {
        return this.numPaginas;
    }
    /* Getters */

    /* Setters */
    public void setTitulo(String _titulo) {
        this.titulo = _titulo;
    }

    public void setAutor(String _autor) {
        this.autor = _autor;
    }

    public void setFechaPublicacion(String _fecha) {
        this.fechaPublicacion = _fecha;
    }

    public void setCategoria(String _categoria) {
        this.categoria = _categoria;
    }

    public void setDOI(int _DOI) {
        DOI = _DOI;
    }

    public void setISBN(int _ISBN) {
        ISBN = _ISBN;
    }

    public void setNumPaginas(int _numPaginas) {
        this.numPaginas = _numPaginas;
    }
    /* Setters */
}
