public class Documento extends Publicacion {

    private String publicador;

    // Constructor de la clase Documento
    public Documento(String titulo, String publicador, String descripcion, int cantidadDisp, int numPaginas,
            String imagen) {
        super(titulo, descripcion, cantidadDisp, numPaginas, imagen);
        this.publicador = publicador;
    }

    @Override
    public void showInformation() {
        System.out.println("Titulo del documento: " + this.getTitulo());
        System.out.println("Publicador: " + this.getPublicador());
        System.out.println("Descripcion: " + this.getDescripcion());
        System.out.println("Numero de paginas: " + this.getNumPaginas());
        System.out.println("Copias Disponibles: " + this.getCantidadDisp());
        System.out.println();
    }

    /* Getter y Setter */
    public String getPublicador() {
        return publicador;
    }

    public void setPublicador(String _publicador) {
        this.publicador = _publicador;
    }
    /* Getter y Setter */
}
