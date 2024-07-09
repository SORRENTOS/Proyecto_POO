import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static int buscarElemento(ArrayList<Publicacion> publicaciones, int id) {
        for (int i = 0; i < publicaciones.size(); i++) {
            if (publicaciones.get(i).getID() == id) {
                publicaciones.get(i).showInformation();
                return 1;
            }
        }
        return 0;
    }

    public static void agregarElemento(ArrayList<Publicacion> publicaciones, Scanner input) {
        System.out.println(" De que tipo?");
        System.out.println("   1. Libro.");
        System.out.println("   2. Documento.");
        System.out.println("   3. Revista.");
        System.out.println(" Ingrese una opcion:");
        int opcion = input.nextInt();
        switch (opcion) {
            case 1:
                Publicacion libro;

                System.out.println("Ingrese un identificador al libro:");
                int identificador = input.nextInt();
                input.nextLine(); // Consumir la nueva línea pendiente
                // Si el elemento no existe
                if (buscarElemento(publicaciones, identificador) == 0) {
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
                    publicaciones.add(libro);

                    System.out.println("Libro agregado!");
                } else { // Si ya existe el elemento
                    System.out.println(
                            "Ya existe el elmemento con ese identificador. Se incrementara la cantidad disponible.");
                    for (int i = 0; i < publicaciones.size(); i++) {
                        if (publicaciones.get(i).getID() == identificador) {
                            publicaciones.get(i).setCantidadDisp(publicaciones.get(i).getCantidadDisp() + 1);
                        }
                    }
                }
                break;
            case 2:
                Publicacion documento;

                System.out.println("Ingrese un identificador al documento:");
                int id2 = input.nextInt();
                input.nextLine(); // Consumir la nueva línea pendiente
                if (buscarElemento(publicaciones, id2) == 0) {
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
                    publicaciones.add(documento);

                    System.out.println("Documento agregado!");
                } else { // Si ya existe el elemento
                    System.out.println(
                            "Ya existe el elmemento con ese identificador. Se incrementara la cantidad disponible.");
                    for (int i = 0; i < publicaciones.size(); i++) {
                        if (publicaciones.get(i).getID() == id2) {
                            publicaciones.get(i).setCantidadDisp(publicaciones.get(i).getCantidadDisp() + 1);
                        }
                    }
                }
                break;
            case 3:
                Publicacion revista;

                System.out.println("Ingrese un identificador a la revista:");
                int id3 = input.nextInt();
                input.nextLine(); // Consumir la nueva línea pendiente
                if (buscarElemento(publicaciones, id3) == 0) {
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
                    publicaciones.add(revista);

                    System.out.println("Revista agregada!");
                } else { // Si ya existe el elemento
                    System.out.println(
                            "Ya existe el elmemento con ese identificador. Se incrementara la cantidad disponible.");
                    for (int i = 0; i < publicaciones.size(); i++) {
                        if (publicaciones.get(i).getID() == id3) {
                            publicaciones.get(i).setCantidadDisp(publicaciones.get(i).getCantidadDisp() + 1);
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    public static int eliminarElemento(ArrayList<Publicacion> publicaciones, int id) {
        for (int i = 0; i < publicaciones.size(); i++) {
            if (publicaciones.get(i).getID() == id) {
                if (publicaciones.get(i).getCantidadDisp() > 0) {
                    publicaciones.get(i).setCantidadDisp(publicaciones.get(i).getCantidadDisp() - 1);
                } else {
                    publicaciones.remove(i);
                }
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println();
        ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
        Scanner input = new Scanner(System.in);

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
                    agregarElemento(publicaciones, input);
                    break;
                case 2:
                    for (int i = 0; i < publicaciones.size(); i++) {
                        publicaciones.get(i).showInformation();
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el ID de la publicacion a buscar:");
                    int idBuscar = input.nextInt();
                    input.nextLine(); // Consumir la nueva línea pendiente
                    buscarElemento(publicaciones, idBuscar);
                    break;
                case 4:
                    System.out.println("Ingrese el ID de la publicacion a eliminar:");
                    int idEliminar = input.nextInt();
                    input.nextLine(); // Consumir la nueva línea pendiente
                    int eliminado = eliminarElemento(publicaciones, idEliminar);
                    if (eliminado == 0) {
                        System.out.println("No se encontro el elemento para eliminar.");
                    } else {
                        System.out.println("Elemento eliminado!");
                    }
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
        input.close();
    }
}
