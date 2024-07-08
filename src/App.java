public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!\n");
        Libro libroTest = new Libro("Titulo Test", "Autor Test", "2024;07;08", "Categoria Test", 2020863, 7387849, 257);

        libroTest.showInformation();
    }
}
