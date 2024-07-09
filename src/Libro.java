public class Libro extends Publicacion {

    private String autor;

    // Constructor de la clase Libro
    public Libro(String titulo, String autor, String descripcion, int cantidadDisp, int numPaginas, String imagen) {
        super(titulo, descripcion, cantidadDisp, numPaginas, imagen);
        this.autor = autor;
    }

    @Override
    public void showInformation() {
        System.out.println("Titulo del libro: " + this.getTitulo());
        System.out.println("Autor del libro: " + this.getAutor());
        System.out.println("Descripcion del libro: " + this.getDescripcion());
        System.out.println("Numero de paginas del libro: " + this.getNumPaginas());
        System.out.println("Copias Disponibles: " + this.getCantidadDisp());
        System.out.println();
    }

    /* Getter y Setter */
    public String getAutor() {
        return autor;
    }

    public void setAutor(String _autor) {
        this.autor = _autor;
    }
    /* Getter y Setter */

}
