public class Revista extends Publicacion {

    // Constructor de la clase Revista
    public Revista(String titulo, String descripcion, int cantidadDisp, int numPaginas, String imagen) {
        super(titulo, descripcion, cantidadDisp, numPaginas, imagen);
    }

    @Override
    public void showInformation() {
        System.out.println("Titulo revista: " + this.getTitulo());
        System.out.println("Descripcion revista: " + this.getDescripcion());
        System.out.println("Numero de paginas: " + this.getNumPaginas());
        System.out.println("Copias Disponibles: " + this.getCantidadDisp());
        System.out.println();
    }
}
