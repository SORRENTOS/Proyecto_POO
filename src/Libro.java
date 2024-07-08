public class Libro extends Publicacion {

    // Constructor de la clase Libro
    public Libro(String titulo, String autor, String fechaPublicacion, String categoria, int DOI, int ISBN,
            int numPaginas) {
        // Llamada al constructor de la clase base Publicacion
        super(titulo, autor, fechaPublicacion, categoria, DOI, ISBN, numPaginas);
    }

    @Override
    public void showInformation() {
        System.out.println("Titulo del libro: " + this.getTitulo());
        System.out.println("Autor del libro: " + this.getAutor());
        System.out.println("Categoria del libro: " + this.getCategoria());
        System.out.println("Fecha de publicacion: " + this.getFechaPublicacion());
    }

}
