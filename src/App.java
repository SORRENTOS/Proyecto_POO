import java.util.List;
import java.util.Scanner;

public class App {

    public static int buscarElemento(Database bd, int id, String tipo) {
        switch (tipo) {
            case "l":
                List<Libro> libros = bd.getAllLibros();
                for (Libro lb : libros) {
                    if (lb.getID() == id) {
                        lb.showInformation();
                        return 1;
                    }
                }
                break;
            case "d":
                List<Documento> documentos = bd.getAllDocumentos();
                for (Documento dc : documentos) {
                    if (dc.getID() == id) {
                        dc.showInformation();
                        return 1;
                    }
                }
                break;
            case "r":
                List<Revista> revistas = bd.getAllRevistas();
                for (Revista rv : revistas) {
                    if (rv.getID() == id) {
                        rv.showInformation();
                        return 1;
                    }
                }
                break;
            default:
                break;
        }
        return 0;
    }

    public static void agregarElemento(Database bd, Scanner input) {
        System.out.println(" De que tipo?");
        System.out.println("   1. Libro.");
        System.out.println("   2. Documento.");
        System.out.println("   3. Revista.");
        System.out.println(" Ingrese una opcion:");
        int opcion = input.nextInt();
        switch (opcion) {
            case 1:
                Libro libro;

                System.out.println("Ingrese un identificador al libro:");
                int identificador = input.nextInt();
                input.nextLine(); // Consumir la nueva línea pendiente
                // Si el elemento no existe
                if (buscarElemento(bd, identificador, "l") == 0) {
                    System.out.println("Ingrese titulo del libro a ingresar:");
                    String titulo = input.nextLine();
                    System.out.println("Ingrese autor del libro a ingresar:");
                    String autor = input.nextLine();
                    System.out.println("Ingrese descripcion del libro a ingresar:");
                    String descripcion = input.nextLine();
                    System.out.println("Ingrese cantidad disponible:");
                    int cantidad = input.nextInt();
                    input.nextLine(); // Consumir la nueva línea pendiente
                    System.out.println("Cuantas paginas tiene el libro?:");
                    int paginas = input.nextInt();
                    input.nextLine(); // Consumir la nueva línea pendiente

                    libro = new Libro(identificador, titulo, autor, descripcion, cantidad, paginas, "path/img");

                    bd.insertLibro(libro);
                } else { // Si ya existe el elemento
                    System.out.println(
                            "Ya existe el elemento con ese identificador. Se incrementara la cantidad disponible.");
                    bd.updateCantidadDisp("l", identificador, 1);
                    // Ver Update en la bd
                }
                break;
            case 2:
                Documento documento;

                System.out.println("Ingrese un identificador al documento:");
                int id2 = input.nextInt();
                input.nextLine(); // Consumir la nueva línea pendiente
                if (buscarElemento(bd, id2, "d") == 0) {
                    System.out.println("Ingrese titulo del documento a ingresar:");
                    String t2 = input.nextLine();
                    System.out.println("Ingrese autor del documento a ingresar:");
                    String a2 = input.nextLine();
                    System.out.println("Ingrese descripcion del documento a ingresar:");
                    String d2 = input.nextLine();
                    System.out.println("Ingrese cantidad disponible:");
                    int c2 = input.nextInt();
                    input.nextLine(); // Consumir la nueva línea pendiente
                    System.out.println("Cuantas paginas tiene el documento?:");
                    int p2 = input.nextInt();
                    input.nextLine(); // Consumir la nueva línea pendiente

                    documento = new Documento(id2, t2, a2, d2, c2, p2, "path/img");

                    bd.insertDocumento(documento);
                } else { // Si ya existe el elemento
                    System.out.println(
                            "Ya existe el elemento con ese identificador. Se incrementara la cantidad disponible.");
                    bd.updateCantidadDisp("d", id2, 1);
                }
                break;
            case 3:
                Revista revista;

                System.out.println("Ingrese un identificador a la revista:");
                int id3 = input.nextInt();
                input.nextLine(); // Consumir la nueva línea pendiente
                if (buscarElemento(bd, id3, "r") == 0) {
                    System.out.println("Ingrese titulo de la revista a ingresar:");
                    String t3 = input.nextLine();
                    System.out.println("Ingrese descripcion de la revista a ingresar:");
                    String d3 = input.nextLine();
                    System.out.println("Ingrese cantidad disponible:");
                    int c3 = input.nextInt();
                    input.nextLine(); // Consumir la nueva línea pendiente
                    System.out.println("Cuantas paginas tiene la revista?:");
                    int p3 = input.nextInt();
                    input.nextLine(); // Consumir la nueva línea pendiente

                    revista = new Revista(id3, t3, d3, c3, p3, "path/img");

                    bd.insertRevista(revista);
                } else { // Si ya existe el elemento
                    System.out.println(
                            "Ya existe el elemento con ese identificador. Se incrementara la cantidad disponible.");
                    bd.updateCantidadDisp("r", id3, 1);
                }
                break;
            default:
                break;
        }
    }

    public static void eliminarElemento(Database bd, int id, String tipo) {
        int cantidadDisp = bd.getCantidadDisp(tipo, id);
        if (cantidadDisp > 1) {
            bd.updateCantidadDisp(tipo, id, -1);
            System.out.println("Cantidad disponible disminuida en 1.");
        } else {
            bd.deletePublicacion(tipo, id);
            System.out.println("Elemento eliminado de la base de datos.");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println();
        Scanner input = new Scanner(System.in);

        // Conexion inicial con la BD
        Database pgConn = new Database();
        pgConn.createTablesIfNotExist();

        System.out.println("Bienvenid@ al sistema XXXXX");
        Boolean continuar = true;
        do {
            System.out.println("\n===========================");
            System.out.println("1. Agregar publicacion.");
            System.out.println("2. Revisar publicaciones.");
            System.out.println("3. Buscar publicacion.");
            System.out.println("4. Eliminar publicacion.");
            System.out.println("5. Salir.");
            System.out.println("===========================");
            System.out.println("Ingrese una opcion:");
            int opcion = input.nextInt();
            input.nextLine(); // Consumir la nueva línea pendiente
            switch (opcion) {
                case 1:
                    agregarElemento(pgConn, input);
                    break;
                case 2:
                    List<Libro> listaLibros = pgConn.getAllLibros();
                    List<Documento> listaDocumentos = pgConn.getAllDocumentos();
                    List<Revista> listaRevistas = pgConn.getAllRevistas();

                    System.out.println();
                    System.out.println("Libros disponibles:");
                    for (Libro l : listaLibros) {
                        l.showInformation();
                    }

                    System.out.println("Documentos disponibles:");
                    for (Documento d : listaDocumentos) {
                        d.showInformation();
                    }

                    System.out.println("Revistas disponibles:");
                    for (Revista r : listaRevistas) {
                        r.showInformation();
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el tipo de publicacion a buscar: (l: libro, d: documento, r: revista)");
                    String tipo = input.nextLine();
                    System.out.println("Ingrese el ID de la publicacion a buscar:");
                    int idBuscar = input.nextInt();
                    input.nextLine(); // Consumir la nueva línea pendiente
                    buscarElemento(pgConn, idBuscar, tipo);
                    break;
                case 4:
                    System.out
                            .println("Ingrese el tipo de publicacion a eliminar: (l: libro, d: documento, r: revista)");
                    tipo = input.nextLine();
                    System.out.println("Ingrese el ID de la publicacion a eliminar:");
                    int idEliminar = input.nextInt();
                    input.nextLine(); // Consumir la nueva línea pendiente
                    eliminarElemento(pgConn, idEliminar, tipo);
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
        input.close();
    }
}
