public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();

        Libro libroTest = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "Lorem Ipsum ...", 5, 350,
                "./assets/img/");
        Documento doc = new Documento("Document Title", "Publisher Document", "Lorem ipsum ...", 10, 560,
                "./assets/img/");
        Revista mgzn = new Revista("Some Title", "Some Description", 1, 100, "./assets/img/");

        libroTest.showInformation();
        doc.showInformation();
        mgzn.showInformation();
    }
}
